package app.commonerp.infybank.presentationtier;

import org.junit.Assert;
import org.junit.Test;

import app.commonerp.infybank.businesstier.AccountValidator;

public class AccountTest {
	AccountValidator validator = new AccountValidator();

	@Test
	public void inValidUserName() {
		Assert.assertFalse(validator.isValidateUsername("jack"));
	}

	@Test
	public void inValidPassword() {
		Assert.assertTrue(validator.isValidatePassword("435"));
	}
	@Test
	public void inValidAmount(){
		Assert.assertFalse(validator.isValidAmount(320.00));
	}
}
