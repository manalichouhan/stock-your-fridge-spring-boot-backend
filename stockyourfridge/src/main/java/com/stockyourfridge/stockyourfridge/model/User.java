package com.stockyourfridge.stockyourfridge.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	private String userName;
	private String password;
	private String email;
	private boolean isEnabled;
	
	@ManyToMany(mappedBy = "users")
	Set<Fridge> fridges;
}
