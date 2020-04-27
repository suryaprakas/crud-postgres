package io.javabrains.springbootstarter.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {
	
	@Autowired
	private SectionRepository sectionRepository;
	
//	private List<Topic> topics = new ArrayList<>( Arrays.asList(
//			new Topic("spring", "Spring Framework", "Spring Framework Description"),
//			new Topic("java", "Core Java", "Core Java Description"),
//			new Topic("javacsript", "Javascript", "Javascript Description")
//			));
	
	public List<Section> getAllSections(Long courseId){
		List<Section> courses = new ArrayList<>();
		System.out.println(courseId);
		System.out.println(sectionRepository.findByCourseId(courseId));
		sectionRepository.findByCourseId(courseId).forEach(courses::add);
		return courses;
	}
	public Section getSection(Long id) {
//		return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return sectionRepository.findById(id).orElse(null);
		}
	
	public void addSection(Section section) {
		sectionRepository.save(section);
	}
	public void updateSection(Section section) {
//		for (int i =0; i < topics.size(); i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		sectionRepository.save(section);
		
	}
	public void deleteSection(Long id) {
//		topics.removeIf(t -> t.getId().equals(id));
		sectionRepository.deleteById(id);
	}
}
