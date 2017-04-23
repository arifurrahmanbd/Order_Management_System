package app.commonerp.usermanager.persistencetier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECURITY_GROUP")
public class SecurityGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupId;
	private String groupPermission;
	private String description;
	private String createdBy;
	private String createdByTimestamp;

	public String getGroupPermission() {
		return groupPermission;
	}

	public void setGroupPermission(String groupPermission) {
		this.groupPermission = groupPermission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByTimestamp() {
		return createdByTimestamp;
	}

	public void setCreatedByTimestamp(String createdByTimestamp) {
		this.createdByTimestamp = createdByTimestamp;
	}

}
