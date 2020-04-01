package mate.dev.boot.csvparse.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "profile_name")
    private String profileName;
    @Column(name = "helpfulness_numerator")
    private String helpfulnessNumerator;
    @Column(name = "helpfulness_denominator")
    private String helpfulnessDenominator;
    @Column(name = "score")
    private Integer score;
    @Column(name = "time")
    private LocalDateTime time;
    @Column(name = "summary")
    private String summary;
    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

}
