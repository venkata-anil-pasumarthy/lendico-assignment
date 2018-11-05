package com.lendico.assignment.model.repaymentplan;

import java.io.Serializable;

/**
 * The Class RepaymentPlanRequestWrapper
 *
 */
public class RepaymentPlanRequestWrapper implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The loan amount. */
	private Double loanAmount;
	
	/** The nominal rate. */
	private Float nominalRate;
	
	/** The duration. */
	private Long duration;
	
	/** The start date. */
	private String startDate;
	
	/**
	 * @return the loanAmount
	 */
	public Double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the nominalRate
	 */
	public Float getNominalRate() {
		return nominalRate;
	}

	/**
	 * @param nominalRate the nominalRate to set
	 */
	public void setNominalRate(Float nominalRate) {
		this.nominalRate = nominalRate;
	}

	/**
	 * @return the duration
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RepaymentPlanRequestWrapper [loanAmount=" + loanAmount + ", nominalRate=" + nominalRate + ", duration="
				+ duration + ", startDate=" + startDate + "]";
	}
}
