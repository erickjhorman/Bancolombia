package col.com.er.service;

import col.com.er.entity.Questions;
import java.util.List;

public interface QuestionsService {

    public List<Questions> listQuestions();

    public void save(Questions questions);

    public void delete(Questions questions);

    public Questions findUsers(Questions questions);

}
