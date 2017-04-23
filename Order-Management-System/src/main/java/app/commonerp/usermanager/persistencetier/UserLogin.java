package app.commonerp.usermanager.persistencetier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userLoginId;

	private String currentPassword;
	private String passwordHint;
	private String isSystem;
	private String enabled;
	private String hasLoggedOut;
	private String lastCurrencyUOM;
	private String lastLocale;
	private String lastTimeZone;
	private String disabledDateTime;
	private String partyId;
	
	public Long getId() {
		return id;
	}
	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public String getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getHasLoggedOut() {
		return hasLoggedOut;
	}

	public void setHasLoggedOut(String hasLoggedOut) {
		this.hasLoggedOut = hasLoggedOut;
	}

	public String getLastCurrencyUOM() {
		return lastCurrencyUOM;
	}

	public void setLastCurrencyUOM(String lastCurrencyUOM) {
		this.lastCurrencyUOM = lastCurrencyUOM;
	}

	public String getLastLocale() {
		return lastLocale;
	}

	public void setLastLocale(String lastLocale) {
		this.lastLocale = lastLocale;
	}

	public String getLastTimeZone() {
		return lastTimeZone;
	}

	public void setLastTimeZone(String lastTimeZone) {
		this.lastTimeZone = lastTimeZone;
	}

	public String getDisabledDateTime() {
		return disabledDateTime;
	}

	public void setDisabledDateTime(String disabledDateTime) {
		this.disabledDateTime = disabledDateTime;
	}

}
