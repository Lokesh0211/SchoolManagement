package Main;
import java.util.*;

import java.sql.*;
public class Student {
String Fname, Lname, FatherName, gender, address, phoneNumber;
int Rno, Class, age;
Connection conn = null;
Statement stmt = null; 
ResultSet rs = null;
String url = "jdbc:mysql://localhost:3307/studentData";
public void GetStudentDetails() {
	System.out.println("enter the student details accordingly: ");
	Scanner sc = new Scanner(System.in);
	System.out.print("First Name: ");
	Fname = sc.next();
	System.out.print("Last Name: ");
	Lname = sc.next();
	System.out.print("Father Name: ");
	FatherName = sc.next();
	System.out.print("Gender(enter Male/Female): ");
	sc.nextLine();
	gender = sc.next();
	System.out.print("Enter Address: ");
	sc.nextLine();
	address = sc.next();
	System.out.print("Enter Roll No: ");
	Rno = sc.nextInt();
	System.out.print("Enter Class: ");
	Class = sc.nextInt(); 
	System.out.print("Enter age: ");
	age = sc.nextInt();
	System.out.print("Enter Mobile number: ");
	phoneNumber = sc.next();
	sc.close();
}
public void createTable() {
    try {
        conn = DriverManager.getConnection(url, "root", "l@%02okj*$");
        stmt = conn.createStatement();
        DatabaseMetaData dmm = conn.getMetaData();
        rs = dmm.getTables(null, null, "STUDENT", null);
        if (rs.next()) {
           
        } else {
            stmt.execute("CREATE TABLE STUDENT(Fname varchar(30), Lname varchar(30), FatherName VARCHAR(20), gender VARCHAR(10), Address VARCHAR(50), Rno INTEGER PRIMARY KEY, class INTEGER, age INTEGER, PhoneNumber BIGINT)");
            System.out.println("Table created successfully");
        }

    } catch (Exception e) {
        System.out.println("error connecting to database");
    }

}
public void addStudentDetails() {
	try {
		createTable();
		GetStudentDetails();
	    String insert = "INSERT INTO STUDENT(Fname, Lname, FatherName, gender, address, Rno, Class, age, phoneNumber) VALUES(?,?,?,?,?,?,?,?,?)";
	    PreparedStatement stmt = conn.prepareStatement(insert);
	    stmt.setString(1, Fname);
	    stmt.setString(2, Lname);
	    stmt.setString(3, FatherName);
	    stmt.setString(4, gender);
	    stmt.setString(5, address);
	    stmt.setInt(6, Rno);
	    stmt.setInt(7, Class);
	    stmt.setInt(8, age);
	    stmt.setString(9, phoneNumber);
	    int rowsInserted = stmt.executeUpdate();
		System.out.println("inserted in db");
		
	}catch(Exception e) {
		System.out.println(e);
	}
}

public void updateStudentDetails() {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter student roll");
	int stu = sc.nextInt();
	System.out.println("select what you want to update");
	System.out.println("1. First name");
	System.out.println("2. Second name");
	System.out.println("3. Father name");
	System.out.println("4. Gender");
	System.out.println("5. Address");
	System.out.println("6. Roll Number");
	System.out.println("7. Class");
	System.out.println("8. Age");
	System.out.println("9. Phone Number");
	int var = sc.nextInt();
	System.out.println("enter detail to be updated");
	String det = sc.next();
	try {
		switch(var) {
		case 1: String str1 = "UPDATE STUDENT SET Fname =? WHERE Rno = ?";
		        PreparedStatement ps1 = conn.prepareStatement(str1);
		        ps1.setString(1,det);
		        ps1.setInt(2, stu);
		        int updated1 = ps1.executeUpdate();
		        System.out.println("updated sucessfully");
		        break;
		case 2: String str2 = "UPDATE STUDENT SET Lname =? WHERE Rno = ?";
                PreparedStatement ps2 = conn.prepareStatement(str2);
                ps2.setString(1,det);
                ps2.setInt(2, stu);
                int updated2 = ps2.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		case 3: String str3 = "UPDATE STUDENT SET FatherName =? WHERE Rno = ?";
                PreparedStatement ps3 = conn.prepareStatement(str3);
                ps3.setString(1,det);
                ps3.setInt(2, stu);
                int updated3 = ps3.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		case 4: String str4 = "UPDATE STUDENT SET gender =? WHERE Rno = ?";
                PreparedStatement ps4 = conn.prepareStatement(str4);
                ps4.setString(1,det);
                ps4.setInt(2, stu);
                int updated4 = ps4.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		case 5: String str5 = "UPDATE STUDENT SET adress =? WHERE Rno = ?";
                PreparedStatement ps5 = conn.prepareStatement(str5);
                ps5.setString(1,det);
                ps5.setInt(2, stu);
                int updated5 = ps5.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		case 6: String str6 = "UPDATE STUDENT SET Rno =? WHERE Rno = ?";
                PreparedStatement ps6 = conn.prepareStatement(str6);
                ps6.setString(1,det);
                ps6.setInt(2, stu);
                int updated6 = ps6.executeUpdate();
                System.out.println("updated sucessfully");
                break;
	 	case 7: String str7 = "UPDATE STUDENT SET Class =? WHERE Rno = ?";
                PreparedStatement ps7 = conn.prepareStatement(str7);
                ps7.setString(1,det);
                ps7.setInt(2, stu);
                int updated7 = ps7.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		case 8: String str8 = "UPDATE STUDENT SET age =? WHERE Rno = ?";
                PreparedStatement ps8 = conn.prepareStatement(str8);
                ps8.setString(1,det);
                ps8.setInt(2, stu);
                int updated8 = ps8.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		case 9: String str9 = "UPDATE STUDENT SET phoneNumber =? WHERE Rno = ?";
                PreparedStatement ps9 = conn.prepareStatement(str9);
                ps9.setString(1,det);
                ps9.setInt(2, stu);
                int updated9 = ps9.executeUpdate();
                System.out.println("updated sucessfully");
                break;
		       }
	}catch(Exception e) {
		System.out.println("error updating the details");
	}
	
}
public void deleteStudentDetails() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Roll number of the student to delete: ");
	int Rnoo = sc.nextInt();
	String str = "DELETE FROM STUDENT WHERE Rno=?";
	try {
		PreparedStatement stm = conn.prepareStatement(str);
		stm.setInt(1,Rnoo);
		int rowsDeleted = stm.executeUpdate();
		System.out.println(rowsDeleted + " row(s) deleted.");
		System.out.println("student details of "+Rnoo+" has been deleted successfully");
	}catch(Exception e) {
		System.out.println("delete unsuccessfull");
	}
	
		
}
public void displayAllStudentDetails() {

try {
	String str = "SELECT * FROM STUDENT";
	rs = stmt.executeQuery(str);
	while(rs.next()) {
		String Fname = rs.getString("Fname");
		String Lname = rs.getString("Lname");
		String FatherName = rs.getString("FatherName");
		String gender = rs.getString("gender");
		String address = rs.getString("address");
		String Rno = rs.getString("Rno");
		String Class = rs.getString("Class");
		String age = rs.getString("age");
		String phoneNumber = rs.getString("PhoneNumber");
		System.out.println("Name: "+Fname+" "+Lname+" Father Name: "+FatherName+" gender: "+gender+" address: "+address+" Roll number: "+Rno+" Class: "+Class+" age: "+age+" Phone number: "+phoneNumber);
		
	}
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void showStudentDetails() {

	Scanner sc = new Scanner(System.in);
	System.out.println("enter roll no of student");
	int rno = sc.nextInt();
	String str = "SELECT * FROM STUDENT WHERE Rno=?";
	try {
		PreparedStatement ps1 = conn.prepareStatement(str);
        ps1.setInt(1,rno);
        rs = ps1.executeQuery();
		while(rs.next()) {
			String Fname = rs.getString("Fname");
			String Lname = rs.getString("Lname");
			String FatherName = rs.getString("FatherName");
			String gender = rs.getString("gender");
			String address = rs.getString("address");
			String Rno = rs.getString("Rno");
			String Class = rs.getString("Class");
			String age = rs.getString("age");
			String phoneNumber = rs.getString("PhoneNumber");
			System.out.println("Name: "+Fname+" "+Lname+" Father Name: "+FatherName+" gender: "+gender+" address: "+address+" Roll number: "+Rno+" Class: "+Class+" age: "+age+" Phone number: "+phoneNumber);
			
		}
	}catch(Exception e) {
		System.out.println("error displaying details");
	}

}


}
