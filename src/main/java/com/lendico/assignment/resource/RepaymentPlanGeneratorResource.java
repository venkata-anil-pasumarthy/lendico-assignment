package com.lendico.assignment.resource;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.ws.http.HTTPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.assignment.model.repaymentplan.RepaymentPlanRequestWrapper;
import com.lendico.assignment.model.repaymentplan.RepaymentPlanResponse;
import com.lendico.assignment.processor.repaymentplan.RepaymentPlanGeneratorProcessor;

/**
 * The Class RepaymentPlanGeneratorResource
 *
 */
@RestController
public class RepaymentPlanGeneratorResource {

	/** The log. */
	private static final Logger logger = LoggerFactory.getLogger(RepaymentPlanGeneratorResource.class);
	
	@Autowired
	private RepaymentPlanGeneratorProcessor repaymentPlanGeneratorProcessor;
	
	@PostMapping("/generate-plan")
	public List<RepaymentPlanResponse> getRepaymentPlanSchedule(@NotNull @RequestBody RepaymentPlanRequestWrapper requestWrapper) throws Exception, HTTPException {		
		logger.info("Start of RepaymentPlanGeneratorResource.getRepaymentPlanSchedule() method.");
		logger.info(requestWrapper.toString());		
		List<RepaymentPlanResponse> response = null;
		try {
			if(requestWrapper.getLoanAmount()>0 && requestWrapper.getNominalRate()>0 && requestWrapper.getDuration()>0) {
				response = repaymentPlanGeneratorProcessor.getRepaymentPlanSchedule(requestWrapper);
			}
			else {
				throw new Exception("loanAmount, nominalRate, duration values should be greater than zero");
			}
			
		} catch (Exception e) {
			throw e;
		}
		logger.info("End of RepaymentPlanGeneratorResource.getRepaymentPlanSchedule() method.");
		return response;
	}
}
