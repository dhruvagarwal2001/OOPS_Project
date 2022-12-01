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
		arr.put(1,new Event("Razzmatazz","12:00pm","2:00pm","Dance Competition between colleges",1,100));
		arr.put(2,new Event("Rocktaves","2:30pm","4:30pm","Music Competition between different bands",2,150));
		allcustomers.add(new Student("Dhruv","Agarwal","email","pass",this));
		allcustomers.add(new Student("Dhruv","Agarwal","email1","pass1",this));
		alladmins.add(new Admin("augsd","agarwal","em","pa",this));
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
