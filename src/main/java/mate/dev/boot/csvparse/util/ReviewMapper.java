package mate.dev.boot.csvparse.util;

import mate.dev.boot.csvparse.dto.ReviewResponseDto;
import mate.dev.boot.csvparse.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewResponseDto getResponseDto(Review review) {
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setId(review.getId());
        reviewResponseDto.setProductId(review.getProductId());
        reviewResponseDto.setUserId(review.getUserId());
        reviewResponseDto.setProfileName(review.getProfileName());
        reviewResponseDto.setHelpfulnessNumerator(review.getHelpfulnessNumerator());
        reviewResponseDto.setHelpfulnessDenominator(review.getHelpfulnessDenominator());
        reviewResponseDto.setScore(review.getScore());
        reviewResponseDto.setTime(review.getTime());
        reviewResponseDto.setSummary(review.getSummary());
        reviewResponseDto.setText(review.getText());
        return reviewResponseDto;
    }
}
