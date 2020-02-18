package com.tenquestions.dao;

import java.util.Map;


public interface DAO <T> {

    T create (Map data); //todo Type for Map

    T getById(int id);

    boolean update(int id, Map data); //todo Type for Map

    boolean deleteById(int id);
}
