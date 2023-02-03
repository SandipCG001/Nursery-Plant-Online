package com.cg.onlineplantnurseryapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "admin_id")
private Long adminId;

@Column(name="admin_name")
private String adminName;

@Column(name="admin_email")
private String adminEmail;

@Column(name = "admin_password")
private String adminPassword;

public Admin() {
super();
}

public Admin( String adminName,String adminEmail, String adminPassword)
{
super();
this.adminName=adminName;
this.adminEmail=adminEmail;
this.adminPassword = adminPassword;

}


public Admin(Long adminId,String adminName,String adminEmail, String adminPassword) {
super();
this.adminId = adminId;
this.adminName=adminName;
this.adminEmail=adminEmail;
this.adminPassword = adminPassword;
}



public Long getAdminId() {
return adminId;
}

public void setAdminId(Long adminId) {
this.adminId = adminId;
}
public String getAdminName() {
return adminName;
}

public void setAdminName(String adminName) {
this.adminName = adminName;
}

public String getAdminEmail() {
return adminEmail;
}

public void setAdminEmail(String adminEmail) {
this.adminEmail = adminEmail;
}

public String getAdminPassword() {
return adminPassword;
}

public void setAdminPassword(String adminPassword) {
this.adminPassword = adminPassword;
}

@Override
public String toString() {
return "Admin [adminId=" + adminId + ", adminname=" + adminName +", adminemail=" + adminEmail +", adminpassword=" + adminPassword + "]";
}
}
