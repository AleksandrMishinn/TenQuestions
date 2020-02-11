package com.tenquestions.service;

import com.tenquestions.dao.UserDAOImpl;
import com.tenquestions.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {

    private UserDAOImpl userDAOImpl = new UserDAOImpl();

    public UserService() {
    }

    public User getById(int id) {
        return userDAOImpl.getById(id);
    }

    public User create(Map data) {
        return userDAOImpl.create(data);
    }



    public Set getAll() {

        try {
            Set userSet = userDAOImpl.getAll();
            return userSet;
        } catch (Exception e) {
            return null;
        }

    }

    public Map update(User user, Map data) {

        Map resultMap = new HashMap();

        resultMap = userDAOImpl.update(user, data);

        return resultMap;
    }

    public Map delete(int id) {
        Map resultMap = new HashMap<String, String>();
        try {
            userDAOImpl.delete(id);
            resultMap.put("success", "true");
            resultMap.put("errorMessage", "");

        } catch (Exception e) {
            resultMap.put("success", "false");
            resultMap.put("errorMessage", e.getStackTrace());
        }

        return resultMap;
    }


}
