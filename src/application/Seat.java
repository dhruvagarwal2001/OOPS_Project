package application;

import java.util.*;
public class Seat {
	private boolean occupied=false;
	private Student owner=new Student("","","","",null);
	Seat()
	{
		this.occupied=false;
	}
	public boolean getOccupied() {
		// TODO Auto-generated method stub
		return this.occupied;
	}
	public void setOccupied(boolean s)
	{
		this.occupied=s;
	}
	public void setOwner(Student s)
	{
		this.owner=new Student(s);
		this.occupied=true;
	}
	public Student getOwner()
	{
		return owner;
	}
	
}
