package app.commonerp.infybank.businesstier;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import app.commonerp.infybank.persistencetier.AccountService;

public class AccountManager {
	AccountValidator validator = new AccountValidator();
	AccountService service = new AccountService();

	public AccountTO loginUser(AccountTO accountTO) throws Exception {
		try {

			validator
					.validate(accountTO.getUserName(), accountTO.getPassword());
			if (service.getUser(accountTO.getUserName()) == "Not Found") {
				throw new Exception("Manager.USER_NOT_FOUND");
			}

			if (!accountTO.getPassword().equals(
					service.getPasswordList().get(accountTO.getUserName()))) {

				throw new Exception("Manager.USERNAME_PASSWORD_MISMATCH");
			}
			return service.loginUser(accountTO);
		} catch (Exception e) {
			Logger logger = Logger.getLogger(AccountManager.class.getName());
			logger.info(e);
			throw e;
		}
	}

	public LinkedHashMap<String, String> addUser(AccountTO accountTO)
			throws Exception {
		try {

			validator
					.validate(accountTO.getUserName(), accountTO.getPassword());
			if (service.getUser(accountTO.getUserName()) == "Found") {
				throw new Exception("Manager.USER_EXISTS");
			}
			return service.addUser(accountTO);
		} catch (Exception e) {
			throw e;
		}
	}

	public LinkedHashMap<String, String> updateUser(AccountTO accountTO)
			throws Exception {
		try {

			validator
					.validate(accountTO.getUserName(), accountTO.getPassword());
			if (service.getUser(accountTO.getUserName()) == "Not Found") {
				throw new Exception("Manager.USER_NOT_EXISTS");
			}
			return service.updateUser(accountTO);
		} catch (Exception e) {
			throw e;
		}
	}

	public LinkedHashMap<String, String> deleteUser(AccountTO accountTO)
			throws Exception {
		try {
			if (service.getUser(accountTO.getUserName()) == "Not Found") {
				throw new Exception("Manager.USER_NOT_EXISTS");
			}
			return service.deleteUser(accountTO);
		} catch (Exception e) {
			throw e;
		}
	}

	public LinkedHashMap<String, Double> debit(AccountTO accountTO)
			throws Exception {
		try {
			validator.validateAmount(accountTO.getAmount());
			if (service.getUser(accountTO.getUserName()) == "Not Found") {
				throw new Exception("Manager.USER_NOT_EXISTS");
			}
			if (service.getBalanceList().get(accountTO.getUserName()) < accountTO
					.getAmount()) {
				throw new Exception("Manager.INSUFFICIENT_AMOUNT");
			}
			return service.debit(accountTO);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public LinkedHashMap<String, Double> credit(AccountTO accountTO)
			throws Exception {
		try {
			validator.validateAmount(accountTO.getAmount());
			if (service.getUser(accountTO.getUserName()) == "Not Found") {
				throw new Exception("Manager.USER_NOT_EXISTS");
			}
			return service.credit(accountTO);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public List<AccountTO> getAllUsersData() {
		return service.getAllUsersData();
	}

}
