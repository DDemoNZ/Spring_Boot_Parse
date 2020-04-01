package mate.dev.boot.csvparse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MostActiveUser {

    private String profileName;
    private Long reviews;
}
