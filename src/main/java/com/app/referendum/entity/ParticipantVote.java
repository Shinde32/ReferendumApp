package com.app.referendum.entity;

import com.app.referendum.entity.audit.DateAudit;

import jakarta.persistence.*;

@Entity
@Table(name = "participant_vote", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "opinion_poll_id", "participant_id" }) })
public class ParticipantVote extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "opinion_poll_id", nullable = false)
	private OpinionPoll opinionPoll;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "opinion_choice_id", nullable = false)
	private OpinionChoice opinionChoice;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "participant_id", nullable = false)
	private Participant participant;

	public ParticipantVote() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OpinionPoll getOpinionPoll() {
		return opinionPoll;
	}

	public void setOpinionPoll(OpinionPoll opinionPoll) {
		this.opinionPoll = opinionPoll;
	}

	public OpinionChoice getOpinionChoice() {
		return opinionChoice;
	}

	public void setOpinionChoice(OpinionChoice opinionChoice) {
		this.opinionChoice = opinionChoice;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	
}
