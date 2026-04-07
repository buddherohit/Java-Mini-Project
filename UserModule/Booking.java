package UserModule;
import java.io.*;
import java.time.LocalDateTime;

public class Booking {

    public Booking(String user,String movie,String time,String seat){

        try{

            FileWriter fw = new FileWriter("booking.txt",true);

            fw.write(
                    "User : "+user+
                    " | Movie : "+movie+
                    " | Time : "+time+
                    " | Seat : "+seat+
                    " | Date : "+LocalDateTime.now()+"\n"
            );

            fw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}