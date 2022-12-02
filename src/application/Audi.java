package application;
import java.util.*;

public class Audi { 
	private Map<Integer,Event>arr;
	private ArrayList<Student>allcustomers;
	private ArrayList<Admin>alladmins;
	public Object lock = new Object();
	public boolean safeToBrowse;
	Audi()
	{
		arr=new HashMap<Integer,Event>();
		allcustomers=new ArrayList<Student>();
		alladmins=new ArrayList<Admin>();
		arr.put(1,new Event("Oasis Inaugration","8:00am","9:00pm","Beginning of the Annual Fest",1,120));
		arr.put(2,new Event("Rocktaves","9:15am","10:30am","Inter College Music Competition",2,150));
		arr.put(3,new Event("Drum Duels","11:30am","12:30pm","Drumming Competition",3,180));
		arr.put(4,new Event("Sukhmanch","12:45pm","1:30pm","Theatrical Performance",4,150));
		arr.put(5,new Event("Street Dance","2:00pm","3:30pm","Dance Competition open for all",5,190));
		arr.put(6,new Event("Nukkad Natak","3:45pm","4:30pm","A street Play by different Colleges",6,100));
		arr.put(7,new Event("Razzmatazz","5:00pm","6:30pm","Inter College Dance Competition",7,200));
		arr.put(8,new Event("Magic Show","7:00pm","8:00pm","Magicians all over India showcasing their magic",8,190));
		
		allcustomers.add(new Student("testuser1","testuser1","testuser1@gmail.com","testuserpass1",this));
		allcustomers.add(new Student("testuser2","testuser2","testuser2@gmail.com","testuserpass2",this));
		alladmins.add(new Admin("adminuser","adminuser","admin@gmail.com","adminpass",this));
		this.safeToBrowse = true;
		
	}
	public Map<Integer, Event> getArr() {
		return arr;
	}
	public void setArr(Map<Integer, Event> arr) {
		this.arr = arr;
	}
	public ArrayList<Student> getAllcustomers() {
		return allcustomers;
	}
	public void setAllcustomers(ArrayList<Student> allcustomers) {
		this.allcustomers = allcustomers;
	}
	public ArrayList<Admin> getAlladmins() {
		return alladmins;
	}
	public void setAlladmins(ArrayList<Admin> alladmins) {
		this.alladmins = alladmins;
	}
	public void addStudent(Student s)
	{
		this.allcustomers.add(s);
	}
	public Student getStudent(String email,String pass)
	{
		for(Student s:allcustomers)
		{
			if(s.getEmail().equals(email) && s.getPassword().equals(pass))
			{
				return s;
			}
		}
		return null;
	}
	public Admin getAdmin(String email,String pass)
	{
		for(Admin a:alladmins)
		{
			if(a.getEmail().equals(email) && a.getPassword().equals(pass))
				return a;
		}
		return null;
	}
}
