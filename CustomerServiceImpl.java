package hotelService;



import files.customer;
import database.SqlImpl;



public class CustomerServiceImpl implements Icustomer{
SqlImpl sq=new SqlImpl();



@Override
public String addcus(customer c) {
// TODO Auto-generated method stub
return sq.addcus(c);
}



@Override
public int login(String email, String pass) {
// TODO Auto-generated method stub
return sq.login(email, pass);
}



@Override
public String updatecus(String email, String pass,String cusId) {
// TODO Auto-generated method stub
return sq.updatecus(email,pass, cusId);
}



@Override
public String bookroom(String cus_id, String room_id, Double price, String date) {
// TODO Auto-generated method stub
return sq.bookroom(cus_id, room_id, price, date);
}






}
