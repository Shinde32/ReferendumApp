package com.app.referendum.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.app.referendum.entity.audit.UserDateAudit;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "opinion_poll")
public class OpinionPoll extends UserDateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 140)
	private String referendumQuestion;

	@OneToMany(mappedBy = "opinionPoll", fetch = FetchType.EAGER)
	@Size(min = 2, max = 5)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 30)
	private List<OpinionChoice> opinions = new ArrayList<>();

	@NotNull
	private Instant pollExpirationDate;

	public OpinionPoll() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferendumQuestion() {
		return referendumQuestion;
	}

	public void setReferendumQuestion(String referendumQuestion) {
		this.referendumQuestion = referendumQuestion;
	}

	public List<OpinionChoice> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<OpinionChoice> opinions) {
		this.opinions = opinions;
	}

	public Instant getPollExpirationDate() {
		return pollExpirationDate;
	}

	public void setPollExpirationDate(Instant pollExpirationDate) {
		this.pollExpirationDate = pollExpirationDate;
	}

    public void addChoice(OpinionChoice opinionChoice) {
    	opinions.add(opinionChoice);
    	opinionChoice.setOpinionPoll(this);
    }

    public void removeChoice(OpinionChoice opinionChoice) {
    	opinions.remove(opinionChoice);
    	opinionChoice.setOpinionPoll(null);
    }
}
