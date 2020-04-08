package mate.dev.boot.csvparse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MostActiveUserResponseDto {

    private String profileName;
    private Long reviews;
}
