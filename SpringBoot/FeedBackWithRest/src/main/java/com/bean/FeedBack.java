package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="feedback")
public class FeedBack {
@Id
private String name;
private String emailid;
private String description;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "FeedBack [name=" + name + ", emailid=" + emailid + ", description=" + description + "]";
}

}
