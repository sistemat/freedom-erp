package org.freedom.persist.entity;

// Generated 20/11/2013 10:59:59 by Hibernate Tools 4.0.0

/**
 * RhcandidatocaracId generated by hbm2java
 */
public class RhcandidatocaracId implements java.io.Serializable {

	private int codcand;
	private short codfilial;
	private int codemp;
	private String codcarac;
	private short codfilialct;
	private int codempct;

	public RhcandidatocaracId() {
	}

	public RhcandidatocaracId(int codcand, short codfilial, int codemp,
			String codcarac, short codfilialct, int codempct) {
		this.codcand = codcand;
		this.codfilial = codfilial;
		this.codemp = codemp;
		this.codcarac = codcarac;
		this.codfilialct = codfilialct;
		this.codempct = codempct;
	}

	public int getCodcand() {
		return this.codcand;
	}

	public void setCodcand(int codcand) {
		this.codcand = codcand;
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

	public String getCodcarac() {
		return this.codcarac;
	}

	public void setCodcarac(String codcarac) {
		this.codcarac = codcarac;
	}

	public short getCodfilialct() {
		return this.codfilialct;
	}

	public void setCodfilialct(short codfilialct) {
		this.codfilialct = codfilialct;
	}

	public int getCodempct() {
		return this.codempct;
	}

	public void setCodempct(int codempct) {
		this.codempct = codempct;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RhcandidatocaracId))
			return false;
		RhcandidatocaracId castOther = (RhcandidatocaracId) other;

		return (this.getCodcand() == castOther.getCodcand())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp())
				&& ((this.getCodcarac() == castOther.getCodcarac()) || (this
						.getCodcarac() != null
						&& castOther.getCodcarac() != null && this
						.getCodcarac().equals(castOther.getCodcarac())))
				&& (this.getCodfilialct() == castOther.getCodfilialct())
				&& (this.getCodempct() == castOther.getCodempct());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodcand();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		result = 37 * result
				+ (getCodcarac() == null ? 0 : this.getCodcarac().hashCode());
		result = 37 * result + this.getCodfilialct();
		result = 37 * result + this.getCodempct();
		return result;
	}

}
