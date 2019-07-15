package com.amic.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amic.dashboard.DAO.DashboardDAO;
import com.amic.dashboard.constant.StatusCode;
import com.amic.dashboard.model.Model;
import com.amic.dashboard.response.ErrorObject;
import com.amic.dashboard.response.Response;
import com.amic.dashboard.service.DashboardService;
import com.amic.dashboard.utils.CommonUtils;
 
 
 
 

@RestController
@RequestMapping("/111")
@CrossOrigin(origins="*",allowedHeaders="*")
public class DashboardController {
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired 
	DashboardService dashboardService;
	
	@Autowired 
	DashboardDAO dashboardDAO;

	
	
	@RequestMapping(value = "/addVedios", method = RequestMethod.POST, produces = "application/json")
	public Response addVedios(@RequestBody Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("addVedios: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addUser: Received request: "+ CommonUtils.getJson(model));
		
		return dashboardService.addVedios(model);
		
	}
	
	
	
	@RequestMapping(value = "/getVedios/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getVedios(@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{

		logger.info("getParent: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		
		Model model = dashboardService.getVedios(id);
		
		 Response res = CommonUtils.getResponseObject("Vedios Details");
		if (model == null)
		{
			ErrorObject err = CommonUtils.getErrorResponse("Parents Not Found", "Parents Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} 
		else
		{
			res.setData(model);
		}
		logger.info("getParent: Sent response");
		return CommonUtils.getJson(res);
	}
	
	
	
	
	
	@RequestMapping(value = "/updateVedios", method = RequestMethod.PUT, produces = "application/json")
	public Response updateVedios(@RequestBody Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("updateVedios: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateVedios: Received request: " + CommonUtils.getJson(model));
		
		return dashboardService.updateVedios(model);
		
	}
	
	
	
	@RequestMapping(value="/deleteVedios/{id}",method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteVedios (@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		logger.info("getParent: Received request:" +request.getRequestURL().toString()
				+((request.getQueryString()==null)?  "" : "?" +request.getQueryString().toString()));
		
		return dashboardService.deleteVedios(id);
	}
	
	
	
}
