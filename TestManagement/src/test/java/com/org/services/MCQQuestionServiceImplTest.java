package com.org.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.org.dao.MCQDao;
import com.org.entities.MCQQuestion;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MCQQuestionServiceImplTest {

	@Mock
	private MCQDao mcqDao;
	
	@InjectMocks
	private MCQQuestionServiceImpl mcqQuestionServiceImpl;
	
	@Test
	void getAllQuestion() {
		 	MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
	        when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion1);
	        MCQQuestion addQuestion1 = mcqQuestionServiceImpl.createQuestion(mockQuestion1);
	        
	        MCQQuestion mockQuestion2 = new MCQQuestion(2L, "SpringBoot Application", "In Spring Boot @RestController annotation is use ", "@Controller and @PostMapping also use", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 4, -2);
	        when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion2);
	        MCQQuestion addQuestion2 = mcqQuestionServiceImpl.createQuestion(mockQuestion1);
	        
	        List<MCQQuestion> expected=new ArrayList<MCQQuestion>();
	        expected.add(mockQuestion1);
	        expected.add(mockQuestion2);
	        
	        when(mcqDao.findAll()).thenReturn(expected);
	        List<MCQQuestion> allQuestion = mcqQuestionServiceImpl.getAllQuestion();
	        assert(allQuestion.size() == 2);
	        assert(allQuestion.get(0).getId() == 1L);
	        assert(allQuestion.get(1).getId() == 2L);
	}
	
	
	@Test
	void getQuestionById() {
		
		MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        MCQQuestion addQuestion1 = mcqQuestionServiceImpl.createQuestion(mockQuestion1);
        
        when(mcqDao.findById(anyLong())).thenReturn(Optional.of(addQuestion1));
        MCQQuestion actual = mcqQuestionServiceImpl.getQuestionById(1);
        
        assertEquals(1, actual.getId());
       assertNotEquals(2, actual.getId());
	}
	
	
	@Test
	void createQuestion() {
		
		MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        MCQQuestion addQuestion1 = mcqQuestionServiceImpl.createQuestion(mockQuestion1);
        
        assertEquals(addQuestion1, mockQuestion1);
        
	}
	
	@Test
	void updateQuestion() {
		
		MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        MCQQuestion addQuestion1 = mcqQuestionServiceImpl.createQuestion(mockQuestion1);
        
		MCQQuestion mockQuestion2 = new MCQQuestion(1L, "SpringBoot1", "In Spring Boot @RestController and @Controller annotation", "@Controller and @PostMapping", "@Id and @Entity", "@Service and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 5, -1);
		when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion2);
		MCQQuestion updateQuestion = mcqQuestionServiceImpl.updateQuestion(mockQuestion2);
		
		assertEquals("@Id and @Entity",updateQuestion.getOptionTwo());
		
	}
	
	@Test
	void deleteQuestion() {
		
		MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(mcqDao.save(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        MCQQuestion addQuestion1 = mcqQuestionServiceImpl.createQuestion(mockQuestion1);
        
        when(mcqDao.findById(anyLong())).thenReturn(Optional.of(addQuestion1));
        boolean deleteQuestion = mcqQuestionServiceImpl.deleteQuestion(1);
        assertEquals(true, deleteQuestion);
	}
	
	
	
	
}
