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

    Users newUser = new Users();

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

        saveToClientTable(user);

        return newUser;
    }

    public List<Questions> FindQuestions() {
        return questionsServiceImpl.listQuestions();
    }

    public void saveToClientTable(UserDTO user) {

        // To store the id of the current saved user in the client table 
        Client client = new Client();
        client.setUsers(newUser);

        List<ClientAnswers> clientAnswerList = new ArrayList();

        user.getListQuestions()
                .stream()
                .forEach(question
                        -> {
                    ClientAnswers clientAnswers = new ClientAnswers();
                    Answers answers = new Answers();
                    Questions questions = new Questions();
                    List<Questions> ListQuestions = FindQuestions();

                    // getting the id of questions from database
                    ListQuestions
                            .stream()
                            .forEach(q
                                    -> {

                                questions.setId(q.getId());

                            });

                    answers.setAnswer(question.getAnswer());

                    clientAnswers.setQuestions(questions);
                    clientAnswers.setAnswers(answers);
                    clientAnswers.setClientes(client);

                    clientAnswerList.add(clientAnswers);
                });
        clientAnswersImpl.saveAll(clientAnswerList);
       

        /*
        for (QuestionAnswersDTO question : user.getListQuestions()) {
            questions.setQuestion(question.getQuestion());
            answers.setAnswer(question.getAnswer());
        }
         */
//        List<ClientAnswers> clientAnswerList = new ArrayList();
//
//        for (int i = 0; i < user.getListQuestions().size(); i++) {
//            ClientAnswers clientAnswers = new ClientAnswers();
//            Answers answers = new Answers();
//            Questions questions = new Questions();
//            answers.setAnswer(user.getListQuestions().get(i).getAnswer());
//            questions.setQuestion(user.getListQuestions().get(i).getQuestion());
//
//            clientAnswers.setAnswers(answers);
//            clientAnswers.setQuestions(questions);
//            clientAnswers.setClientes(client);
//
//            clientAnswerList.add(clientAnswers);
//
//        }
//        clientAnswersImpl.saveAll(clientAnswerList);
    }

}
