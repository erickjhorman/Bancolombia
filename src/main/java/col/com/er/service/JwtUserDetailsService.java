
package col.com.er.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface. It overrides the loadUserByUsername for fetching user details from the database using the username. 
The Spring Security Authentication Manager calls this method for getting the user details from the database 
when authenticating the user details provided by the user.
*/
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       if ("Erick".equals(username)) {
			return new User("Erick", "$2a$10$YO6s2kYaDUcoZ3YllBN.wusDqYyL0f8MURErXaf4OJamhwgFLkXwi",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
    }
    
}
