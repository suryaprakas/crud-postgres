package io.javabrains.springbootstarter.section;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<Section, Long> {

	public List<Section> findByCourseId(Long courseId);
}
