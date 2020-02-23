package com.tenquestions.dao;

import com.tenquestions.models.Question;

public interface QuestionDAO{

    Question getById(int id);

    String getRandomN(int n);

}
