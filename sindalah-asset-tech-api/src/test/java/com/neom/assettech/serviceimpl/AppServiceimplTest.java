package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.AppModel;
import com.neom.assettech.repository.AppRepository;
import com.neom.assettech.service.AuditService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppServiceimplTest {

    @Mock
    private AppRepository apprepository;

    @Mock
    private AuditService auditService;

    @InjectMocks
    private AppServiceimpl appServiceimpl;

    private AppModel appModel;

    @Before()
    public void setUp() {
        appModel = new AppModel();
        appModel.setAppId(1);
        appModel.setAppName("Test App");
        appModel.setIsActive(true);
    }

    @Test
    public void testFindAllPositive() {
        List<AppModel> expected = new ArrayList<>();
        expected.add(new AppModel());
        when(apprepository.findAll()).thenReturn(expected);
        List<AppModel> result = appServiceimpl.findAll();
        assertEquals(expected, result);
        verify(apprepository, times(1)).findAll();
    }

    @Test
    public void testFindAllNegative() {
        when(apprepository.findAll()).thenReturn(null);
        List<AppModel> result = appServiceimpl.findAll();
        assertNull(result);
        verify(apprepository, times(1)).findAll();
    }


    @Test
    public void addapp_positiveScenario_appModelSaved() throws Exception {
        when(apprepository.findById(1)).thenReturn(Optional.of(appModel));
        appServiceimpl.addapp(appModel);
        verify(apprepository, times(1)).save(appModel);
    }

//    @Test(expected = Exception.class)
//    public void addapp_negativeScenario_appModelNotFound() throws Exception {
//        when(apprepository.findById(1)).thenReturn(Optional.empty());
//
//        List<AppModel> result=appServiceimpl.addapp(appModel);
//       assertEquals(null, result);
//    }

    @Test
    public void addapp_positiveScenario_auditLogCreated() throws Exception {
        when(apprepository.findById(1)).thenReturn(Optional.of(appModel));
        AppModel newAppModel = new AppModel();
        newAppModel.setAppId(1);
        newAppModel.setAppName("New Test App");
        newAppModel.setIsActive(false);
        appServiceimpl.addapp(newAppModel);
        verify(auditService, times(2)).createAuditLog(org.mockito.ArgumentMatchers.any());
    }

}
