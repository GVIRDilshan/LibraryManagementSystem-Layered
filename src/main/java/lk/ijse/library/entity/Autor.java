package lk.ijse.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Autor {
    private String AutorID;
    private String AutorName;
    private String BookName;
    private String BookID;
}
