
package col.com.er.service;

import col.com.er.domain.Client;
import java.util.List;

public interface ClientService {
    
    public List<Client> listaPersonas();

    public void guardar(Client client);

    public void eliminar(Client client);

    public Client encontrarPersona(Client client);
    
}
