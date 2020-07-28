package col.com.er.service;

import col.com.er.entity.Cbanks;
import col.com.er.entity.Crol;
import java.util.List;

public interface CrolService {

    public List<Crol> listCRols();

    public void save(Crol crol);

    public void delete(Crol crol);

    public Crol findCRol(Crol crol);
}
