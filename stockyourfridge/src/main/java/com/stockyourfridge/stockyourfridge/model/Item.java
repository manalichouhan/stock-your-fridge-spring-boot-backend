package com.stockyourfridge.stockyourfridge.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	private String name;
	private long quantity;
	private Date expirationDate;
	private String imageLink;
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "aisleId", nullable = false)
	private Aisle aisle;
	
}
