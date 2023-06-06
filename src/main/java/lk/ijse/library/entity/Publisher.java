package lk.ijse.library.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Publisher {
    private String PublisherID;
    private String PublisherName;
    private String BookID;
    private String PublishDate;
}
