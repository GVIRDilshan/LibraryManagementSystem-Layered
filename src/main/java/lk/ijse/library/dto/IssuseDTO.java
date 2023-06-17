package lk.ijse.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuseDTO {
    private String issusId;
    private String issusDate;
    private String memberId;
    private String bookId;
    private String dueDate;
    private String issuseQty;

}