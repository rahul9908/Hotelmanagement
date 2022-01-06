package database;



import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import files.book;
import files.customer;
import files.rooms;



public class SqlImpl {
Connection con = ConnectionUtil.getConnection();
public String addroom(rooms r) {
String sql="insert into rooms values(?,?,?,?,?,?,?)";
try {
PreparedStatement pst1=con.prepareStatement(sql);
pst1.setString(1,r.getRoom_id());
pst1.setString(2,r.getRoom_type());
pst1.setString(3,r.getWifi());
pst1.setString(4,r.getTv());
pst1.setDouble(5,r.getPrice());
pst1.setString(6,r.getXtra_fea());
pst1.setString(7,r.getStatus());

System.out.println(pst1.executeUpdate());
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return "success";
}
public String updateroom(rooms r,String updId) {
String sql1="update rooms set room_status=? where room_id=? ";
try {
PreparedStatement pst2=con.prepareStatement(sql1);
pst2.setString(1,"vacant");
pst2.setString(2,updId);
System.out.println(pst2.executeUpdate());
}
catch(SQLException e) {
e.printStackTrace();
}
return "success";
}
public String deleteroom(rooms r, String dltId) {
String sql1="delete from rooms where room_id=? ";
try {
PreparedStatement pst2=con.prepareStatement(sql1);

pst2.setString(1,dltId);
System.out.println(pst2.executeUpdate());
}
catch(SQLException e) {
e.printStackTrace();
}



return "success";
}
public List<rooms> display(rooms r) {
List<rooms> ar=new ArrayList<rooms>();
String sql1="select * from rooms ";
try {
PreparedStatement pst2=con.prepareStatement(sql1);
ResultSet rs=pst2.executeQuery();
while (rs.next()) {
r.setRoom_id(rs.getString(1));
r.setRoom_type(rs.getString(2));
r.setWifi(rs.getString(3));
r.setTv(rs.getString(4));
r.setPrice(rs.getLong(5));
r.setXtra_fea(rs.getString(6));
r.setStatus(rs.getString(7));
ar.add(r);
}
}
catch(SQLException e) {
e.printStackTrace();
}
return ar;
}
public List<customer> displaycus() {

List<customer> cr=new ArrayList<customer>();
String sql1="select * from customer ";
try {
PreparedStatement pst2=con.prepareStatement(sql1);
ResultSet rs2=pst2.executeQuery();
while (rs2.next()) {
customer c=new customer();
c.setCus_id(rs2.getString(1));
c.setCus_name(rs2.getString(2));
c.setCus_email(rs2.getString(3));
c.setCus_pass(rs2.getString(4));
c.setCus_num(rs2.getLong(5));
cr.add(c);
}
}
catch(SQLException e) {
e.printStackTrace();
}
return cr;
}
public String addcus(customer c) {
// TODO Auto-generated method stub
String sql="insert into customer values(?,?,?,?,?)";
try {
PreparedStatement pst1=con.prepareStatement(sql);
pst1.setString(1,c.getCus_id());
pst1.setString(2,c.getCus_name());
pst1.setString(3,c.getCus_email());
pst1.setString(4,c.getCus_pass());
pst1.setLong(5,c.getCus_num());
System.out.println(pst1.executeUpdate());
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return "success";
}
public int login(String cname, String cpassword) {
int login=0;
String Sql=" select count(*) from customer where cus_mail=? and cus_pass=?";



try {
PreparedStatement pst5=con.prepareStatement(Sql);
pst5.setString(1,cname);
pst5.setString(2, cpassword);
ResultSet rs=pst5.executeQuery();
rs.next();
login=rs.getInt(1);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}



return login;
}
public List<book> books() {
List<book> ar=new ArrayList<book>();
String sql1="select * from bookings ";
try {
PreparedStatement pst2=con.prepareStatement(sql1);
ResultSet rs=pst2.executeQuery();
while (rs.next()) {
book b=new book();
b.setCus_id(rs.getString(1));
b.setRoom_id(rs.getString(2));
b.setPrice(rs.getDouble(3));
b.setCheckout(rs.getString(4));
ar.add(b);
}
}
catch(SQLException e) {
e.printStackTrace();
}
return ar;
}
public String updatecus(String email, String pass,String cusId) {
String sql1="update customer set cus_mail=?, cus_pass=? where cus_id=?; ";
try {
PreparedStatement pst2=con.prepareStatement(sql1);
pst2.setString(1,email);
pst2.setString(2,pass);
pst2.setString(3,cusId);
System.out.println(pst2.executeUpdate());
}
catch(SQLException e) {
e.printStackTrace();
}
return "success";
}
public String bookroom(String cus_id, String room_id, Double price, String date) {
String sql="insert into bookings values(?,?,?,?)";
try {
PreparedStatement pst1=con.prepareStatement(sql);
pst1.setString(1,cus_id);
pst1.setString(2,room_id);
pst1.setDouble(3,price);
pst1.setString(4,date);
System.out.println(pst1.executeUpdate());
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return "success";
}
public String checkout(String room_id) {
String sql1="update rooms set room_status=? where room_id=?";
try {
PreparedStatement pst2=con.prepareStatement(sql1);
pst2.setString(1,"vacant");
pst2.setString(2,room_id);
System.out.println(pst2.executeUpdate());
}
catch(SQLException e) {
e.printStackTrace();
}
return "success";
}
}
