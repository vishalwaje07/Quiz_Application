package Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Model.Question;
import Model.QuestionWrapper;
import Model.Quiz;
import Model.Response;
import dao.QuestionDao;
import dao.QuizDao;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		 
		return new ResponseEntity<> ("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		java.util.Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q: questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQustionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}
		
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}
	public ResponseEntity<Integer> calculate(Integer id, List<Response> response){
		Quiz quiz = quizDao.findBy(id).get();
		List<Question> questions = quiz.getQuestions();
		
		int right = 0;
		int i=0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
					right++;
					i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
