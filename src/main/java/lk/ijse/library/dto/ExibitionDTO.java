package lk.ijse.library.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ExibitionDTO {
    private String ExibitionId;
    private String ExibitionDate;
    private String ExibitionTime;
    private String ExibitionDesc;
}
