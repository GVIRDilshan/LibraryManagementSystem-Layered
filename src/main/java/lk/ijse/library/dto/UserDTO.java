package lk.ijse.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String userName;
    private String password;

    public UserDTO() {

    }
}
