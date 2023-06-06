package lk.ijse.library.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Return {
    private String ReturnId;
    private String IssuseId;
    private String RreturnQty;
    private String ReturnDate;
    private String BookId;
    private String IssuseDate;
}
