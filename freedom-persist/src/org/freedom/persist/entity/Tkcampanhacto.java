package org.freedom.persist.entity;

// Generated 20/11/2013 10:59:59 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Tkcampanhacto generated by hbm2java
 */
public class Tkcampanhacto implements java.io.Serializable {

	private TkcampanhactoId id;
	private Tkcontato tkcontato;
	private Vdcliente vdcliente;
	private Tkcampanha tkcampanha;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Tkcampanhacto() {
	}

	public Tkcampanhacto(TkcampanhactoId id, Tkcampanha tkcampanha, Date dtins,
			Date hins, String idusuins) {
		this.id = id;
		this.tkcampanha = tkcampanha;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Tkcampanhacto(TkcampanhactoId id, Tkcontato tkcontato,
			Vdcliente vdcliente, Tkcampanha tkcampanha, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt) {
		this.id = id;
		this.tkcontato = tkcontato;
		this.vdcliente = vdcliente;
		this.tkcampanha = tkcampanha;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	public TkcampanhactoId getId() {
		return this.id;
	}

	public void setId(TkcampanhactoId id) {
		this.id = id;
	}

	public Tkcontato getTkcontato() {
		return this.tkcontato;
	}

	public void setTkcontato(Tkcontato tkcontato) {
		this.tkcontato = tkcontato;
	}

	public Vdcliente getVdcliente() {
		return this.vdcliente;
	}

	public void setVdcliente(Vdcliente vdcliente) {
		this.vdcliente = vdcliente;
	}

	public Tkcampanha getTkcampanha() {
		return this.tkcampanha;
	}

	public void setTkcampanha(Tkcampanha tkcampanha) {
		this.tkcampanha = tkcampanha;
	}

	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

}
