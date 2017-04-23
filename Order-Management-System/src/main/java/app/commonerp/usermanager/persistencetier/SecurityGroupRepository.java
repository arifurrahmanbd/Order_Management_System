package app.commonerp.usermanager.persistencetier;

import org.springframework.data.repository.CrudRepository;


public interface SecurityGroupRepository extends CrudRepository<SecurityGroup, Long> {
	SecurityGroup findByGroupPermission(String groupPermission);
}
