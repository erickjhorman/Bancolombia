
package col.com.er.service.impl;

import col.com.er.dao.UserDao;
import col.com.er.entity.Users;
import col.com.er.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {
    
    @Autowired
    private UserDao userDao;
     
    @Transactional(readOnly = true)
    @Override
    public List<Users> listUsers() {
        return (List<Users>) userDao.findAll();
    }

    @Transactional()
    @Override
    public void save(Users cbanks) {
        userDao.save(cbanks);
    }

    @Transactional()
    @Override
    public void delete(Users cbanks) {
        userDao.delete(cbanks);
    }

    @Override
    @Transactional(readOnly = true)
    public Users findUsers(Users user) {
        return userDao.findById(user.getId()).orElse(null);

    }

  
}
