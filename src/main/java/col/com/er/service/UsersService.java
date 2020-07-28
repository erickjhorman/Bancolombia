
package col.com.er.service;


import col.com.er.entity.Users;
import java.util.List;


public interface UsersService {
    
    public List<Users> listUsers();

    public void save(Users users);

    public void delete(Users users);

    public Users findUsers(Users users);
    
}
