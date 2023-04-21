package com.neom.assettech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.LocationAlertModel;

@Repository
public interface LocationAlertRepository extends JpaRepository<LocationAlertModel, Integer> {

	@Query(value = "SELECT * FROM locationalert WHERE is_active = true", nativeQuery = true)
    public LocationAlertModel getActiveAlert() throws Exception;
	List<LocationAlertModel> findAll();
}
