package com.org.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "mcq_question")
public class MCQQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "question")
    private String question;

    @Column(name = "option_one")
    private String optionOne;

    @Column(name = "option_two")
    private String optionTwo;

    @Column(name = "option_three")
    private String optionThree;

    @Column(name = "option_four")
    private String optionFour;

    @Column(name = "correct_option")
    private String correctOption;

    @Column(name = "positive_mark")
    private int positiveMark;

    @Column(name = "negative_mark")
    private int negativeMark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionOne() {
		return optionOne;
	}

	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}

	public String getOptionTwo() {
		return optionTwo;
	}

	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}

	public String getOptionThree() {
		return optionThree;
	}

	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}

	public String getOptionFour() {
		return optionFour;
	}

	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public int getPositiveMark() {
		return positiveMark;
	}

	public void setPositiveMark(int positiveMark) {
		this.positiveMark = positiveMark;
	}

	public int getNegativeMark() {
		return negativeMark;
	}

	public void setNegativeMark(int negativeMark) {
		this.negativeMark = negativeMark;
	}

	public MCQQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MCQQuestion(Long id, String category, String question, String optionOne, String optionTwo,
			String optionThree, String optionFour, String correctOption, int positiveMark, int negativeMark) {
		super();
		this.id = id;
		this.category = category;
		this.question = question;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.correctOption = correctOption;
		this.positiveMark = positiveMark;
		this.negativeMark = negativeMark;
	}

	@Override
	public String toString() {
		return "MCQQuestion [id=" + id + ", category=" + category + ", question=" + question + ", optionOne="
				+ optionOne + ", optionTwo=" + optionTwo + ", optionThree=" + optionThree + ", optionFour=" + optionFour
				+ ", correctOption=" + correctOption + ", positiveMark=" + positiveMark + ", negativeMark="
				+ negativeMark + "]";
	}

    
}
