package lk.ijse.library.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Donetion {
    private String donetionId;
    private String review;
    private double Ammount;
    private String donetionName;
    private String ExibitionId;

    public Donetion(String donetionId, double ammount, String review, String donetionName, String exibitionId) {

    }
}