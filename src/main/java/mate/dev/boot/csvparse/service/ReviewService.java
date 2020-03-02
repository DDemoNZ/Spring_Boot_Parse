package mate.dev.boot.csvparse.service;

import java.io.IOException;
import java.util.List;

import mate.dev.boot.csvparse.entity.Review;

public interface ReviewService {
    List<Review> parseReviewFile() throws IOException;

    List<Review> getMostActiveUsers();

    List<Review> saveAll(List<Review> reviews);
}
