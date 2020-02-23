package com.tenquestions.dao;


import com.tenquestions.models.User;

import java.util.Map;

public interface UserDAO{

    User create (Map data);

    User getById(int id);

    boolean deleteById(int id);

    boolean update(int id, Map data);
}
