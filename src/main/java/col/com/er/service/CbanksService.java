package col.com.er.service;

import col.com.er.entity.Cbanks;
import java.util.List;

public interface CbanksService {

    public List<Cbanks> listCbanks();

    public void save(Cbanks cbanks);

    public void delete(Cbanks cbanks);

    public Cbanks findCbank(Cbanks cbanks);

}
