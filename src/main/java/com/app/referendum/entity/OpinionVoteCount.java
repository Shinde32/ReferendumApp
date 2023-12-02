package com.app.referendum.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "opinion_vote_count")
public class OpinionVoteCount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private Long opinionId;
    private Long voteCount;
 
	public OpinionVoteCount(Long id, Long opinionId, Long voteCount) {
		super();
		this.id = id;
		this.opinionId = opinionId;
		this.voteCount = voteCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOpinionId() {
		return opinionId;
	}

	public void setOpinionId(Long opinionId) {
		this.opinionId = opinionId;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}
}
