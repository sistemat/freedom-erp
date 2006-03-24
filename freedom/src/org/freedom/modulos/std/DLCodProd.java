/**
 * @version 16/03/2006 <BR>
 * @author Setpoint Inform�tica Ltda./Alex Rodrigues <BR>
 *
 * Projeto: Freedom <BR>
 *  
 * Pacote: org.freedom.modulos.std <BR>
 * Classe: @(#)DLCodProd.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Tela para busca de produto pelo c�digo de barras
 */

package org.freedom.modulos.std;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import org.freedom.componentes.ListaCampos;
import org.freedom.componentes.Tabela;
import org.freedom.funcoes.Funcoes;
import org.freedom.telas.Aplicativo;
import org.freedom.telas.FFDialogo;

public class DLCodProd extends FFDialogo implements KeyListener {

	private static final long serialVersionUID = 1L;
	public Tabela tab = new Tabela();
	private JScrollPane spnCentro = new JScrollPane(tab); 
	private int iCodProd = 0;
	private boolean bFilCodProd = false;
	private boolean bFilRefProd = false;
	private boolean bFilCodBar = false;
	private boolean bFilCodFab = false;
	private Vector vProds = new Vector();
	private JComponent proxFoco = null;
	
	public DLCodProd(Connection con, JComponent proxFoco) {

		setTitulo("Pesquisa auxiliar");
		setAtribos( 575, 260);		
	    setResizable(true);	 
		setConexao(con);
		this.proxFoco = proxFoco;
	    
	    c.add( spnCentro, BorderLayout.CENTER);    
	    
	    addWindowFocusListener( new WindowAdapter() {
			 public void windowGainedFocus(WindowEvent e) {
	            if (tab.getNumLinhas() > 0)
	              tab.requestFocus();
	            else
	              btCancel.requestFocus();
			 }
	       }
	    );
		 
		tab.adicColuna("C�d.prod.");
		tab.adicColuna("Ref.prod.");
		tab.adicColuna("C�d.bar.prod.");
		tab.adicColuna("C�d.fab.prod.");
		tab.adicColuna("Descri��o do produto");    
		tab.adicColuna("lote");
		tab.adicColuna("Validade");   	  
		tab.adicColuna("Saldo");   	
		tab.adicColuna("C�d.amox.");
		tab.setTamColuna(80,0);
		tab.setTamColuna(80,1);
		tab.setTamColuna(80,2);
		tab.setTamColuna(80,3);
		tab.setTamColuna(160,4);
		tab.setTamColuna(80,5); 
		tab.setTamColuna(80,6);
		tab.setTamColuna(80,7);
		tab.setTamColuna(80,8); 
		
		setTitulo("Saldo do produto nos almoxarifados");
		tab.addKeyListener(this);
		
		getPrefere();
		
	}
	
	public void passaFocus() {
		if(proxFoco!=null)
			proxFoco.requestFocus();
	}
	
	public boolean buscaCodProd(String valor) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sSQL = null;
		String sWhere = "";
		boolean usaOR = false;
		boolean adicCodProd = false;
		
		if(valor == null || valor.trim().length() <= 0)
			return false;		
		
		try{
			
			vProds.clear();
			tab.limpa();
			iCodProd = 0;
			
			if(bFilCodBar)
				sWhere = "AND (P.CODBARPROD=?) ";
			if(bFilCodProd) {
				try{
					int val = Integer.parseInt(valor);
					if(val < Integer.MAX_VALUE && val < Integer.MIN_VALUE ) {
						if(sWhere.length()>0) {
							sWhere += " OR (P.CODPROD=?) ";
							usaOR = true;
						}
						sWhere = "AND P.CODPROD=? ";
						adicCodProd = true;
					}
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
			}
			if(bFilRefProd)
				if(sWhere.length()>0) {
					sWhere += " OR (P.REFPROD=?) ";
					usaOR = true;
				}
				else
					sWhere = "AND (P.REFPROD=?) ";			
			if(bFilCodFab)
				if(sWhere.length()>0) {
					sWhere += " OR (P.CODFABPROD=?) ";
					usaOR = true;
				}
				else
					sWhere = "AND (P.CODFABPROD=?) ";
			if(usaOR)
				sWhere = " AND (" + sWhere.substring(4,sWhere.length()) +") ";
			
					
				
			sSQL =  "SELECT P.CODPROD, P.REFPROD, P.CODBARPROD, P.CODFABPROD, P.DESCPROD, " +
					"L.CODLOTE, L.VENCTOLOTE, L.SLDLOTE, A.CODALMOX " +
					"FROM EQPRODUTO P, EQLOTE L, EQALMOX A " +
					"WHERE P.CODEMP=? AND P.CODFILIAL=? " +
					sWhere +
					"AND L.CODEMP=P.CODEMP AND L.CODFILIAL=P.CODFILIAL AND L.CODPROD=P.CODPROD " +
					"AND A.CODEMP=P.CODEMPAX AND A.CODFILIAL=P.CODFILIALAX AND A.CODALMOX=P.CODALMOX " +
					"AND L.VENCTOLOTE = ( SELECT MIN(VENCTOLOTE) " +
					                     "FROM EQLOTE LS " +
					                     "WHERE LS.CODPROD=L.CODPROD AND LS.CODFILIAL=L.CODFILIAL " +
					                     "AND LS.CODEMP=L.CODEMP AND LS.SLDLIQLOTE>0 " +
					                     "AND VENCTOLOTE >= CAST('today' AS DATE) ) ";
			
			ps = con.prepareStatement(sSQL);
			int iparam = 1;
			ps.setInt(iparam++, Aplicativo.iCodEmp);
			ps.setInt(iparam++, ListaCampos.getMasterFilial("EQPRODUTO"));
			if(bFilCodBar)
				ps.setString(iparam++, valor);
			if(adicCodProd)
				ps.setString(iparam++, valor);
			if(bFilRefProd)
				ps.setString(iparam++, valor);
			if(bFilCodFab)
				ps.setString(iparam++, valor);
			
			rs = ps.executeQuery();
			
			int ilinha = 0;
			while(rs.next()) {
				tab.adicLinha( new Object[]{(rs.getString("CODPROD") != null ? rs.getString("CODPROD") : ""),
											(rs.getString("REFPROD") != null ? rs.getString("REFPROD") : ""),
											(rs.getString("CODBARPROD") != null ? rs.getString("CODBARPROD") : ""),
											(rs.getString("CODFABPROD") != null ? rs.getString("CODFABPROD") : ""),
											(rs.getString("DESCPROD") != null ? rs.getString("DESCPROD") : ""),
											(rs.getString("CODLOTE") != null ? rs.getString("CODLOTE") : ""),
											(rs.getString("VENCTOLOTE") != null ? rs.getString("VENCTOLOTE") : ""),
											(rs.getString("SLDLOTE") != null ? rs.getString("SLDLOTE") : ""),
											(rs.getString("CODALMOX") != null ? rs.getString("CODALMOX") : "")});
				ilinha++;
				vProds.addElement(new Integer(rs.getString("CODPROD") != null ? rs.getString("CODPROD") : "0"));
			}
			
			/*tab.adicLinha( new Object[]{"0","","","","","","","",""});
			vProds.addElement(new Integer(0));*/
			
			if(ilinha <= 0) {
				Funcoes.mensagemErro(this, "C�digo Invalido!");
				return false;
			}
			else if(ilinha == 1) {
				iCodProd = ((Integer)vProds.elementAt(0)).intValue();
				super.ok();
			}
			else {
				tab.changeSelection(0,0,true,true);
				tab.setLinhaSel(0);
				setVisible(true);
			}
			
		} catch (SQLException e) {
			Funcoes.mensagemErro(this, "Erro ao buscar produtos por c�digo de barras!\n"+
					e.getMessage(), true, con, e);
			e.printStackTrace();
			return false;
		} finally {
			ps = null;
			rs = null;
			sSQL = null;			
		}
		
		return true;
		
	}

	public int getCodProd() {
		return iCodProd;
	}
	
	private void getPrefere() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sSQL = null;
		
		try{
			
			sSQL =  "SELECT FILBUSCGENPROD, FILBUSCGENREF, FILBUSCGENCODBAR, FILBUSCGENCODFAB " +
					"FROM SGPREFERE1 " +
					"WHERE CODEMP=? AND CODFILIAL=?";
			
			ps = con.prepareStatement(sSQL);
			ps.setInt(1, Aplicativo.iCodEmp);
			ps.setInt(2, ListaCampos.getMasterFilial("SGPREFERE1"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				bFilCodProd = (rs.getString(1)!=null && rs.getString(1).equals("S")) ? true : false;
				bFilRefProd = (rs.getString(2)!=null && rs.getString(2).equals("S")) ? true : false;
				bFilCodBar  = (rs.getString(3)!=null && rs.getString(3).equals("S")) ? true : false;
				bFilCodFab  = (rs.getString(4)!=null && rs.getString(4).equals("S")) ? true : false;
			}
			
		} catch (SQLException e) {
			Funcoes.mensagemErro(this, "Erro ao buscar filtros!\n"+
					e.getMessage(), true, con, e);
			e.printStackTrace();
		} finally {
			ps = null;
			rs = null;
			sSQL = null;			
		}
		
	}

    public void keyPressed(KeyEvent kevt) {
    	if ( kevt.getSource() == tab && kevt.getKeyCode() == KeyEvent.VK_ENTER) {       
    		int ilin = tab.getLinhaSel();
        	iCodProd = 0;
        	if (tab.getNumLinhas() > 0 && ilin >= 0) {
        		iCodProd = ((Integer)vProds.elementAt(ilin)).intValue();
        		passaFocus();
        		super.ok();
        	} else {
        		Funcoes.mensagemInforma(this, "Nenhum produto foi selecionado.");
        		iCodProd = 0;
        	}
    	}
    	else
    		super.keyPressed(kevt);
    }
    
    public void keyReleased(KeyEvent kevt) { }
    
    public void keyTyped(KeyEvent kevt) { }
        
}        
