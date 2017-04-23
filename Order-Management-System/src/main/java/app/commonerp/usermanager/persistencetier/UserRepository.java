package app.commonerp.usermanager.persistencetier;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserEmailAndUserPassword(String userEmail, String userPassword);
	User findByUserEmail(String userEmail);
}