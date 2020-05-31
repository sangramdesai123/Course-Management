package com.app.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Matrial")
public class TrainingMaterial {
	
	@Id
	private String course;
	private String recording;
	private String ppt;
	private String assignment;
	
	public TrainingMaterial() {	}
	
	public TrainingMaterial(String course, String recording, String ppt, String assignment) {
		super();
		this.course = course;
		this.recording = recording;
		this.ppt = ppt;
		this.assignment = assignment;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getRecording() {
		return recording;
	}
	public void setRecording(String recording) {
		this.recording = recording;
	}
	public String getPpt() {
		return ppt;
	}
	public void setPpt(String ppt) {
		this.ppt = ppt;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	@Override
	public String toString() {
		return "TrainingMaterial [course=" + course + ", recording=" + recording + ", ppt=" + ppt + ", assignment="
				+ assignment + "]";
	}
	
	
	
}
