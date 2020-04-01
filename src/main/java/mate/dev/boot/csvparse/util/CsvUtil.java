package mate.dev.boot.csvparse.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mate.dev.boot.csvparse.entity.Review;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class CsvUtil {

    private static final String CSV_FILE_PATH = "src/main/resources/Reviews.csv";
    private static final String[] HEADERS = {"Id", "ProductId", "UserId", "ProfileName",
            "HelpfulnessNumerator",
            "HelpfulnessDenominator", "Score", "Time", "Summary", "Text",};

    public List<Review> read() throws IOException {
        Reader reader = new FileReader(CSV_FILE_PATH);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(reader);
        List<Review> reviews = new ArrayList<>();
        records.forEach(rec -> getReview(rec, reviews));
        return reviews;
    }

    private void getReview(CSVRecord record, List<Review> reviews) {
        Review review = new Review();
        review.setProductId(record.get("ProductId"));
        review.setUserId(record.get("UserId"));
        review.setProfileName(record.get("ProfileName"));
        review.setHelpfulnessNumerator(record.get("HelpfulnessNumerator"));
        review.setHelpfulnessDenominator(record.get("HelpfulnessDenominator"));
        review.setScore(Integer.valueOf(record.get("Score")));
        review.setTime(LocalDateTime.now()); //TODO temporary realization
        review.setSummary(record.get("Summary"));
        review.setText(record.get("Text"));
        reviews.add(review);
    }
}
