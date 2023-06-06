package lk.ijse.library.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Issuse {
    private String issusId;
    private String issusDate;
    private String memberId;
    private String bookId;
    private String dueDate;
    private String issuseQty;
}
