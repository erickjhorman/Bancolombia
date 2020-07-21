package col.com.er.service.impl;

import col.com.er.dao.ClientDao;
import col.com.er.domain.Client;
import col.com.er.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Transactional(readOnly = true)
    @Override
    public List<Client> listaPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional()
    @Override
    public void guardar(Client client) {
         clientDao.save(client);
    }

    @Transactional()
    @Override
    public void eliminar(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = true)
    @Override
    public Client encontrarPersona(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
