package com.stockyourfridge.stockyourfridge.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Fridge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fridgeId;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User owner;
	private boolean isFull;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="fridgeId"), 
		inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<User> users;
	
	@OneToMany(mappedBy = "fridge")
	private List<Aisle> aisles;
}
