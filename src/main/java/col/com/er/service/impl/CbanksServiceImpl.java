package col.com.er.service.impl;

import col.com.er.dao.CbanksDao;
import col.com.er.domain.Cbanks;
import col.com.er.service.CbanksService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CbanksServiceImpl implements CbanksService {

    @Autowired
    private CbanksDao cbanksDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cbanks> listCbanks() {
        return (List<Cbanks>) cbanksDao.findAll();
    }

    @Transactional()
    @Override
    public void save(Cbanks cbanks) {
        cbanksDao.save(cbanks);
    }

    @Transactional()
    @Override
    public void delete(Cbanks cbanks) {
        cbanksDao.delete(cbanks);
    }

    @Override
    @Transactional(readOnly = true)
    public Cbanks findCbank(Cbanks cbanks) {
        return cbanksDao.findById(cbanks.getId()).orElse(null);

    }

}
