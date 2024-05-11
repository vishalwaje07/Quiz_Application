
package dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Model.Question;

@Repository

public interface QuestionDao extends JpaRepository<Question, Integer> {
	@Bean
   List<Question> findByCategory(String category);
	
	@Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT : numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
