package com.lendico.assignment.component;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lendico.assignment.model.repaymentplan.RepaymentPlanRequestWrapper;
import com.lendico.assignment.model.repaymentplan.RepaymentPlanResponse;
import com.lendico.assignment.processor.repaymentplan.RepaymentPlanGeneratorProcessor;

/**
 * The Class RepaymentPlanGeneratorComponentTest.
 */
public class RepaymentPlanGeneratorComponentTest {
	
	/**
	 * Execute re payment plan generator success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void executeRepaymentPlanGeneratorSuccess() throws Exception {	
		
		List<RepaymentPlanResponse> response = retrieveRepaymentPlanResponse();		
				
		String expected = "[RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-01-01T00:00:01Z, initialOutstandingPrincipal=5000.0, interest=20.83, principal=198.53, remainingOutstandingPrincipal=4801.47], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-02-01T00:00:01Z, initialOutstandingPrincipal=4801.47, interest=20.01, principal=199.35, remainingOutstandingPrincipal=4602.12], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-03-01T00:00:01Z, initialOutstandingPrincipal=4602.12, interest=19.18, principal=200.18, remainingOutstandingPrincipal=4401.94], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-04-01T00:00:01Z, initialOutstandingPrincipal=4401.94, interest=18.34, principal=201.02, remainingOutstandingPrincipal=4200.92], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-05-01T00:00:01Z, initialOutstandingPrincipal=4200.92, interest=17.5, principal=201.86, remainingOutstandingPrincipal=3999.06], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-06-01T00:00:01Z, initialOutstandingPrincipal=3999.06, interest=16.66, principal=202.7, remainingOutstandingPrincipal=3796.36], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-07-01T00:00:01Z, initialOutstandingPrincipal=3796.36, interest=15.82, principal=203.54, remainingOutstandingPrincipal=3592.82], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-08-01T00:00:01Z, initialOutstandingPrincipal=3592.82, interest=14.97, principal=204.39, remainingOutstandingPrincipal=3388.43], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-09-01T00:00:01Z, initialOutstandingPrincipal=3388.43, interest=14.12, principal=205.24, remainingOutstandingPrincipal=3183.19], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-10-01T00:00:01Z, initialOutstandingPrincipal=3183.19, interest=13.26, principal=206.1, remainingOutstandingPrincipal=2977.09], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-11-01T00:00:01Z, initialOutstandingPrincipal=2977.09, interest=12.4, principal=206.96, remainingOutstandingPrincipal=2770.13], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2018-12-01T00:00:01Z, initialOutstandingPrincipal=2770.13, interest=11.54, principal=207.82, remainingOutstandingPrincipal=2562.31], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-01-01T00:00:01Z, initialOutstandingPrincipal=2562.31, interest=10.68, principal=208.68, remainingOutstandingPrincipal=2353.63], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-02-01T00:00:01Z, initialOutstandingPrincipal=2353.63, interest=9.81, principal=209.55, remainingOutstandingPrincipal=2144.08], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-03-01T00:00:01Z, initialOutstandingPrincipal=2144.08, interest=8.93, principal=210.43, remainingOutstandingPrincipal=1933.65], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-04-01T00:00:01Z, initialOutstandingPrincipal=1933.65, interest=8.06, principal=211.3, remainingOutstandingPrincipal=1722.35], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-05-01T00:00:01Z, initialOutstandingPrincipal=1722.35, interest=7.18, principal=212.18, remainingOutstandingPrincipal=1510.17], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-06-01T00:00:01Z, initialOutstandingPrincipal=1510.17, interest=6.29, principal=213.07, remainingOutstandingPrincipal=1297.1], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-07-01T00:00:01Z, initialOutstandingPrincipal=1297.1, interest=5.4, principal=213.96, remainingOutstandingPrincipal=1083.14], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-08-01T00:00:01Z, initialOutstandingPrincipal=1083.14, interest=4.51, principal=214.85, remainingOutstandingPrincipal=868.29], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-09-01T00:00:01Z, initialOutstandingPrincipal=868.29, interest=3.62, principal=215.74, remainingOutstandingPrincipal=652.55], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-10-01T00:00:01Z, initialOutstandingPrincipal=652.55, interest=2.72, principal=216.64, remainingOutstandingPrincipal=435.91], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-11-01T00:00:01Z, initialOutstandingPrincipal=435.91, interest=1.82, principal=217.54, remainingOutstandingPrincipal=218.37], RepaymentPlanResponse [borrowerPaymentAmount=219.36, date=2019-12-01T00:00:01Z, initialOutstandingPrincipal=218.37, interest=0.91, principal=218.45, remainingOutstandingPrincipal=0.0]]";
		String actual = response.toString();
			
		assertEquals(expected, actual);		
		
	}
	
	/**
	 * Execute re payment plan generator null.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void executeRepaymentPlanGeneratorNull() throws Exception {		
		List<RepaymentPlanResponse> response = new ArrayList<RepaymentPlanResponse>();				
		String expected = "[]";
		String actual = response.toString();			
		assertEquals(expected, actual);		
	}
	
	public List<RepaymentPlanResponse> retrieveRepaymentPlanResponse() throws Exception {		
		RepaymentPlanRequestWrapper requestWrapper = new RepaymentPlanRequestWrapper();
		requestWrapper.setLoanAmount(new Double(5000));
		requestWrapper.setStartDate("2018-01-01T00:00:01Z");
		requestWrapper.setNominalRate(new Float(5.00));
		requestWrapper.setDuration(new Long(24));
		RepaymentPlanGeneratorProcessor repaymentPlanGeneratorProcessor = new RepaymentPlanGeneratorProcessor();
		List<RepaymentPlanResponse> response = repaymentPlanGeneratorProcessor.getRepaymentPlanSchedule(requestWrapper);
		return response;		
	}
}
