package app.commonerp.hometheatre.businesstier;

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
import app.commonerp.hometheatre.persistencetier.CountryRepository;
@Repository
public class CountryManager {
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private EntityManager em;
	public Iterable<Country> getCountryList(){
		
		Iterable<Country> countryList = countryRepository.findAll();
		return countryList;
	}
	public String saveCountry(HttpServletRequest request,	HttpServletResponse response) {
		String id = request.getParameter("id");
		String countryName = request.getParameter("countryName");

		Country country = new Country();

		String status = "";

		if (id.equals("0") == true) {

			if (checkDuplicate(id, countryName) == true) {
				status = "[{\"status\" : \"Name already exists\"}]";
			} else {

				country.setCountryName(countryName);

				if (countryRepository.save(country) != null) {
					status = "[{\"status\" : \"Saved successfully\"}]";
				} else {
					status = "[{\"status\" : \"Error Occured\"}]";
				}
			}
		} else {

			if (checkDuplicate(id, countryName) == true) {
				status = "[{\"status\" : \"Name already exists\"}]";
			} else {
				country = countryRepository.findOne(Long.parseLong(id));

				country.setCountryName(countryName);

				if (countryRepository.save(country) != null) {
					status = "[{\"status\" : \"Updated successfully\"}]";
				} else {
					status = "[{\"status\" : \"Error Occured\"}]";
				}
			}
		}
		return status;
	}
	public Boolean checkDuplicate(String id, String countryName) {

		Boolean isDuplicate = false;

		if (id.equals("0") == true) {
			Country country = countryRepository.findByCountryName(countryName);

			if (country != null) {
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
					country.get("countryName"), countryName);
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
	public void deleteCountry(long id) {
		countryRepository.delete(id);
		System.out.println("Country Deleted!");
	}
	public String getCountry(String id) {
		Country country = new Country();

		country = countryRepository.findOne(Long.parseLong(id));
		String message = "";

		if (country != null) {
			message = "[{\"id\" : \"" + country.getId() + "\""
					+ ",\"countryName\" : \"" + country.getCountryName() + "\""
					+ "}]";
		}
		return message;
	}
}
