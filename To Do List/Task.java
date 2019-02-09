// class for a single task
import java.util.Date;
public class Task {
    private String message;
    // current time and date
    private Date rightNow;
    // date of when task is due
    private Date dateTask;
    // milliseconds in one day
    public static int ONE_DAY = 86400000;
    // milliseconds in one day
    public static int ONE_HOUR = 3600000;

    // constructor, takes in message
    public Task (String message) {
        rightNow = java.util.Calendar.getInstance().getTime();
        this.message = message;
    }

    public Task (String message, int year, int month, int day, int hour, int minute) {
        rightNow = java.util.Calendar.getInstance().getTime();
        this.message = message;
        dateTask = new Date(year - 1900, month - 1, day);
        dateTask.setHours(hour);
        dateTask.setMinutes(minute);
    }

    // return string representation
    public String toString() {
        if (dateTask != null) {
            return "Created on: " + rightNow.toString() + "; " + message + "; Due on: " + dateTask.toString() + "\n\n";
        }
        return rightNow.toString() + "; " + message + "\n\n";
    }
}
