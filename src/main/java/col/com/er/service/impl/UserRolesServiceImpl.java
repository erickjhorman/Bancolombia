package col.com.er.service.impl;

import col.com.er.dao.UsersRolesDao;
import col.com.er.entity.UserRoles;
import col.com.er.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UsersRolesDao userRolesDao;

    @Transactional()
    @Override
    public void save(UserRoles userRoles) {
        userRolesDao.save(userRoles);
    }
}
