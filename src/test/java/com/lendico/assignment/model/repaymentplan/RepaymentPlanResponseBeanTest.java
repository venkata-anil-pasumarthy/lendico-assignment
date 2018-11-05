package com.lendico.assignment.model.repaymentplan;

import org.junit.Test;
import org.meanbean.test.BeanTester;

/**
 * The Class RepaymentPlanResponseBeanTest.
 */
public class RepaymentPlanResponseBeanTest {
	
	/**
	 * Execute RepaymentPlanResponse Bean Test success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void getterAndSetterCorrectness() throws Exception {
	    new BeanTester().testBean(RepaymentPlanResponse.class);
	}
}
