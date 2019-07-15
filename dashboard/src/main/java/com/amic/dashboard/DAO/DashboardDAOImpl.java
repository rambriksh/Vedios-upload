package com.amic.dashboard.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amic.dashboard.constant.StatusCode;
import com.amic.dashboard.domain.Domain;
import com.amic.dashboard.response.Response;
import com.amic.dashboard.utils.CommonUtils;
 
 
 


@Repository
@Transactional
public class DashboardDAOImpl implements DashboardDAO {
	private static final Logger logger = LoggerFactory.getLogger(DashboardDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Response addVedios(Domain domain) throws Exception {
		// TODO Auto-generated method stub
		Response response = CommonUtils.getResponseObject("Add Vedio");
		try 
		{
			entityManager.persist(domain);
			response.setStatus(StatusCode.SUCCESS.name());
		} 
		catch (Exception e) 
		 
		{
			logger.error("Exception in addUser", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;

}
	
	
	
	@Override
	public Domain getVedios(String id) throws Exception {

		try 
		{
			String hql = "From Domain where isActive=?1";
			return (Domain) entityManager.createQuery(hql).setParameter(1, id).getSingleResult();
		} 
		catch (EmptyResultDataAccessException e) 
		{
			return null;
		} 
		catch (Exception e) 
		{
			logger.error("Exception in getVedios"+ e.getMessage());
			return null;
		}
	}
	
	
	
	
	
	public Response updateVedios(Domain domain) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Customer data");
		try {
			Domain domains=getVedios(domain.getId());
			domains.setId(domain.getPath());
			
			 
			response.setStatus(StatusCode.SUCCESS.name());
		}catch(Exception e) {
			logger.error("Exceptio is Update Customer");
			response.setStatus(StatusCode.ERROR.name());
			
		}
		return null;
	}

	@Override
	public Response deleteVedios(String id) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete Parent data");
		try {
			

			Domain domain=getVedios(id);
			domain.setActive(false);


		
			entityManager.flush();

			response.setStatus(StatusCode.SUCCESS.name());
			
		} 
		catch(Exception ex)
		{
			logger.error("Exception in deleteVedios", ex);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(ex.getMessage());
		}
		return response;	
	}


	 
	
	

}
