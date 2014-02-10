package com.accenture.enrollment.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fees database table.
 * 
 */
@Entity
@Table(name="fees")
public class Fee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fee_id")
	private int feeId;

	@Lob
	private String descripton;

	private float fee;

	@Column(name="subj_id")
	private int subjId;

	public Fee() {
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