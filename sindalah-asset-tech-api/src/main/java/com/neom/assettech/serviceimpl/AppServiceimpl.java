package com.neom.assettech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neom.assettech.model.AppModel;
import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.repository.AppRepository;
import com.neom.assettech.service.AppService;
import com.neom.assettech.service.AuditService;

@Service
public class AppServiceimpl implements AppService {

	@Autowired
	AppRepository apprepository;
	@Autowired
	private AuditService auditService;
	
	@Override
	public List<AppModel> findAll() {
		
		return apprepository.findAll();
	}

	@Override

    public void addapp(AppModel appmodelnew) throws Exception {

        Optional<AppModel> appval= apprepository.findById(appmodelnew.getAppId());  

        if(appval.isPresent()) {

            AppModel appmodel=appval.get();

            if(appmodelnew.getAppId().equals(appmodel.getAppId()))

            {

                if (!appmodelnew.getAppName().equals(appmodel.getAppName()))

                {

                    AuditLogModel auditlognew=new AuditLogModel();

                    auditlognew.setEntityName("App");

                    auditlognew.setAttribute_Name("app_name");

                    auditlognew.setOldValue(appmodel.getAppName());

                    auditlognew.setNewValue(appmodelnew.getAppName());

                    auditlognew.setChangedBy("API");            

                    auditlognew.setRecordId(appmodelnew.getAppId().toString());                      

                    auditService.createAuditLog(auditlognew);

                }

                if (!appmodelnew.getIsActive().equals(appmodel.getIsActive()))

                {

                    AuditLogModel auditlognew=new AuditLogModel();

                    auditlognew.setEntityName("App");

                    auditlognew.setAttribute_Name("is_active");

                    auditlognew.setOldValue(appmodel.getIsActive().toString());

                    auditlognew.setNewValue(appmodelnew.getIsActive().toString());

                    auditlognew.setChangedBy("API");

                    auditlognew.setRecordId(appmodelnew.getAppId().toString());                      

                    auditService.createAuditLog(auditlognew);

                }

            }

        this.apprepository.save(appmodel);

       

        }



    }
	
	

}
