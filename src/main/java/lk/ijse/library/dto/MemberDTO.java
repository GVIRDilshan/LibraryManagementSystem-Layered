package lk.ijse.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String id;
    private String name;
    private String address;
    private String Contact;
    private int age;
    private String Email;
    private String Gender;


}
