package hotelService;



import java.util.List;



import files.book;
import files.customer;
import files.rooms;



public interface Iemployee {
public String addroom(rooms r);
public String deleteroom(rooms r,String dltId);
public String updateroom(rooms r,String updId);
public List<rooms> display(rooms r);
public List<customer> displaycus();
public List<book> books();
public String checkout(String room_id);
}
