package mate.dev.boot.csvparse.service.impl;

import java.io.IOException;
import java.util.List;
import mate.dev.boot.csvparse.dto.MostActiveUser;
import mate.dev.boot.csvparse.entity.Review;
import mate.dev.boot.csvparse.repository.ReviewRepository;
import mate.dev.boot.csvparse.service.ReviewService;
import mate.dev.boot.csvparse.util.CsvUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final CsvUtil csvUtil;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CsvUtil csvUtil) {
        this.reviewRepository = reviewRepository;
        this.csvUtil = csvUtil;
    }

    @Override
    public List<Review> parseReviewFile() throws IOException {
        return csvUtil.read();
    }

    @Override
    public List<MostActiveUser> getMostActiveUsers(Pageable pageable) {
        return reviewRepository.findTop(pageable);
    }

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

}
