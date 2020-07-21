
package col.com.er.dao;

import col.com.er.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientDao extends JpaRepository<Client, Long> {

}
