package app.commonerp.usermanager.businesstier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.commonerp.hometheatre.persistencetier.Country;
import app.commonerp.usermanager.persistencetier.SecurityGroup;
import app.commonerp.usermanager.persistencetier.SecurityGroupRepository;
import app.commonerp.usermanager.persistencetier.UserLogin;
import app.commonerp.usermanager.persistencetier.UserLoginRepository;
@Repository
public class UserManager {
	@Autowired
	private SecurityGroupRepository securityGroupRepository;
	@Autowired
	private UserLoginRepository userLoginRepository;


	@Autowired
	private EntityManager em;
	public Iterable<UserLogin> getUserList(){
		
		Iterable<UserLogin> userLoginList = userLoginRepository.findAll();
		return userLoginList;
	}
	public Iterable<SecurityGroup> getSecurityGroupList() {
		Iterable<SecurityGroup> securityGroupList = securityGroupRepository.findAll();
		return securityGroupList;
	}
    public String deleteSecurityGroup(Long groupId) {
    	securityGroupRepository.delete(groupId);
    	return "success";
	}
	public String saveUserLogin(HttpServletRequest request,	HttpServletResponse response) {
		String id = request.getParameter("id");
		String userLoginId = request.getParameter("userLoginId");
		String currentPassword = request.getParameter("currentPassword");
		String passwordHint = request.getParameter("currentPassword");

		UserLogin userLogin = new UserLogin();

		String status = "";

		if (id.equals("0") == true) {

			if (checkDuplicate(id, userLoginId) == true) {
				status = "[{\"status\" : \"User Name already exists\"}]";
			} else {

				userLogin.setUserLoginId(userLoginId);
				userLogin.setCurrentPassword(currentPassword);
				userLogin.setPasswordHint(passwordHint);

				if (userLoginRepository.save(userLogin) != null) {
					status = "[{\"status\" : \"Saved successfully\"}]";
				} else {
					status = "[{\"status\" : \"Error Occured\"}]";
				}
			}
		} else {

			if (checkDuplicate(id, userLoginId) == true) {
				status = "[{\"status\" : \"User Name already exists\"}]";
			} else {
				userLogin = userLoginRepository.findOne(Long.parseLong(id));

				userLogin.setUserLoginId(userLoginId);

				if (userLoginRepository.save(userLogin) != null) {
					status = "[{\"status\" : \"Updated successfully\"}]";
				} else {
					status = "[{\"status\" : \"Error Occured\"}]";
				}
			}
		}
		return status;
	}
	public Boolean checkDuplicate(String id, String userLoginId) {

		Boolean isDuplicate = false;

		if (id.equals("0") == true) {
			UserLogin userLogin = userLoginRepository.findByUserLoginId(userLoginId);

			if (userLogin != null) {
				isDuplicate = true;
			}
		} else {

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Country> c = criteriaBuilder
					.createQuery(Country.class);

			Root<Country> country = c
					.from(Country.class);
			Predicate predicateCondition = null;

			Predicate predCondCountryName = criteriaBuilder.equal(
					country.get("countryName"), userLoginId);
			Predicate predCondId = criteriaBuilder.notEqual(
					country.get("id"), id);

			predicateCondition = criteriaBuilder.and(predCondCountryName,
					predCondId);
			c.where(predicateCondition);

			List<Country> counrtyList = em
					.createQuery(c).getResultList();

			if (counrtyList.size() > 0) {
				isDuplicate = true;
			}
		}

		return isDuplicate;
	}
	public void deleteUserLogin(long id) {
		userLoginRepository.delete(id);
		System.out.println("User Login Deleted!");
	}
	public String getUserLogin(String id) {
		UserLogin userLogin = new UserLogin();

		userLogin = userLoginRepository.findOne(Long.parseLong(id));
		String message = "";

		if (userLogin != null) {
			message = "[{\"partyId\" : \"" + userLogin.getPartyId() + "\""
					+ ",\"userLoginId\" : \"" + userLogin.getUserLoginId() + "\""
					+ "}]";
		}
		return message;
	}
	
	
}
