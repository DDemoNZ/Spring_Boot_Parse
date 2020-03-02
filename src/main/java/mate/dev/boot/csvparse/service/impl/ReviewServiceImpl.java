package mate.dev.boot.csvparse.service.impl;

import java.io.IOException;
import java.util.List;

import mate.dev.boot.csvparse.entity.Review;
import mate.dev.boot.csvparse.repository.ReviewRepository;
import mate.dev.boot.csvparse.service.ReviewService;
import mate.dev.boot.csvparse.util.CsvUtil;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> parseReviewFile() throws IOException {
        return CsvUtil.read();
    }

    @Override
    public List<Review> getMostActiveUsers() {
        return reviewRepository.findTop();
    }

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }
}
