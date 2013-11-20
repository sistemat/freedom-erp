package org.freedom.persist.entity;

// Generated 20/11/2013 10:59:59 by Hibernate Tools 4.0.0

/**
 * AtconvatribtbId generated by hbm2java
 */
public class AtconvatribtbId implements java.io.Serializable {

	private int codittb;
	private short codtb;
	private short codfilialtb;
	private int codemptb;
	private short seqconvatrib;
	private int codconv;
	private short codfilial;
	private int codemp;

	public AtconvatribtbId() {
	}

	public AtconvatribtbId(int codittb, short codtb, short codfilialtb,
			int codemptb, short seqconvatrib, int codconv, short codfilial,
			int codemp) {
		this.codittb = codittb;
		this.codtb = codtb;
		this.codfilialtb = codfilialtb;
		this.codemptb = codemptb;
		this.seqconvatrib = seqconvatrib;
		this.codconv = codconv;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	public int getCodittb() {
		return this.codittb;
	}

	public void setCodittb(int codittb) {
		this.codittb = codittb;
	}

	public short getCodtb() {
		return this.codtb;
	}

	public void setCodtb(short codtb) {
		this.codtb = codtb;
	}

	public short getCodfilialtb() {
		return this.codfilialtb;
	}

	public void setCodfilialtb(short codfilialtb) {
		this.codfilialtb = codfilialtb;
	}

	public int getCodemptb() {
		return this.codemptb;
	}

	public void setCodemptb(int codemptb) {
		this.codemptb = codemptb;
	}

	public short getSeqconvatrib() {
		return this.seqconvatrib;
	}

	public void setSeqconvatrib(short seqconvatrib) {
		this.seqconvatrib = seqconvatrib;
	}

	public int getCodconv() {
		return this.codconv;
	}

	public void setCodconv(int codconv) {
		this.codconv = codconv;
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
		if (!(other instanceof AtconvatribtbId))
			return false;
		AtconvatribtbId castOther = (AtconvatribtbId) other;

		return (this.getCodittb() == castOther.getCodittb())
				&& (this.getCodtb() == castOther.getCodtb())
				&& (this.getCodfilialtb() == castOther.getCodfilialtb())
				&& (this.getCodemptb() == castOther.getCodemptb())
				&& (this.getSeqconvatrib() == castOther.getSeqconvatrib())
				&& (this.getCodconv() == castOther.getCodconv())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodittb();
		result = 37 * result + this.getCodtb();
		result = 37 * result + this.getCodfilialtb();
		result = 37 * result + this.getCodemptb();
		result = 37 * result + this.getSeqconvatrib();
		result = 37 * result + this.getCodconv();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
