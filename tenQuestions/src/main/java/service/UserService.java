package service;

import dao.UserDAO;
import models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public UserService() {
    }

    public Map create(Map data) {

        Map resultMap = new HashMap<String, String>();
        try {
            userDAO.create(data);
            resultMap.put("success", "true");
            resultMap.put("errorMessage", "");

        } catch (Exception e) {
            resultMap.put("success", "false");
            resultMap.put("errorMessage", e.getStackTrace());
        }

        return resultMap;
    }

    public User getById(int id) {

        try {
            User user = userDAO.getById(id);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    public Set getAll() {

        try {
            Set userSet = userDAO.getAll();
            return userSet;
        } catch (Exception e) {
            return null;
        }

    }

    public Map update(User user, Map data) {

        Map resultMap = new HashMap();

        resultMap = userDAO.update(user, data);

        return resultMap;
    }

    public Map delete(int id) {
        Map resultMap = new HashMap<String, String>();
        try {
            userDAO.delete(id);
            resultMap.put("success", "true");
            resultMap.put("errorMessage", "");

        } catch (Exception e) {
            resultMap.put("success", "false");
            resultMap.put("errorMessage", e.getStackTrace());
        }

        return resultMap;
    }


}
