package application;
import java.util.*;

import javafx.application.Platform;
import javafx.stage.*;
public class Student extends User implements Runnable{
	private Map<Event,Integer>customerEvent;
	public static Stage stage;
	@Override
	public void run()
	{
		synchronized(this.getAudi().lock)
		{
			
			this.showEvents();
			this.getAudi().lock=false;
			
		}
		
	}
	Student()
	{
		super("","","","",null);
	}
	Student(String first_name,String last_name,String email,String password,Audi a)
	{
		super(first_name,last_name,email,password,a);
		customerEvent=new HashMap<Event,Integer>();
	}
	public void setStage(Stage s)
	{
		this.stage=s;
	}
	public void addEvent(Event e,int n)
	{
		Map<Event,Integer>m=new HashMap<Event,Integer>();
		customerEvent.put(e, n);
	}
	public Student(Student s)
	{
		super(s.getFirstName(),s.getLastName(),s.getEmail(),s.getPassword(),s.getAudi());
	}
	
	public Map<Event,Integer> getBookedEvents()
	{
		return customerEvent;
	}
	public String toString()
	{
		return this.getFirstName();
	}
	public boolean equals(Student s)
	{
		if(s.getFirstName().equals(this.getFirstName()) && s.getLastName().equals(this.getLastName()) && s.getEmail().equals(this.getEmail()) && s.getPassword().equals(this.getPassword()))
			return true;
		return false;
	}
	public int getNumberofbookedSeats(Event e)
	{
		return customerEvent.get(e);
	}
	public void setNumberofSeatsbooked(Event e,int n)
	{
		customerEvent.put(e, n);
	}
	public void cancelBookedSeats(Event e,int n)
	{
		customerEvent.put(e, customerEvent.get(e)-n);
	}
	public void removeEvent(Event e)
	{
		customerEvent.remove(e);
	}
	
	public void showProfile()
	{
		try {
		System.out.println("Welcome "+this.getFirstName());
		if(this.getBookedEvents().keySet().size()==0)
		{
			System.out.println("You have not booked any Event yet :( !!");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter 'Back' to see all the list of Events");
			String cond=sc.nextLine();
			if(cond.equalsIgnoreCase("back"))
			{
				this.showEvents();
				return;
			}
			else
			{
				System.out.println("Please Enter Desired Input\n");
				this.showProfile();
				return;
			}
			
		}
		else
		{
			System.out.println("\n \nThese are the following event you have booked\n");
		for(Event selectedevent:this.getBookedEvents().keySet())
		{
			
			System.out.println(selectedevent.getId()-18+" "+selectedevent.getEventName()+" : "+selectedevent.getDesc()+"\nTime:"+selectedevent.getStartTime()+" - "+selectedevent.getEndTime());
			System.out.println();
		}
		System.out.println("Enter the Event Id to know the booked seats or to go back enter 'back'");
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		if(input.equalsIgnoreCase("back"))
			{this.showEvents();
		return;}
		else if(Integer.parseInt(input)>this.getAudi().getArr().values().size() && Integer.parseInt(input)<=0)
		{
			System.out.println("Enter the desired input \n");
			this.showProfile();
			return;
		}
		int index=Integer.parseInt(input);
		Event selectedevent=this.getAudi().getArr().get(index);
		int k=1;
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(i%2==0)
				{
					
					System.out.print(k+" ");
					if(k<10)
						System.out.print(" ");	
					k++;
				}
				else
				{
					if(!selectedevent.getAvailability(i/2, j) && selectedevent.getStudentForBookedSeat(i/2, j).equals(this))
					{
						System.out.print(" * ");
					}
					else
					{
						System.out.print("_  ");
					}
				}
				
			}
			System.out.println();
		}
		System.out.println("Want to cancel the tickets ? Enter Cancel or Enter Profile to go to the profile");
		String cond=sc.nextLine();
		
		if(cond.equalsIgnoreCase("cancel"))
		{
			this.cancelTickets(selectedevent);
			return;
		}
		else if(cond.equalsIgnoreCase("profile"))
		{
			this.showProfile();
			return;
		}
		else
		{
			System.out.println("Enter the desired input \n");
			this.showProfile();
			return;
		}
		}
		}
		catch(Exception o)
		{
			System.out.println("Enter desired input only");
			this.showProfile();
			return;
		}
		
	}
	
	public void showEvents()
	{
			Platform.runLater(()->ShowStudentEventDetails.display(this.getAudi(),this));
			return;
	}
	
	public void cancelTickets(Event e)
	{
		try {
		System.out.println("Enter Number of Seats you want to cancel");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter Seat Number you want to cancel");
		if(n>this.getNumberofbookedSeats(e))
		{
			System.out.println("Invalid Number of seats\n");
			
			this.cancelTickets( e);
			return;
		}
		
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			arr[i]--;
		}
		int x[]=new int [n];
		int y[]=new int [n];
		for(int i=0;i<n;i++)
		{
			x[i]=arr[i]/10;
			y[i]=arr[i]%10;
		}
		if(e.cancelTicks(x,y,n,this)==0)
		{
			System.out.println("Please choose the seats that you have booked !!\n");
			this.cancelTickets(e);
			return;
		}
		System.out.println("Successfully cancelled the booking\n");
		this.showProfile();}
		catch(Exception p)
		{
			System.out.println(p.getMessage());
		}
	}
	

	public void signup(Audi a)
	{
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your First Name");
		String fname=sc.nextLine();
		System.out.println("Enter Last Name");
		String lname=sc.nextLine();
		System.out.println("Enter your Email ID");
		String email=sc.nextLine();
		System.out.println("Enter Password");
		String pass=sc.nextLine();
		Student s=new Student(fname,lname,email,pass,a);
		a.getAllcustomers().add(s);
		System.out.println("New User Created");
		s.showEvents();
		return;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			this.signup(a);
			return;
		}
		
	}
}
