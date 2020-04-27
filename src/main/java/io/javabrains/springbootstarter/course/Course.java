package io.javabrains.springbootstarter.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
//	(name="course_id")
	private Long id;
	@Column
//	(name="course_name")
	private String name; 
	@Column
//	(name="course_description")
	private String description;

	
	public Course() {
		
	}
	public Course(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}