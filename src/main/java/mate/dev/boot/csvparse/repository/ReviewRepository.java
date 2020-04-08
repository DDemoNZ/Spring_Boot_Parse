package mate.dev.boot.csvparse.repository;

import java.util.List;
import mate.dev.boot.csvparse.dto.MostActiveUserResponseDto;
import mate.dev.boot.csvparse.dto.ProductResponseDto;
import mate.dev.boot.csvparse.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT new mate.dev.boot.csvparse.dto.MostActiveUserResponseDto(r.profileName, "
            + "COUNT(r.profileName))FROM Review AS r GROUP BY r.profileName "
            + "ORDER BY COUNT(r.profileName) DESC")
    List<MostActiveUserResponseDto> findMostActiveUsers(Pageable pageable);

    @Query(value = "SELECT new java.lang.String(r.text) FROM Review AS r")
    List<String> getAllReviews();

    @Query(value = "SELECT new mate.dev.boot.csvparse.dto.ProductResponseDto(r.productId,"
            + " COUNT (r.text)) FROM Review AS r GROUP BY r.productId "
            + "ORDER BY COUNT(r.productId) DESC ")
    List<ProductResponseDto> getMostCommentedProducts(Pageable pageable);
}
