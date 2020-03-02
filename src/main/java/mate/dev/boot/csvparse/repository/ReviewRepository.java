package mate.dev.boot.csvparse.repository;

import java.util.List;

import mate.dev.boot.csvparse.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    //Temporary .try to do custom method
    @Query(nativeQuery = true, value = "SELECT * FROM Review r ORDER BY r.score DESC LIMIT 10")
    List<Review> findTop();
}
