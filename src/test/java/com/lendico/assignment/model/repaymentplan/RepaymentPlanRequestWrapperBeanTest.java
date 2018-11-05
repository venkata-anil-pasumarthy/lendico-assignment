package com.lendico.assignment.model.repaymentplan;

import org.junit.Test;
import org.meanbean.test.BeanTester;

/**
 * The Class RepaymentPlanRequestWrapperBeanTest.
 */
public class RepaymentPlanRequestWrapperBeanTest {

	/**
	 * Execute RepaymentPlanRequestWrapper Bean Test success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void getterAndSetterCorrectness() throws Exception {
	    new BeanTester().testBean(RepaymentPlanRequestWrapper.class);
	}
}