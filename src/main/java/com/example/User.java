package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
@Id
private String user;
private String password;
private String email;	
}



