package col.com.er.service.impl;

import col.com.er.dao.ClientAnswersDao;
import col.com.er.entity.ClientAnswers;
import col.com.er.service.ClientAnswesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientAnswersImpl implements ClientAnswesService {

    @Autowired
    private ClientAnswersDao clientAnswersDao;

    
    @Transactional()
    @Override
    public void save(ClientAnswers clientAnswers) { 
      clientAnswersDao.save(clientAnswers);
    }

    @Override
    public void saveAll( List<ClientAnswers> clientAnswers) {
        clientAnswersDao.saveAll(clientAnswers);
    }

}
