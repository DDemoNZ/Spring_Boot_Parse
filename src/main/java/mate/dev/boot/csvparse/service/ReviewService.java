package mate.dev.boot.csvparse.service;

import java.io.IOException;
import java.util.List;
import mate.dev.boot.csvparse.dto.MostActiveUser;
import mate.dev.boot.csvparse.entity.Review;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    List<Review> parseReviewFile() throws IOException;

    List<MostActiveUser> getMostActiveUsers(Pageable pageable);

    List<Review> saveAll(List<Review> reviews);
}
