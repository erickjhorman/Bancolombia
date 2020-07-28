package col.com.er.rest.request;

import col.com.er.entity.Answers;
import col.com.er.entity.ClientAnswers;
import col.com.er.entity.Questions;
import col.com.er.entity.Users;
import col.com.er.entity.dto.QuestionAnswersDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
    private String registredpc;
    private String registredPhase;
    private String identificacion;
    private String image;
    private String termsandconditions;
    private ArrayList<QuestionAnswersDTO> listQuestions;
    private String createdat;
    private String updatedat;

    public Users toEntity() {

        Users newUser = new Users();

        newUser.setUsername(getUsername());
        newUser.setPassword(getPassword());
        newUser.setIdentification(getIdentificacion());
        newUser.setImage(getImage());
        newUser.setRegistedPhase(getRegistredPhase());
        newUser.setRegisterdPC(getRegistredpc());
        newUser.setRegistedPhase(getRegistredPhase());
        newUser.setTermsAndConditions(getTermsandconditions());

        return newUser;
    }

    public List<ClientAnswers> toEntityClientAnswers() {
        List<ClientAnswers> clientAnswerList = new ArrayList();

        getListQuestions()
                .stream()
                .forEach(q
                        -> {
                    ClientAnswers clientAnswers = new ClientAnswers();
                    Answers answers = new Answers();
                    Questions questions = new Questions();
                    questions.setId(Long.valueOf(q.getQuestion()));
                    answers.setAnswer(q.getAnswer());

                    clientAnswers.setQuestions(questions);
                    clientAnswers.setAnswers(answers);
                    
                    clientAnswerList.add(clientAnswers);
                });

        return clientAnswerList;
    }

}
