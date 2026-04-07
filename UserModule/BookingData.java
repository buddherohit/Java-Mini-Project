import java.io.Serializable;

public class BookingData implements Serializable {

    String username;
    String movie;
    String time;
    String seat;

    public BookingData(String username,String movie,String time,String seat){
        this.username = username;
        this.movie = movie;
        this.time = time;
        this.seat = seat;
    }

    public String toString(){
        return username + "," + movie + "," + time + "," + seat;
    }
}