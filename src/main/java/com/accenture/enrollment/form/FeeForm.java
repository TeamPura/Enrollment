package com.accenture.enrollment.form;

import java.io.Serializable;

public class FeeForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private int feeId;
	private String descripton;
	private float fee;
	private int subjId;

	public FeeForm() {
	}

	public int getFeeId() {
		return this.feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public String getDescripton() {
		return this.descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getSubjId() {
		return this.subjId;
	}

	public void setSubjId(int subjId) {
		this.subjId = subjId;
	}

}