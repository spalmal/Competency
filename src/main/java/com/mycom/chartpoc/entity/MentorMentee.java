package com.mycom.chartpoc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mentor_mentee database table.
 * 
 */
@Entity
@Table(name="mentor_mentee")
@NamedQuery(name="MentorMentee.findAll", query="SELECT m FROM MentorMentee m")
public class MentorMentee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENTEE_ID")
	private int menteeId;

	@Column(name="MENTOR_ID")
	private int mentorId;

	public MentorMentee() {
	}

	public int getMenteeId() {
		return this.menteeId;
	}

	public void setMenteeId(int menteeId) {
		this.menteeId = menteeId;
	}

	public int getMentorId() {
		return this.mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

}