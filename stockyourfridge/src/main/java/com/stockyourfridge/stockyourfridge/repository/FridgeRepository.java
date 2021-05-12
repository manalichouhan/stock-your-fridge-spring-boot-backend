package com.stockyourfridge.stockyourfridge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stockyourfridge.stockyourfridge.model.Fridge;
import com.stockyourfridge.stockyourfridge.model.User;

public interface FridgeRepository extends CrudRepository<Fridge, Long> {
	public List<Fridge> findByOwner(User owner);
}
