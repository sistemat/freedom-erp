package org.freedom.persist.entity;

// Generated 20/11/2013 10:59:59 by Hibernate Tools 4.0.0

/**
 * CrqualificacaoId generated by hbm2java
 */
public class CrqualificacaoId implements java.io.Serializable {

	private short codfilial;
	private int codemp;
	private int codqualific;

	public CrqualificacaoId() {
	}

	public CrqualificacaoId(short codfilial, int codemp, int codqualific) {
		this.codfilial = codfilial;
		this.codemp = codemp;
		this.codqualific = codqualific;
	}

	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public int getCodqualific() {
		return this.codqualific;
	}

	public void setCodqualific(int codqualific) {
		this.codqualific = codqualific;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CrqualificacaoId))
			return false;
		CrqualificacaoId castOther = (CrqualificacaoId) other;

		return (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp())
				&& (this.getCodqualific() == castOther.getCodqualific());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		result = 37 * result + this.getCodqualific();
		return result;
	}

}
