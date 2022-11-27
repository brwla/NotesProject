package Models;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTime{
    public String getDate(){
        LocalDateTime dateObj = LocalDateTime.now();  //for the date and time
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss");
        return dateObj.format(formatObj);
    }
}