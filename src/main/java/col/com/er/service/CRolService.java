package col.com.er.service;

import col.com.er.domain.Cbanks;
import col.com.er.domain.Crol;
import java.util.List;

public interface CRolService {

    public List<Crol> listCRols();

    public void save(Crol crol);

    public void delete(Crol crol);

    public Crol findCRol(Crol crol);
}
