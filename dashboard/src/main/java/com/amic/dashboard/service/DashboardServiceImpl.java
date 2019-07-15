package com.amic.dashboard.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.hibernate.engine.jdbc.BlobProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.amic.dashboard.DAO.DashboardDAO;
import com.amic.dashboard.constant.StatusCode;
import com.amic.dashboard.domain.Domain;
import com.amic.dashboard.mapper.dashboard.DashboardMapper;
import com.amic.dashboard.model.Model;
import com.amic.dashboard.response.Response;
import com.amic.dashboard.utils.CommonUtils;
 
 
 
 
@Service
public class DashboardServiceImpl implements DashboardService {

	private static final Logger logger = LoggerFactory.getLogger(DashboardServiceImpl.class);
	@Autowired
	DashboardDAO dashboardDAO;
	

	@Autowired
	DashboardMapper dashboardmapper;
	
	
	@Override
	public Response addVedios(Model model) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			Domain domain= new Domain();
			domain.setId(CommonUtils.generateRandomId());
			String path=domain.setPath(model.getPath());
			domain.setVedios(BlobProxy.generateProxy(saveVedios(path)));
			
			
			
			
			 
			Response response = dashboardDAO.addVedios(domain);
			return response;
		}
		catch(Exception e)
		{
			logger.info("Exception Service:" + e.getMessage());
			Response response=new Response();
			response.setStatus(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
			return response;
		}
	}


/*saveImage function for fetching the image path and convert the image to Blob format*/
	
	private static byte[] saveVedios(String vediospath) {
		      File file =new File(vediospath.replace("\\fakepath\\","\\Users\\ram\\Pictures\\Dashboard"));
		System.out.println(file.getPath());
		long b=file.length();
		/*Limiting the Image size to 2MB*/
		if(b<2000000) {
		      if(file.exists()){
		         try {
		            BufferedImage bufferedImage=ImageIO.read(file);
		            ByteArrayOutputStream byteOutStream=new ByteArrayOutputStream();
		            ImageIO.write(bufferedImage, ".mp4", byteOutStream);
		            return byteOutStream.toByteArray();
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }
		      return null;
		   }
	
	else {
			logger.info("Image size is more than 2MB");
	    }
		 return null;
	}
	
	
	
	@Override
	public  Model getVedios(String id) throws Exception {
		try 
		{
			Model model = new Model();
			Domain domain = dashboardDAO.getVedios(id);
			BeanUtils.copyProperties(domain, model);
			return model;
		} 
		catch(Exception e) 
		{
			logger.info("Exception getvedios:", e);
			return null;
		}
	}


	
	
	@Override
	public Response deleteVedios(String id) throws Exception {
		try
		{
			return dashboardDAO.deleteVedios(id);
		} 
		catch (Exception e) 
		{
			logger.info("Exception deleteVedios:", e);
			return null;
	}
	}
	
	
	@Override
	public Response updateVedios(Model model) throws Exception {
		try {
			Domain domain = new Domain();
			BeanUtils.copyProperties(model, domain);
			Response response = dashboardDAO.updateVedios(domain);
			return response;
		} catch (Exception ex) {
			logger.info("Exception in updateVedios:" + ex.getMessage());
		}
		
		return null;
	}
	
	
 
}
	
	
	

