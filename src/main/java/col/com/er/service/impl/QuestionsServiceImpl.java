package col.com.er.service.impl;

import col.com.er.entity.Questions;
import col.com.er.repository.QuestionsRepo;
import col.com.er.service.QuestionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepo questionsRepo;

    @Override
    public List<Questions> listQuestions() {
        return (List<Questions>) questionsRepo.findAll();

    }

    @Override
    public void save(Questions questions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Questions questions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Questions findUsers(Questions questions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
