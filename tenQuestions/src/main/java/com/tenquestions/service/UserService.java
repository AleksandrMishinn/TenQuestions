package com.tenquestions.service;

import com.tenquestions.dao.UserDAOImpl;
import com.tenquestions.models.User;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class UserService {

    private UserDAOImpl userDAOImpl = new UserDAOImpl();

    public UserService() {}

    public User getById(int id) {
        return userDAOImpl.getById(id);
    }

    public User getById(String id) {
        return getById(Integer.parseInt(id));
    }

    public User create(Map data) {
        return userDAOImpl.create(data);
    }

    public boolean deleteById(int id) {
        return userDAOImpl.deleteById(id);
    }

    public boolean update(int id, Map data) {
        return userDAOImpl.update(id, data);
    }

}
