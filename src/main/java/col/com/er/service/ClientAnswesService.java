package col.com.er.service;

import col.com.er.entity.ClientAnswers;
import java.util.List;

public interface ClientAnswesService {

    public void save(ClientAnswers clientAnswers);

    public void saveAll(List<ClientAnswers> clientAnswers);
}
