package com.app.referendum.entity;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "opinion_choice")
public class OpinionChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
    private String opinion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "opinion_poll_id", nullable = false)
	private OpinionPoll opinionPoll;

	public OpinionChoice() {
		
	}

	public OpinionChoice(Long id, @NotBlank @Size(max = 40) String opinion, OpinionPoll opinionPoll) {
		super();
		this.id = id;
		this.opinion = opinion;
		this.opinionPoll = opinionPoll;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public OpinionPoll getOpinionPoll() {
		return opinionPoll;
	}

	public void setOpinionPoll(OpinionPoll opinionPoll) {
		this.opinionPoll = opinionPoll;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpinionChoice other = (OpinionChoice) obj;
		return Objects.equals(id, other.id);
	}
}
