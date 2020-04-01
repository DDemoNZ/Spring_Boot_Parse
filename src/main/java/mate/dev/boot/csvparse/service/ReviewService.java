package mate.dev.boot.csvparse.service;

import java.io.IOException;
import java.util.List;
import mate.dev.boot.csvparse.dto.MostActiveUserResponseDto;
import mate.dev.boot.csvparse.dto.MostPopularWordResponseDto;
import mate.dev.boot.csvparse.dto.ProductResponseDto;
import mate.dev.boot.csvparse.entity.Review;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    List<Review> parseReviewFile() throws IOException;

    List<MostActiveUserResponseDto> getMostActiveUsers(Pageable pageable);

    List<Review> saveAll(List<Review> reviews);

    List<MostPopularWordResponseDto> getMostPopularWord(Pageable pageable);

    List<ProductResponseDto> getMostCommentedProducts(Pageable pageable);
}
