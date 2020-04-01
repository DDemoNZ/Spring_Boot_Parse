package mate.dev.boot.csvparse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MostPopularWordResponseDto {

    private String word;
    private Long count;
}
