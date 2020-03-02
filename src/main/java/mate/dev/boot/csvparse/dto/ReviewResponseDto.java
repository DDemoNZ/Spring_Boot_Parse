package mate.dev.boot.csvparse.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewResponseDto {

    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulnessNumerator;
    private String helpfulnessDenominator;
    private Integer score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
