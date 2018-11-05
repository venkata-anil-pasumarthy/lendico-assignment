package com.lendico.assignment.processor.repaymentplan;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lendico.assignment.common.Constants;
import com.lendico.assignment.model.repaymentplan.RepaymentPlanRequestWrapper;
import com.lendico.assignment.model.repaymentplan.RepaymentPlanResponse;

/**
 * The Class RepaymentPlanGeneratorProcessor.
 */
@Component
public class RepaymentPlanGeneratorProcessor {
	
	/** The log. */
	private static final Logger logger = LoggerFactory.getLogger(RepaymentPlanGeneratorProcessor.class);
		
	public List<RepaymentPlanResponse> getRepaymentPlanSchedule(RepaymentPlanRequestWrapper requestWrapper) throws Exception, RuntimeException {
		try {
			logger.info("Start of RepaymentPlanGeneratorProcessor.getRepaymentPlanSchedule() method.");
			List<RepaymentPlanResponse> repaymentPlanResponse = new ArrayList<RepaymentPlanResponse>();
			double presentValue = requestWrapper.getLoanAmount();		
			long duration = requestWrapper.getDuration();		
			float monthlyInterest = (requestWrapper.getNominalRate() * Constants.DAYS_IN_A_MONTH  ) /
					(Constants.VALUE_HUNDRED * Constants.DAYS_IN_A_YEAR);
			String date = requestWrapper.getStartDate();
					
			double borrowerPaymentAmount = calculateAnnuity(presentValue, duration, monthlyInterest);		
			borrowerPaymentAmount = decimalFormatter(borrowerPaymentAmount);
			
			setRepaymentPlanResponse(repaymentPlanResponse, presentValue, duration, monthlyInterest, date,
					borrowerPaymentAmount);
			
			logger.info(repaymentPlanResponse.toString());
			logger.info("End of RepaymentPlanGeneratorProcessor.getRepaymentPlanSchedule() method.");			
			return repaymentPlanResponse;
		}catch (NumberFormatException nfe) {
			throw nfe;
		}
		catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param repaymentPlanResponse
	 * @param presentValue
	 * @param duration
	 * @param monthlyInterest
	 * @param date
	 * @param borrowerPaymentAmount
	 * @throws ParseException
	 */
	private void setRepaymentPlanResponse(List<RepaymentPlanResponse> repaymentPlanResponse, double presentValue,
			long duration, float monthlyInterest, String date, double borrowerPaymentAmount) throws ParseException {
		int iterator = 1;
		while(iterator<=duration) {
						
			double initialOutstandingPrincipal = presentValue;
			
			double interest =  monthlyInterest * initialOutstandingPrincipal;
			interest = decimalFormatter(interest);			
			if(interest>initialOutstandingPrincipal) {
				interest = initialOutstandingPrincipal;				
			}
			
			double principal = borrowerPaymentAmount - interest;
			principal = decimalFormatter(principal);
			
			double remainingOutstandingPrincipal = presentValue - principal;
			remainingOutstandingPrincipal = decimalFormatter(remainingOutstandingPrincipal);
			if(remainingOutstandingPrincipal<0) {
				remainingOutstandingPrincipal = 0.0;
			}
			
			RepaymentPlanResponse repaymentPlanResponseItem = new RepaymentPlanResponse();
			repaymentPlanResponseItem.setBorrowerPaymentAmount(borrowerPaymentAmount);
			repaymentPlanResponseItem.setDate(date);
			repaymentPlanResponseItem.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
			repaymentPlanResponseItem.setInterest(interest);
			repaymentPlanResponseItem.setPrincipal(principal);
			repaymentPlanResponseItem.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);			
			repaymentPlanResponse.add(repaymentPlanResponseItem);
			
			iterator++;
			presentValue = remainingOutstandingPrincipal;
			date = dateIncrementInMonths(date);
		}
	}

	/**
	 * The method returns the Annuity payment using the following formula.
	 */	
	private double calculateAnnuity(double presentValue, long duration, float monthlyInterest) throws ArithmeticException {		
		try {
			logger.info("Start of RepaymentPlanGeneratorProcessor.calculateAnnuity() method.");			
			double numerator = monthlyInterest * presentValue;		
			double NegativeValueForNumberOfPeriods = duration * (-Constants.VALUE_ONE);		
			double denominator = Constants.VALUE_ONE - (Math.pow((Constants.VALUE_ONE + monthlyInterest), NegativeValueForNumberOfPeriods));
			double annuity = numerator / denominator;
			logger.info("Annuity Payment From Formula:::" + annuity);
			logger.info("End of RepaymentPlanGeneratorProcessor.calculateAnnuity() method.");			
			return annuity;
		} catch (Exception e) {
			logger.info("Denominator value should not be zero. Cannot be divided with zero");
			throw e;
		}
	}
	
	/**
	 * The method returns the incremented date by one month.
	 */	
	private String dateIncrementInMonths (String date) throws ParseException {
		logger.info("Start of RepaymentPlanGeneratorProcessor.dateIncrementInMonths() method.");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);		
		ZonedDateTime dateTime = ZonedDateTime.parse(date, formatter);
		if (dateTime != null) {			
			dateTime = dateTime.plus(1, ChronoUnit.MONTHS);
			logger.info(dateTime.toString());
			logger.info("End of RepaymentPlanGeneratorProcessor.dateIncrementInMonths() method with date.");
			return dateTime.toString();
		} else {
			logger.info(null);
			logger.info("End of RepaymentPlanGeneratorProcessor.dateIncrementInMonths() method with null date.");
			return null;	
		}
	}
	
	/**
	 * The method returns the number up to two decimals.
	 */		
	private double decimalFormatter(double number) {
		logger.info("Start of RepaymentPlanGeneratorProcessor.decimalFormatter() method.");
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
		number = Double.parseDouble(decimalFormat.format(number));
		logger.info("Number after decimal formatter:::" + number);
		logger.info("End of RepaymentPlanGeneratorProcessor.decimalFormatter() method.");
		return number;		
	}
}
