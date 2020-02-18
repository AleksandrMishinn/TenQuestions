package com.tenquestions.dao;

public interface QuestionDAO<Question> extends DAO{

    String getRandomN(int n);

}
