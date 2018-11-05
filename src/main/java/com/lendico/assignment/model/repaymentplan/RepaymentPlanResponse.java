package com.lendico.assignment.model.repaymentplan;

import java.io.Serializable;

/**
 * The Class RepaymentPlanResponse.
 */
public class RepaymentPlanResponse implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The borrower payment amount. */
	private Double borrowerPaymentAmount;
	
	/** The date. */
	private String date;
	
	/** The initial outstanding principal. */
	private Double initialOutstandingPrincipal;
	
	/** The interest. */
	private Double interest;
	
	/** The principal. */
	private Double principal;
	
	/** The remaining outstanding principal. */
	private Double remainingOutstandingPrincipal;

	/**
	 * @return the borrowerPaymentAmount
	 */
	public Double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	/**
	 * @param borrowerPaymentAmount the borrowerPaymentAmount to set
	 */
	public void setBorrowerPaymentAmount(Double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the initialOutstandingPrincipal
	 */
	public Double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	/**
	 * @param initialOutstandingPrincipal the initialOutstandingPrincipal to set
	 */
	public void setInitialOutstandingPrincipal(Double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	/**
	 * @return the interest
	 */
	public Double getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(Double interest) {
		this.interest = interest;
	}

	/**
	 * @return the principal
	 */
	public Double getPrincipal() {
		return principal;
	}

	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	/**
	 * @return the remainingOutstandingPrincipal
	 */
	public Double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	/**
	 * @param remainingOutstandingPrincipal the remainingOutstandingPrincipal to set
	 */
	public void setRemainingOutstandingPrincipal(Double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RepaymentPlanResponse [borrowerPaymentAmount=" + borrowerPaymentAmount + ", date=" + date
				+ ", initialOutstandingPrincipal=" + initialOutstandingPrincipal + ", interest=" + interest
				+ ", principal=" + principal + ", remainingOutstandingPrincipal=" + remainingOutstandingPrincipal + "]";
	}
}
