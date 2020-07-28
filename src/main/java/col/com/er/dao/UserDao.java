
package col.com.er.dao;

import col.com.er.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDao extends JpaRepository<Users, Long> {
    
    Users findByUsername(String username);
    
}
