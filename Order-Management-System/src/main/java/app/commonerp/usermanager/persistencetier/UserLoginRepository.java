package app.commonerp.usermanager.persistencetier;

import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {
	UserLogin findByUserLoginId(String userLoginId);
}
