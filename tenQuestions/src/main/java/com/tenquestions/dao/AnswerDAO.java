package com.tenquestions.dao;

import com.tenquestions.models.Answer;

public interface AnswerDAO{

    String getAnswersByQuestionsId(int id);

    Answer getById(int id);

}
