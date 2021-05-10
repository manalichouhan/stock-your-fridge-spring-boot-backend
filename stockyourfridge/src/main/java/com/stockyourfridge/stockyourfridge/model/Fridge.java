package com.stockyourfridge.stockyourfridge.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fridge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fridgeId;
	
	private String owner;
	private boolean isFull;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="fridgeId"), 
		inverseJoinColumns = @JoinColumn(name = "userId"))
	private Set<User> users;
	
	@OneToMany(mappedBy = "fridge")
	private Set<Aisle> aisles;
}
