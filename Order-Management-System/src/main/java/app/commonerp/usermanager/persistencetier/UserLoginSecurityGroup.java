package app.commonerp.usermanager.persistencetier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN_SECURITY_GROUP")
public class UserLoginSecurityGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userLoginSecurityGroupId;
	private Long userLoginId;
	private Long groupId;

	public Long getUserLoginSecurityGroupId() {
		return userLoginSecurityGroupId;
	}

	public void setUserLoginSecurityGroupId(Long userLoginSecurityGroupId) {
		this.userLoginSecurityGroupId = userLoginSecurityGroupId;
	}

	public Long getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Long userLoginId) {
		this.userLoginId = userLoginId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
