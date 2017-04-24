package app.commonerp.hometheatre.persistencetier;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
	Country findByCountryName(String countryName);
}