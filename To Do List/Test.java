import java.util.Date;
import java.io.FileWriter;
import java.io.*;
import java.text.SimpleDataFormat;
public class Test {

    public static void main(String[] args) {
        String header = "Created,Task,End\n";
        SimpleDataFormat format = new SimpleDataFormat("E MMM dd ")
        Task a = new Task("Study for MAT1348 midterm", 2018, 2, 11, 2, 30);
        Task b = new Task("Study for MAT1348 midterm");

        System.out.println(a.getStart());
        System.out.println(a.getEnd());

        System.out.println(a.toRepr());
        System.out.println(b.toRepr());
        /*Date b = new Date(2018-1900, 2-1, 11);
        Date c = java.util.Calendar.getInstance().getTime();
        System.out.print(b);
        System.out.print(c);*/
        try {
            // Header

            System.out.println(header);
            FileWriter csvWriter = new FileWriter("new.csv");
            csvWriter.append(header);
            csvWriter.append(a.toRepr());
            csvWriter.append(b.toRepr());
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
