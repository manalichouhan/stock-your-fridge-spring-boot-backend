package com.stockyourfridge.stockyourfridge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
	private long userId;
	private String userName;
	private String password;
	private String email;
	private boolean isEnabled;
}
