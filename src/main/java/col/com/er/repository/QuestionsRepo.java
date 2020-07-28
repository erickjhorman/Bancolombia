package col.com.er.repository;

import col.com.er.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepo extends JpaRepository<Questions, Long>{
}
