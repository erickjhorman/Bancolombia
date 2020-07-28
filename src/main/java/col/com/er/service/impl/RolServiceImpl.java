package col.com.er.service.impl;

import col.com.er.dao.CrolDao;
import col.com.er.entity.Crol;
import col.com.er.service.CrolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements CrolService {

    @Autowired
    private CrolDao croldao;

    @Transactional(readOnly = true) // I put readOnly because we will only read data in the database
    @Override
    public List<Crol> listCRols() {
        return  (List<Crol>) croldao.findAll();
    }

    @Override
    public void save(Crol crol) {

    }

    @Override
    public void delete(Crol crol) {

    }

    @Override
    public Crol findCRol(Crol crol) {
        
        return croldao.findById(crol.getIdRol()).orElse(null);
    }

}
