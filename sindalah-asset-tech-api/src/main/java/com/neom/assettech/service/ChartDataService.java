package com.neom.assettech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neom.assettech.model.ChartDataModel;

@Service
public interface ChartDataService {

	
	public void addchartdata(ChartDataModel chartdatamodel);

	public List<ChartDataModel> findAll();

}
