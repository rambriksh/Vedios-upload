package com.amic.dashboard.mapper.dashboard;

import org.springframework.stereotype.Component;

import com.amic.dashboard.domain.Domain;
import com.amic.dashboard.mapper.AbstractModelMapper;
import com.amic.dashboard.model.Model;

@Component
public class DashboardMapper extends AbstractModelMapper<Model, Domain>{

	@Override
	public Class<Model> entityType() {
		// TODO Auto-generated method stub
		return Model.class;
	}

	@Override
	public Class<Domain> modelType() {
		// TODO Auto-generated method stub
		return Domain.class;
	}

}
