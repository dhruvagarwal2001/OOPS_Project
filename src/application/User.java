package application;

import java.util.*;

public class User {
private String first_name;
private String last_name;
private String email;
private String password;
private Audi a;

User(String first_name,String last_name,String email,String password,Audi a)
{
	this.first_name=first_name;
	this.last_name=last_name;
	this.email=email;
	this.password=password;
	this.a=a;
}
public Audi getAudi()
{
	return this.a;
}

public String getFirstName()
{
	return this.first_name;
}
public String getLastName()
{
	return this.last_name;
}
public String getEmail()
{
	return this.email;
}
public String getPassword()
{
	return this.password;
}
}
