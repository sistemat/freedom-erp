package org.freedom.persist.entity;

// Generated 20/11/2013 10:59:59 by Hibernate Tools 4.0.0

/**
 * PpitopId generated by hbm2java
 */
public class PpitopId implements java.io.Serializable {

	private int codop;
	private short seqop;
	private short seqitop;
	private short codfilial;
	private int codemp;

	public PpitopId() {
	}

	public PpitopId(int codop, short seqop, short seqitop, short codfilial,
			int codemp) {
		this.codop = codop;
		this.seqop = seqop;
		this.seqitop = seqitop;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	public int getCodop() {
		return this.codop;
	}

	public void setCodop(int codop) {
		this.codop = codop;
	}

	public short getSeqop() {
		return this.seqop;
	}

	public void setSeqop(short seqop) {
		this.seqop = seqop;
	}

	public short getSeqitop() {
		return this.seqitop;
	}

	public void setSeqitop(short seqitop) {
		this.seqitop = seqitop;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PpitopId))
			return false;
		PpitopId castOther = (PpitopId) other;

		return (this.getCodop() == castOther.getCodop())
				&& (this.getSeqop() == castOther.getSeqop())
				&& (this.getSeqitop() == castOther.getSeqitop())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodop();
		result = 37 * result + this.getSeqop();
		result = 37 * result + this.getSeqitop();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
