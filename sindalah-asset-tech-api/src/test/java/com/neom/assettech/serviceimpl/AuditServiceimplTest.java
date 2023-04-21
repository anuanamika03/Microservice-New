package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.repository.AuditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuditServiceimplTest {

    @Mock
    AuditRepository auditrepository;

    @InjectMocks
    AuditServiceimpl auditServiceimpl;

    private AuditLogModel auditLogModel;
    private List<AuditLogModel> auditLogModels;

    @BeforeEach
    public void setUp() {
        auditLogModel = new AuditLogModel();
        auditLogModel.setAuditLogId(1);
        auditLogModel.setEntityName("Location");
        auditLogModel.setAttribute_Name("Name");
        auditLogModel.setOldValue("Old Location");
        auditLogModel.setNewValue("New Location");
        auditLogModel.setChangedOn(new Date());
        auditLogModel.setChangedBy("User");
        auditLogModel.setChangedReason("Update Location");
        auditLogModel.setRecordId("1");

        auditLogModels = new ArrayList<>();
        auditLogModels.add(auditLogModel);
    }

    @Test
    public void testFindAll_Positive() {
        when(auditrepository.findAll()).thenReturn(auditLogModels);

        List<AuditLogModel> result = auditServiceimpl.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Location", result.get(0).getEntityName());
    }

    @Test
    public void testFindAll_Negative() {
        when(auditrepository.findAll()).thenReturn(null);

        List<AuditLogModel> result = auditServiceimpl.findAll();

        assertNull(result);
    }

    @Test
    public void testCreateAuditLog_Positive() throws Exception {
        when(auditrepository.saveAndFlush(auditLogModel)).thenReturn(auditLogModel);

        AuditLogModel result = auditServiceimpl.createAuditLog(auditLogModel);

        assertNotNull(result);
        assertEquals(1, result.getAuditLogId());
        assertEquals("Location", result.getEntityName());
    }

    @Test
    public void testCreateAuditLog_Negative() throws Exception {

        when(auditrepository.saveAndFlush(auditLogModel)).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> auditServiceimpl.createAuditLog(auditLogModel));
    }

}