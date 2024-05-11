package dao;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

	Optional findBy(Integer id);

}
