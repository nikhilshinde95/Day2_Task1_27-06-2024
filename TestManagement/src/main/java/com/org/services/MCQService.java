package com.org.services;

import java.util.List;

import com.org.entities.MCQQuestion;

public interface MCQService {
	
	public List<MCQQuestion> getAllQuestion();
	
	public MCQQuestion getQuestionById(long questionId);
	
	public MCQQuestion createQuestion(MCQQuestion mcqQuestion);
	
	public MCQQuestion updateQuestion(MCQQuestion mcqQuestion);
	
	public boolean deleteQuestion(long questionId);
	

}
