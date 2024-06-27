package com.org.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.org.controller.MCQQuestionController;
import com.org.entities.MCQQuestion;
import com.org.services.MCQQuestionServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MCQQuestionControllerTest {

    @Mock
    private MCQQuestionServiceImpl questionService;

    @InjectMocks
    private MCQQuestionController controller;

    @Test
    void getAllQuestions() {
        // Mock data
        MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(questionService.createQuestion(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        ResponseEntity<MCQQuestion> addQuestion = controller.createQuestion(mockQuestion1);
        
        MCQQuestion mockQuestion2 = new MCQQuestion(2L, "SpringBoot Application", "In Spring Boot @RestController annotation is use ", "@Controller and @PostMapping also use", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 4, -2);
        when(questionService.createQuestion(any(MCQQuestion.class))).thenReturn(mockQuestion2);
        ResponseEntity<MCQQuestion> addQuestion2 = controller.createQuestion(mockQuestion2);
        
        List<MCQQuestion> expected=new ArrayList<MCQQuestion>();
        expected.add(mockQuestion1);
        expected.add(mockQuestion2);
        
        // Mock behavior
        when(questionService.getAllQuestion()).thenReturn(expected);

        // Call controller method
        List<MCQQuestion> result = controller.getAllQuestions();

        // Assertions
        assert(result.size() == 2);
        assert(result.get(0).getId() == 1L);
        assert(result.get(1).getId() == 2L);
    }

    @Test
    void getQuestionById() {
        // Mock data
    	 MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
         when(questionService.createQuestion(any(MCQQuestion.class))).thenReturn(mockQuestion1);
         ResponseEntity<MCQQuestion> addQuestion = controller.createQuestion(mockQuestion1);

         when(questionService.getQuestionById(anyLong())).thenReturn(mockQuestion1);
         ResponseEntity<MCQQuestion> actual = controller.getQuestionById(1);
         
        // Assertions
        assert(actual.getStatusCode().equals(HttpStatus.OK));
        assert(actual.getBody().getId() == 1L);

    }

    @Test
    void createQuestion() {
        
   	 	MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(questionService.createQuestion(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        ResponseEntity<MCQQuestion> actual = controller.createQuestion(mockQuestion1);

        // Assertions
        assert(actual.getStatusCode().equals(HttpStatus.CREATED));
        assert(actual.getBody().getId() == 1L);
    }

    @Test
    void updateQuestion() {
        
   	 	MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
        when(questionService.updateQuestion(any(MCQQuestion.class))).thenReturn(mockQuestion1);
        ResponseEntity<MCQQuestion> response = controller.updateQuestion(1L, mockQuestion1);

        // Assertions
        assert(response.getStatusCode().equals(HttpStatus.OK));
        assert(response.getBody().getId() == 1L);
    }

    @Test
    void deleteQuestion() {
        
   	 	MCQQuestion mockQuestion1 = new MCQQuestion(1L, "SpringBoot", "In Spring Boot @RestController annotation is equivalent to", "@Controller and @PostMapping", "@Controller and @Component", "@Controller and @ResponseBody", "@Controller and @ResponseStatus", "@Controller and @ResponseBody", 3, -1);
   	 	when(questionService.createQuestion(any(MCQQuestion.class))).thenReturn(mockQuestion1);
   	 	ResponseEntity<MCQQuestion> addQuestion = controller.createQuestion(mockQuestion1);
   	 	
   	 	when(questionService.deleteQuestion(anyLong())).thenReturn(true);
		ResponseEntity<HttpStatus> deleteStudent = controller.deleteQuestion(1L);
		assertEquals(HttpStatus.OK, deleteStudent.getStatusCode());
		
		when(questionService.deleteQuestion(anyLong())).thenReturn(false);
		ResponseEntity<HttpStatus> deleteStudent2 = controller.deleteQuestion(2L);
		assertNotEquals(HttpStatus.OK, deleteStudent2.getStatusCode());
    }
}
