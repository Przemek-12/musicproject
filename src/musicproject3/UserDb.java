package musicproject3;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.JavaWebApplication.Beans.RegisterBean;


import signinbean.SigninBean;


public class UserDb {
	String s1= null;
	
	public static int id =0;
	
	public UserDb() {
		Random ran = new Random();
		id++;
		id=id+1+ran.nextInt(10000);
	}	
	
	
	
	public String insertUser (RegisterBean rb) throws Exception  //write data register
	{
		musicproject3 db = new musicproject3();
		Connection conn  =db.getConnection();
		ResultSet set2 = null;
		String result2 = null;
		
		//String name2 =rb.getUsername();
		//String password2 = rb.getPassword();
		//String email2 = rb.getEmail();
		
		try 
		{
		Statement stat = conn.createStatement();	
		set2 = stat.executeQuery("select username, password, email from music.useraccount where username = '"+rb.getUsername()+"'and password = '"+rb.getPassword()+"' and email = '"+rb.getEmail()+"' ");
		

					if(set2.next())
					{
						result2 = "account_already_exists";
					}
					else {
						result2="valid";										
					}
		
	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(conn);
			System.out.println("Connection closed");
		}		
		
		return result2;
		
	}
	
	
	public String addUser (RegisterBean fb) throws Exception {
		String result3 = null;
		musicproject3 db = new musicproject3();
		Connection conn  =db.getConnection();

		String name3 =fb.getUsername();
		String password3 = fb.getPassword();
		String email3 = fb.getEmail();
		
		try {
			Statement stat2 = conn.createStatement();
			stat2.executeUpdate("insert into music.useraccount(iduser, username, password, email) values('"+id+"','"+name3+"','"+password3+"', '"+email3+"')");
			result3= "success";
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				closeConnection(conn);
				System.out.println("Connection closed");
			}
				
				
		
		
		
		
		return result3;
	}
	
	
	public String readData(SigninBean sign)throws Exception {
		
		musicproject3 db = new musicproject3();
		Connection conn  =db.getConnection();
		ResultSet set = null;
		String result = null;
		
		try {
			Statement stat = conn.createStatement();
			 set = stat.executeQuery("select username, password from music.useraccount where username='"+sign.getUsername()+"' and password = '"+sign.getPassword()+"' ");		
			// next przesuwa kursor, jesli row sie zgadza to przesunie raz a jak nie to wogole
			if(set.next()) {       
			result = "valid";
			}
			else {
				result="invalid";
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("error");
		}
		finally {
			closeConnection(conn);
			System.out.println("Connection closed");
		}
		
		
		return result;
		
		
	}
	
	
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
