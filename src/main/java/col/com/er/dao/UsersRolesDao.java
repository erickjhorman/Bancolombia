package col.com.er.dao;

import col.com.er.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRolesDao extends JpaRepository<UserRoles, Long> {

    
}
