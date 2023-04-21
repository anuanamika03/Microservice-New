package com.neom.assettech.serviceimpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.model.LocationModel;
import com.neom.assettech.repository.AuditRepository;
import com.neom.assettech.repository.LocationRepository;
import com.neom.assettech.service.AuditService;
import com.neom.assettech.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private AuditService auditService;
	
	@Override
	public LocationModel createLocation(LocationModel locationnew) throws Exception {
		Optional<LocationModel> locationval= locationRepository.findById(locationnew.getLocationId());

		
        if(locationval.isPresent()) {
        	

        	LocationModel location=locationval.get();
            if(locationnew.getLocationId().equals(location.getLocationId()))

            {

                System.out.println(locationnew.getLocationName());

                System.out.println(location.getLocationName());

                if (!locationnew.getLocationName().equals(location.getLocationName()))

                {

                    AuditLogModel auditlocation=new AuditLogModel();

                    auditlocation.setEntityName("locations");

                    auditlocation.setAttribute_Name("location_name");

                    auditlocation.setOldValue(location.getLocationName());

                    auditlocation.setNewValue(locationnew.getLocationName());

                    auditlocation.setChangedBy("API");

                    
                    auditlocation.setRecordId(locationnew.getLocationId().toString());                      

                    auditService.createAuditLog(auditlocation);                

                   

                }
                if (!locationnew.getLatitude().equals(location.getLatitude()))

                {

                    AuditLogModel auditlocation=new AuditLogModel();

                    auditlocation.setEntityName("locations");

                    auditlocation.setAttribute_Name("latitude");

                    auditlocation.setOldValue(location.getLatitude());

                    auditlocation.setNewValue(locationnew.getLatitude());

                    auditlocation.setChangedBy("API");

                    auditlocation.setRecordId(locationnew.getLocationId().toString());                      

                    auditService.createAuditLog(auditlocation);

                }

                if (!locationnew.getLongitude().equals(location.getLongitude()))

                {

                    AuditLogModel auditlocation=new AuditLogModel();

                    auditlocation.setEntityName("locations");

                    auditlocation.setAttribute_Name("longitude");

                    auditlocation.setOldValue(location.getLongitude());

                    auditlocation.setNewValue(locationnew.getLongitude());

                    auditlocation.setChangedBy("API");

                    auditlocation.setRecordId(locationnew.getLocationId().toString());                      

                    auditService.createAuditLog(auditlocation);

                }

                if (!locationnew.getIsActive().equals(location.getIsActive()))

                {

                    AuditLogModel auditlocation=new AuditLogModel();

                    auditlocation.setEntityName("locations");

                    auditlocation.setAttribute_Name("is_active");

                    auditlocation.setOldValue(location.getIsActive().toString());

                    auditlocation.setNewValue(locationnew.getIsActive().toString());

                    auditlocation.setChangedBy("API");

                    auditlocation.setRecordId(locationnew.getLocationId().toString());                      

                    auditService.createAuditLog(auditlocation);

                }

            }

           

        }
		return locationRepository.saveAndFlush(locationnew);
	}

	@Override
	public List<LocationModel> getAllLocations() throws Exception {
		return locationRepository.findAll();
	}

	@Override
	public LocationModel getLocationByLocationId(Integer locationId) throws Exception {
		return locationRepository.findById(locationId).get();
	}

	@Override
	public LocationModel getLocationByDeviceId(String deviceId) throws Exception {
		return locationRepository.findByDeviceId(deviceId);
	}

}
