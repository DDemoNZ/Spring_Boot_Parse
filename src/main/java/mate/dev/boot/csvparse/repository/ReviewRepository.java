package mate.dev.boot.csvparse.repository;

import java.util.List;
import mate.dev.boot.csvparse.dto.MostActiveUser;
import mate.dev.boot.csvparse.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT new mate.dev.boot.csvparse.dto.MostActiveUser(r.profileName, "
            + "COUNT(r.profileName))FROM Review AS r GROUP BY r.profileName "
            + "ORDER BY COUNT(r.profileName) DESC")
    List<MostActiveUser> findTop(Pageable pageable);

}
