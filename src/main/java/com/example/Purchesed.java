package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Purchesed {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 private String user;
 private String pname;
 private double cost;
}
