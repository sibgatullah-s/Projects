// class for a single task
import java.util.Date;
public class Task {
    private String message;
    private Date rightNow;

    // constructor, takes in message
    public Task (String message) {
        rightNow = java.util.Calendar.getInstance().getTime();
    }
}
