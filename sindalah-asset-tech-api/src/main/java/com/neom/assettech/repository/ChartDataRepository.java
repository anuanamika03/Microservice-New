package com.neom.assettech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neom.assettech.model.ChartDataModel;


@Repository
public interface ChartDataRepository extends JpaRepository<ChartDataModel, Integer> {
	
	

	List<ChartDataModel> findAll();

	

	
}
