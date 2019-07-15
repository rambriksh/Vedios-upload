package com.amic.dashboard.DAO;

import com.amic.dashboard.domain.Domain;
import com.amic.dashboard.response.Response;
 
 

public interface DashboardDAO {
	public Response addVedios(Domain domain)throws Exception;
	public Domain getVedios(String id)throws Exception;
	public Response updateVedios(Domain domain)throws Exception;
	public Response deleteVedios(String id)throws Exception;

}
