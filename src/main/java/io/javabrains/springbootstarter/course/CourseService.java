package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.section.SectionRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	private SectionRepository sectionRepository;
	
//	private List<Topic> topicsn = new ArrayList<>( Arrays.asList(
//			new Topic("spring", "Spring Framework", "Spring Framework Description"),
//			new Topic("java", "Core Java", "Core Java Description"),
//			new Topic("javacsript", "Javascript", "Javascript Description")
//			));
	
	public List<Course> getAllCourses(){
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	public Course getCourse(Long id) {
//		return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).orElse(null);
		}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	public void updateCourse(Course course) {
//		for (int i =0; i < topics.size(); i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(course);
		
	}
	public void deleteCourse(Long id) {
//		topics.removeIf(t -> t.getId().equals(id));
		System.out.println(sectionRepository.findByCourseId(id).isEmpty());
		if(sectionRepository.findByCourseId(id).isEmpty())
			courseRepository.deleteById(id);
		else
			sectionRepository.findByCourseId(id).removeAll(sectionRepository.findByCourseId(id));
			courseRepository.deleteById(id);
		
	}	
}
