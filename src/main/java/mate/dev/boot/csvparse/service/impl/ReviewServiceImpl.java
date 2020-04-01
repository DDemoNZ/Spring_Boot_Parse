package mate.dev.boot.csvparse.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import mate.dev.boot.csvparse.dto.MostActiveUserResponseDto;
import mate.dev.boot.csvparse.dto.MostPopularWordResponseDto;
import mate.dev.boot.csvparse.dto.ProductResponseDto;
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
    public List<MostActiveUserResponseDto> getMostActiveUsers(Pageable pageable) {
        return reviewRepository.findMostActiveUsers(pageable);
    }

    @Override
    public List<ProductResponseDto> getMostCommentedProducts(Pageable pageable) {
        return reviewRepository.getMostCommentedProducts(pageable);
    }

    @Override
    public List<MostPopularWordResponseDto> getMostPopularWord(Pageable pageable) {
        List<String> allReviews = reviewRepository.getAllReviews();
        Map<String, Long> words = allReviews.stream()
                .flatMap(text -> Arrays.stream(text.replaceAll("[^a-zA-Z\\s]", "")
                        .split(" "))).filter(w -> !w.equals(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((Comparator.reverseOrder())))
                .limit(pageable.getPageSize())
                .map(entry -> new MostPopularWordResponseDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

}
