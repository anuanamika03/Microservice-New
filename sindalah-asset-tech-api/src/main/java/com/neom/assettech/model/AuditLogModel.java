package com.neom.assettech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "AuditLog")
public class AuditLogModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6293681705867243464L;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditlog_id")
    private Integer AuditLogId;

    @Column(name = "entity_name", columnDefinition = "VARCHAR(255) NOT NULL")
    @NotBlank
    @NotNull
    private String EntityName;


    @Column(name = "attribute_name", columnDefinition = "VARCHAR(255) NOT NULL")
    @NotBlank
    @NotNull
    private String Attribute_Name;

    @Column(name = "old_value", columnDefinition = "VARCHAR(255) NOT NULL")
    @NotBlank
    @NotNull
    private String OldValue;

    @Column(name = "new_value", columnDefinition = "VARCHAR(255) NOT NULL")
    @NotBlank
    @NotNull
    private String NewValue;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CreationTimestamp
    @Column(name = "changedOn")
    private Date changedOn;

    
    @Column(name = "changedBy", columnDefinition = "VARCHAR(255) NULL")
    private String changedBy;

    
    @Column(name = "changedReason", columnDefinition = "VARCHAR(255) NULL")
    private String changedReason;
    
    @Column(name = "record_id", columnDefinition = "VARCHAR(255) NOT NULL")
    @NotBlank
    @NotNull
    private String RecordId;

	public String getRecordId() {
		return RecordId;
	}

	public void setRecordId(String recordId) {
		RecordId = recordId;
	}

	public Integer getAuditLogId() {
		return AuditLogId;
	}

	public void setAuditLogId(Integer auditLogId) {
		AuditLogId = auditLogId;
	}

	public String getEntityName() {
		return EntityName;
	}

	public void setEntityName(String entityName) {
		EntityName = entityName;
	}

	public String getAttribute_Name() {
		return Attribute_Name;
	}

	public void setAttribute_Name(String attribute_Name) {
		Attribute_Name = attribute_Name;
	}

	public String getOldValue() {
		return OldValue;
	}

	public void setOldValue(String oldValue) {
		OldValue = oldValue;
	}

	public String getNewValue() {
		return NewValue;
	}

	public void setNewValue(String newValue) {
		NewValue = newValue;
	}

	public Date getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getChangedReason() {
		return changedReason;
	}

	public void setChangedReason(String changedReason) {
		this.changedReason = changedReason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
