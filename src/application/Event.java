package application;
import java.util.*;

public class Event extends Thread{
	private String name;
	private String start_time;
	private String end_time;
	private String description;
	private int cost;
	private Seat total_seats[][]=new Seat[10][10];
	
	private int event_id;
	private int total_money=0;
	
	Event(String name,String start_time,String end_time,String desc,int event_id,int cost)
	{
		this.name=name;
		this.start_time=start_time;
		this.end_time=end_time;
		this.event_id=event_id;
		this.description=desc;
		this.cost=cost;
		for(int i=0;i<10;i++)
		{
			total_seats[i]=new Seat[10];
			for(int j=0;j<10;j++)
			{
				total_seats[i][j]=new Seat();
			}
		}
		
	}
	

	public String getEventName()
	{
		return this.name;
	}
	public int bookticks(int x[],int y[],int n,Student s)
	{
		for(int i=0;i<n;i++)
		{
				if(total_seats[x[i]][y[i]].getOccupied())
				{
					System.out.println("Choose other seats from start, these seats are booked");
					return 0;
				}
		}
		for(int i=0;i<n;i++)
		{
			total_seats[x[i]][y[i]].setOwner(s);
		}
		s.addEvent(this,n);
		total_money+=n*this.cost;
		return 1;
	}
	public String getStartTime()
	{
		return this.start_time;
	}
	public String getEndTime()
	{
		return this.end_time;
	}
	public String getDesc()
	{
		return this.description;
	}
	public int getEventId()
	{
		return this.event_id;
	}
	public int getCost()
	{
		return this.cost;
	}
	public boolean getAvailability(int i,int j)
	{
		return !total_seats[i][j].getOccupied();
	}
	public Student getStudentForBookedSeat(int i,int j)
	{
		return total_seats[i][j].getOwner();
	}
	public int cancelTicks(int x[],int y[],int n,Student s)
	{
		for(int i=0;i<n;i++)
		{
			if(total_seats[x[i]][y[i]].getOccupied() && total_seats[x[i]][y[i]].getOwner().equals(s))
			{
				
			}
			else
			{
				return 0;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(total_seats[x[i]][y[i]].getOccupied() && total_seats[x[i]][y[i]].getOwner().equals(s))
			{
				total_seats[x[i]][y[i]].setOwner(new Student());
				total_seats[x[i]][y[i]].setOccupied(false);
			}
		}
		if(n==s.getNumberofbookedSeats(this))
		{
			s.removeEvent(this);
		}
		else
		{
			s.cancelBookedSeats(this, n);
		}
		
		return 1;
	}
	public void setEventName(String name)
	{
		this.name=name;
	}
	public void setStartTime(String start)
	{
		this.start_time=start;
	}
	public void setEndTime(String end)
	{
		this.end_time=end;
	}
	public void setDesc(String desc)
	{
		this.description=desc;
	}
	public void setCost(int c)
	{
		this.cost=c;
	}
	public int getTotalSales()
	{
		int num=0;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(total_seats[i][j].getOccupied())
				{
					num++;
				}
			}
		}
		return num*cost;
	}
	
}
