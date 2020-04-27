package io.javabrains.springbootstarter.section;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.course.Course;


@RestController
public class SectionController {
	
	@Autowired
	private SectionService courseService;
	
	@RequestMapping("/courses/{id}/sections/")
	public List<Section> getAllCourses(@PathVariable Long id) {
		return courseService.getAllSections(id);
	}
		
	@RequestMapping("/courses/{courseId}/sections/{id}")
	public Section getCourse(@PathVariable Long id) {
		return courseService.getSection(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courses/{courseId}/sections/")
	public void addCourse(@RequestBody Section section, @PathVariable Long courseId) {
		section.setCourse(new Course(courseId, "", ""));
		courseService.addSection(section);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{courseId}/sections/{id}")
	public void updateCourse(@RequestBody Section section, @PathVariable Long id, @PathVariable Long courseId) {
		section.setCourse(new Course(courseId, "", ""));
		courseService.updateSection(section);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{courseId}/sections/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteSection(id);
	}
}
