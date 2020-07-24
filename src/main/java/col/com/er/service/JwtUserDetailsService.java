package col.com.er.service;

import col.com.er.dao.UserDao;
import col.com.er.domain.Client;
import col.com.er.domain.Crol;
import col.com.er.domain.UserRoles;
import col.com.er.domain.Users;
import col.com.er.domain.dto.UserDTO;
import col.com.er.service.impl.ClientServiceImpl;
import col.com.er.service.impl.RolServiceImpl;
import col.com.er.service.impl.UserRolesServiceImpl;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface. It overrides the loadUserByUsername for fetching user details from the database using the username. 
The Spring Security Authentication Manager calls this method for getting the user details from the database 
when authenticating the user details provided by the user.
 */
@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UsersService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    UserRolesServiceImpl userRolesServiceImpl;

    @Autowired
    RolServiceImpl rolServiceImpl;

    @Autowired
    ClientServiceImpl clientServiceImpl;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("Desde loadUser");

        Users user = (Users) userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);

        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());

        /*
        if ("Erick".equals(username)) {
            return new User("Erick", "$2a$10$YO6s2kYaDUcoZ3YllBN.wusDqYyL0f8MURErXaf4OJamhwgFLkXwi",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
         */
    }

    public Users save(UserDTO user) {
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setIdentification(user.getIdentificacion());
        newUser.setImage(user.getImage());
        newUser.setRegistedPhase(user.getRegistredPhase());
        newUser.setRegisterdPC(user.getRegistredpc());
        newUser.setRegistedPhase(user.getRegistredPhase());
        newUser.setTermsAndConditions(user.getTermsandconditions());

        Crol crol = new Crol();
        crol.setIdRol(2);

        /* Get the default rol of the user from database in this case is users*/
        //Long id = rolServiceImpl.findCRol(crol).getIdRol();
        // save the rol_id and user_id in userRoles table in casacade mode 
        UserRoles userRoles = new UserRoles();
        userRoles.setRoles(crol);
        userRoles.setUsers(newUser);

        userRolesServiceImpl.save(userRoles);

        // To store the id of the current saved user in the client table 
        Client client = new Client();
        client.setUsers(newUser);
        clientServiceImpl.guardar(client);
        
        return newUser;
    }

}
