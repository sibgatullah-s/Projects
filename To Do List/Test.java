import java.util.Date;
public class Test {

    public static void main(String[] args) {
        Task a = new Task("Study for MAT1348 midterm", 2018, 2, 11, 2, 30);

        System.out.print(a);
        /*Date b = new Date(2018-1900, 2-1, 11);
        Date c = java.util.Calendar.getInstance().getTime();
        System.out.print(b);
        System.out.print(c);*/
    }
}
