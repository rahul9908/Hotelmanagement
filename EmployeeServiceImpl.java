package hotelService;
import java.util.List;



import files.book;
import files.customer;
import files.rooms;
import database.SqlImpl;



public class EmployeeServiceImpl implements Iemployee {
SqlImpl sq=new SqlImpl();



@Override
public String addroom(rooms r) {
// TODO Auto-generated method stub
return sq.addroom(r);
}
@Override
public String deleteroom(rooms r,String dltId) {
// TODO Auto-generated method stub
return sq.deleteroom(r, dltId);
}



@Override
public String updateroom(rooms r, String updId) {
// TODO Auto-generated method stub
return sq.updateroom(r, updId);
}
@Override
public List<rooms> display(rooms r) {
return sq.display(r);
}
@Override
public List<customer> displaycus() {
// TODO Auto-generated method stub
return sq.displaycus();
}
@Override
public List<book> books() {
// TODO Auto-generated method stub
return sq.books();
}
@Override
public String checkout(String room_id) {
// TODO Auto-generated method stub
return sq.checkout(room_id);
}

}
