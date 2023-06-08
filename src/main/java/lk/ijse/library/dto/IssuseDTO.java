package lk.ijse.library.dto;

public class IssuseDTO {
    private String issusId;
    private String issusDate;
    private String memberId;
    private String bookId;
    private String dueDate;
    private String issuseQty;

    public IssuseDTO(String issusId, String bookId, String issusDate, String memberId, String dueDate, String issuseQty, String qty, String bookd) {
    }

    public IssuseDTO() {

    }

    public String getIssusId() {
        return issusId;
    }

    public void setIssusId(String issusId) {
        this.issusId = issusId;
    }

    public String getIssusDate() {
        return issusDate;
    }

    public void setIssusDate(String issusDate) {
        this.issusDate = issusDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getIssuseQty() {
        return issuseQty;
    }

    public void setIssuseQty(String issuseQty) {
        this.issuseQty = issuseQty;
    }
}
