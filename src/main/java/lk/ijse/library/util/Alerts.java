package lk.ijse.library.util;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Alerts {
    public void notification(String text, String title) {
        Notifications notifications = Notifications.create();
        notifications.text(text);
        notifications.title(title);
        notifications.hideAfter(Duration.seconds(2));
        notifications.show();
        notifications.position(Pos.TOP_RIGHT);
    }

}
