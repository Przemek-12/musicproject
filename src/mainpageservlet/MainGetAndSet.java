package mainpageservlet;

public class MainGetAndSet {
	
	private int idalbums=-1;
	private String artist="";
	private String title="";
	private String year="";
	
	public MainGetAndSet() {
		super();
	}
	
	public MainGetAndSet(String artist, String title,String year) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
		
	}
	
	public MainGetAndSet(int idalbums, String artist, String title,String year) { //lista pobiera wartosci z bazy danych i wsadza je do setow zeby w jsp pobrac get
		super();
		this.idalbums = idalbums;
		this.artist = artist;
		this.title = title;
		this.year = year;
		
	}

	
	public int getIdalbums() {
		return idalbums;
	}
	
	public void setIdalbums(int idalbums) {
		this.idalbums= idalbums;
	}

	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	
	
	
	

}
