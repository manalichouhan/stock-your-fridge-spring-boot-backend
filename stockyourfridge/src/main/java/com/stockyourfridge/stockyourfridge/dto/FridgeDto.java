package com.stockyourfridge.stockyourfridge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FridgeDto {
	private Long fridgeId;
	private String name;
	private String owner;
	private boolean isFull;
}
