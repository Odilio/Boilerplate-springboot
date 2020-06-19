package com.bootstrap.springboot.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * The persistent class for the users database table.
 * 
 */
@Data
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String email;

	private String name;

	private Timestamp createdAt;

}