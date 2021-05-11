package com.stockyourfridge.stockyourfridge.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aisle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aisleId;
	
	@ManyToOne
	@JoinColumn(name = "fridgeId", nullable = false)
	private Fridge fridge;
	
	@OneToMany(mappedBy = "aisle")
	private List<Item> items;
}
