package lk.ijse.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AutorDTO {

    private String AutorID;
    private String AutorName;
    private String BookName;
    private String BookID;
}
