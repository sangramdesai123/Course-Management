package com.app.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String creator;
	private String description;
	private String skill;
	private String prerequisite;
	private String lastUpdated;
	private String feedback;
	private int ratting;
	
	public Course() {}
	
	public Course(int id, String creator, String description, String skill, String prerequisite, String lastUpdated,
			String feedback, int ratting) {
		super();
		this.id = id;
		this.creator = creator;
		this.description = description;
		this.skill = skill;
		this.prerequisite = prerequisite;
		this.lastUpdated = lastUpdated;
		this.feedback = feedback;
		this.ratting = ratting;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}
	public String getlastUpdated() {
		return lastUpdated;
	}
	public void setlastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRatting() {
		return ratting;
	}
	public void setRatting(int ratting) {
		this.ratting = ratting;
	}
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", creator=" + creator + ", description=" + description + ", skill=" + skill
				+ ", prerequisite=" + prerequisite + ", lastUpdated=" + lastUpdated + ", feedback=" + feedback
				+ ", ratting=" + ratting + "]";
	}
	

	
	
	
}
