package mate.dev.boot.csvparse.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mate.dev.boot.csvparse.dto.MostActiveUser;
import mate.dev.boot.csvparse.entity.Review;
import mate.dev.boot.csvparse.service.ReviewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parse")
public class ReviewReadController {

    private static List<Review> reviews;
    private final Logger logger = LogManager.getLogger(ReviewReadController.class);
    private final ReviewService reviewService;

    public ReviewReadController(ReviewService reviewService) {
        reviews = new ArrayList<>();
        this.reviewService = reviewService;
    }

    @GetMapping("/read")
    public String parseReviewFile() throws IOException {
        logger.info("Parsing started " + LocalDateTime.now());
        reviews = reviewService.parseReviewFile();
        logger.info("Parsing finished " + LocalDateTime.now());
        return "Parse csv file Review successful.";
    }

    @GetMapping("/insert")
    public String insertReviewsIntoDB() {
        logger.info("Inserted to db started " + LocalDateTime.now());
        reviewService.saveAll(ReviewReadController.reviews);
        logger.info("Inserting finished " + LocalDateTime.now());
        return "Inserting success.";
    }

    @GetMapping("/most-active")
    public List<MostActiveUser> getMostActiveUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "count", required = false, defaultValue = "100") Integer count) {
        logger.info("\"Get most active users\" started " + LocalDateTime.now());
        Pageable pageable = PageRequest.of(page, count);
        logger.info("Getting most active users finished " + LocalDateTime.now());
        return reviewService.getMostActiveUsers(pageable);
    }

}
