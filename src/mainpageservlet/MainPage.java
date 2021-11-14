package mainpageservlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import musicproject3.musicproject3;

public class MainPage { 

	
										public List <MainGetAndSet> dispDataBase() throws Exception {
										
										
										musicproject3 disp = new musicproject3();
										Connection conn = null;
										conn = disp.getConnection();										
										
										List <MainGetAndSet> albumdatabase = new ArrayList<MainGetAndSet>();
										 String sql = "select idalbums, artist, title, year from music.albums";
										 
										 try { 
										 PreparedStatement ps = conn.prepareStatement(sql);
										 ResultSet set4 = ps.executeQuery();
										 while(set4.next()) {
											 int idalbums = set4.getInt("idalbums");
											 String artist = set4.getString("artist");
											 String title = set4.getString("title");
											 String year = set4.getString("year");
											 MainGetAndSet insert2 = new MainGetAndSet(idalbums, artist, title, year);
											 albumdatabase.add(insert2);
											 
											 
										 }
										 }catch(SQLException e){
											 e.printStackTrace();
										 }finally {
												closeConnection(conn);
												System.out.println("connection closed");
												}
										
								
											return albumdatabase;
										}
	
										
										
										
										
																											public static int id=0;
																											
																											public MainPage() throws Exception {
																												Random ran = new Random();
																												id++;
																												 int id2=id+1+ran.nextInt(10000);
																										     	musicproject3 idc = new musicproject3();
																												Connection conn = idc.getConnection();
																												ResultSet set3 = null;
																												Statement ment=conn.createStatement();
																												set3=  ment.executeQuery("select idalbums from music.albums where idalbums='"+id2+"'");
																												if(set3.next()) {
																													id++;
																												}
																												else {
																													id=id2;
																												}
																												closeConnection(conn);
																	
																												
																											}			
	
	public void insertIntoDatabase(MainGetAndSet insert) throws Exception { //w nawiasie jest obiekt klasy przez co mozna tego obiektu uzyc do komunikowani sie z klasa
		
		musicproject3 db = new musicproject3();
		Connection conn=db.getConnection();
		String tyr = "insert into music.albums (idalbums, artist, title, year) values(?,?,?,?)";
		
		try {
		PreparedStatement statement = conn.prepareStatement(tyr);
		statement.setInt(1, id);
		statement.setString(2, insert.getArtist());
		statement.setString(3, insert.getTitle());
		statement.setString(4, insert.getYear());
		statement.execute();
		
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		closeConnection(conn);
		System.out.println("connection closed");
		}
	}
	
	
	
	public void DeleteFromDatabase(int idl) throws Exception{
		musicproject3 db = new musicproject3();
		Connection conn = db.getConnection();
		String del = "delete from music.albums where idalbums=?";
		try {
		PreparedStatement statement = conn.prepareStatement(del);
		statement.setInt(1,idl);
		statement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		closeConnection(conn);
		System.out.println("connection closed");
		}
	}
	
	public MainGetAndSet updateData(int idal)throws Exception{  //reference method, w nazwie metody jest to co bedzie zwracane returnem, czyli klasa i obiekty z nia zwiazane
		MainGetAndSet update=null;
		musicproject3 db = new musicproject3();
		Connection conn = db.getConnection();
		String sel = "select* from music.albums where idalbums=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sel);
			statement.setInt(1, idal);
			ResultSet results = statement.executeQuery();
				if(results.next()) {
					idal =results.getInt("idalbums");
					String artist = results.getString("artist");
					String title = results.getString("title");
					String year = results.getString("year");
					update = new MainGetAndSet(idal, artist, title, year);
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
			closeConnection(conn);
			System.out.println("connection closed");
			}
		
		return update;
		
	}
	
	
	public void changeData(int idin, MainGetAndSet changeinsert) throws Exception {
		musicproject3 db = new musicproject3();
		Connection conn =db.getConnection();
		String chang = "update music.albums set artist=? , title=? , year=? where idalbums=? ";
		try {
		PreparedStatement statement = conn.prepareStatement(chang);
		statement.setString(1,changeinsert.getArtist());
		statement.setString(2,changeinsert.getTitle());
		statement.setString(3,changeinsert.getYear());
		statement.setInt(4,idin);
		statement.execute();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		closeConnection(conn);
		System.out.println("connection closed");
		}
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
