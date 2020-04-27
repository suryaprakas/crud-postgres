package io.javabrains.springbootstarter.section;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.javabrains.springbootstarter.course.Course;

@Entity
@Table(name="section")
public class Section {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
//	(name ="section_id")
	private Long id;
	@Column
//	(name ="section_name")
	private String name; 
	@Column
//	(name ="section_description")
	private String description;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name ="course_id")
	private Course course;

	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Section() {
		
	}
	public Section(Long id, String name, String description, Long courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = new Course(courseId, "","");
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