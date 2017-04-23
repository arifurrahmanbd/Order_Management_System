package app.commonerp.usermanager.persistencetier;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECURITY_PERMISSION")
public class SecurityPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long permissionId;
	private String permission;
	private String description;
	private String dynamicAccess;
	private Timestamp createdTimestamp;

	private String createdBy;

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDynamicAccess() {
		return dynamicAccess;
	}

	public void setDynamicAccess(String dynamicAccess) {
		this.dynamicAccess = dynamicAccess;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


}
