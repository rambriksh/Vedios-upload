package com.amic.dashboard.service;

import com.amic.dashboard.model.Model;
import com.amic.dashboard.response.Response;
 

public interface DashboardService {
	public Response addVedios(Model model)throws Exception;
	public Response updateVedios(Model model) throws Exception;

	public Model getVedios(String id) throws Exception;
	public Response deleteVedios(String id) throws Exception;
}
