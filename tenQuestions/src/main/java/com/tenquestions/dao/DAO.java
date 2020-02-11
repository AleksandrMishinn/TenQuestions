package com.tenquestions.dao;

import java.util.Map;
import java.util.Set;

public interface DAO <T> {

    T create (Map<String, String> data);

    T getById(int id);

    Set getAll();

    Map update(T t, Map data);

    Map delete(int id);
}
