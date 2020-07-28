package col.com.er.service;

import col.com.er.dao.UserDao;
import col.com.er.entity.Answers;
import col.com.er.entity.Client;
import col.com.er.entity.ClientAnswers;
import col.com.er.entity.Crol;
import col.com.er.entity.Questions;
import col.com.er.entity.UserRoles;
import col.com.er.entity.Users;
import col.com.er.entity.dto.QuestionAnswersDTO;
import col.com.er.entity.dto.UserDTO;
import col.com.er.service.impl.ClientAnswersImpl;
import col.com.er.service.impl.ClientServiceImpl;
import col.com.er.service.impl.QuestionsServiceImpl;
import col.com.er.service.impl.RolServiceImpl;
import col.com.er.service.impl.UserRolesServiceImpl;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface. It overrides the loadUserByUsername for fetching user details from the database using the username. 
The Spring Security Authentication Manager calls this method for getting the user details from the database 
when authenticating the user details provided by the user.
 */
@Slf4j
@Service
@Log
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
    ClientAnswersImpl clientAnswersImpl;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private QuestionsServiceImpl questionsServiceImpl;

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

    @Transactional()
    public Users save(Users user, List<ClientAnswers> clientAnswerList) {

        user.setPassword(bcryptEncoder.encode(user.getPassword()));

        Crol crol = new Crol();
        crol.setIdRol(2);

        /* Get the default rol of the user from database in this case is users*/
        //Long id = rolServiceImpl.findCRol(crol).getIdRol();
        // save the rol_id and user_id in userRoles table in casacade mode 
        UserRoles userRoles = new UserRoles();
        userRoles.setRoles(crol);
        userRoles.setUsers(user);

        userRolesServiceImpl.save(userRoles);

        // To store the id of the current saved user in the client table 
        Client client = new Client();
        client.setUsers(user);

        clientAnswerList.stream()
                .forEach(clientAnswer
                        -> {

                    clientAnswer.setClientes(client);

                });
        clientAnswersImpl.saveAll(clientAnswerList);

        return user;
    }

}
