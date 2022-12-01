package application;

import java.util.Scanner;

import javafx.application.Platform;

public class Admin extends User implements Runnable{
	@Override
	public void run()
	{

		this.showAdminEvents();
		this.getAudi().lock=false;
	}
	Admin(String first_name,String last_name,String email,String password,Audi a)
	{
		super(first_name,last_name,email,password,a);
	}
	
	public void addEvent(Audi audi)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Event Name");
		String neweventname=sc.nextLine();
		System.out.println("Enter Event Description");
		String neweventdesc=sc.nextLine();
		System.out.println("Enter Event Start Time in HH:MMpm/am format");
		String neweventstart=sc.nextLine();
		System.out.println("Enter Event End Time in HH:MMpm/am format");
		String neweventend=sc.nextLine();
		System.out.println("Enter Event per ticket cost");
		int neweventcost=sc.nextInt();
		audi.getArr().put(audi.getArr().size()+1, new Event(neweventname,neweventstart,neweventend,neweventdesc,audi.getArr().size()+1,neweventcost));
		System.out.println("Successfully new Event Created");
		this.showAdminEvents();
		return;
	}
	public void changeEvenDetails(Event selectedevent)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Which detail you want to change?");
		System.out.println();
		System.out.println("1 Event Name\n");
		System.out.println("2 Event Start Time  in HH:MMpm/am format\n");
		System.out.println("3 Event End Time in HH:MMpm/am format\n");
		System.out.println("4 Event Cost\n");
		System.out.println("5 Event Description\n");
		System.out.println("Enter the detail number");
		int cond=sc.nextInt();
		switch(cond)
		{
		case 1:{
			System.out.println("Enter the new Event Name");
			sc.nextLine();
			String newname=sc.nextLine();
			selectedevent.setEventName(newname);
			System.out.println("Event Name Changed");
			this.showAdminEvents();
			break;
		}
		case 2:{
			System.out.println("Enter the new Event Start Time");
			sc.nextLine();
			String newstart=sc.nextLine();
			selectedevent.setStartTime(newstart);
			System.out.println("Event Start Time Changed");
			this.showAdminEvents();
			break;
		}
		case 3:{
			System.out.println("Enter the new Event End Time");
			sc.nextLine();
			String newend=sc.nextLine();
			selectedevent.setEndTime(newend);
			System.out.println("Event End time Changed");
			this.showAdminEvents();
			break;
		}
		case 4:{
			System.out.println("Enter the new Cost for the Event");
			sc.nextLine();
			int newcost=sc.nextInt();
			selectedevent.setCost(newcost);
			System.out.println("Event Cost Changed");
			this.showAdminEvents();
			break;
		}
		case 5:{
			System.out.println("Enter the new Event Description");
			sc.nextLine();
			String newdesc=sc.nextLine();
			selectedevent.setEventName(newdesc);
			System.out.println("Event Description Changed");
			this.showAdminEvents();
			break;
		}
		default:{
			System.out.println("Enter the desired choice \n");
			this.showAdminEvents();
			return;
		}
		}
	}
	
	public void showAdminEvents()
	{
		Platform.runLater(()->ShowAdminEvents.display(this.getAudi(),this));
		return;
//		System.out.println("\nHello "+this.getFirstName());
//		System.out.println();
//		for(Event x:this.getAudi().getArr().values())
//		{
//			System.out.println(x.getEventId()+". "+x.getEventName()+" - "+x.getDesc()+"\nTime : "+x.getStartTime()+" - "+x.getEndTime()+"\n");
//		}
//		System.out.println("Enter the 'Event ID' for which you want to change the details \nEnter 'Add' if you want to add event\nEnter 'Logout' to go to the login page\nEnter 'Sales' to check the sales for every Event");
//		
//		Scanner sc=new Scanner(System.in);
//		
//		String knowmoreabout=sc.nextLine();
//		if(knowmoreabout.equalsIgnoreCase("Add"))
//		{
//			this.addEvent(this.getAudi());
//			return;
//		}
//		else if(knowmoreabout.equalsIgnoreCase("Logout"))
//		{
//			System.out.println("Successfully Logged Out\n");
//			return;
//		}
//		else if(knowmoreabout.equalsIgnoreCase("sales"))
//		{
//			this.showTotalSales();
//		}
//		else if(Integer.parseInt(knowmoreabout)>this.getAudi().getArr().values().size() || Integer.parseInt(knowmoreabout)<=0)
//		{
//			System.out.println("Enter the desired input \n");
//			this.showAdminEvents();
//			return;
//		}
//		
//		Event selectedevent=this.getAudi().getArr().get(Integer.parseInt(knowmoreabout));
//		this.changeEvenDetails(selectedevent);
//		return;
	}
	
	public void showTotalSales()
	{
		int sum=0;
		for(Event e:this.getAudi().getArr().values())
		{
			System.out.println(e.getEventName()+" - "+e.getTotalSales());
			sum+=e.getTotalSales();
		}
		System.out.println("\nTotal Sales from all Event = "+sum);
		this.showAdminEvents();
		
	}
}
