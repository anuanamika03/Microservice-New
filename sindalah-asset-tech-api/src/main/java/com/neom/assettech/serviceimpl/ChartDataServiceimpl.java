package com.neom.assettech.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neom.assettech.model.ChartDataModel;
import com.neom.assettech.repository.ChartDataRepository;
import com.neom.assettech.service.ChartDataService;

@Service
public class ChartDataServiceimpl implements ChartDataService {

	@Autowired
	ChartDataRepository chartdatarepository;

	@Override
	public List<ChartDataModel> findAll() {
		List<ChartDataModel> charts = chartdatarepository.findAll();
		if (charts.size() > 0) {
			Date dt = charts.get(0).getTimestamp();

			int hrs = dt.getHours();

			if (hrs > 9 && hrs < 22) {
				int indx = hrs - 10;
				charts.get(0).setAxisZone(indx);
			}
		}

		return charts;
	}

	@Override
	public void addchartdata(ChartDataModel chartdatamodel) {
		chartdatarepository.save(chartdatamodel);

	}

}
