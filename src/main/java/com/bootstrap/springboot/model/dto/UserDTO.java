package com.bootstrap.springboot.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

/**
 * The persistent class for the users database table.
 * 
 */
@Data
public class UserDTO extends RepresentationModel <UserDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String email;

	private String name;

	private Timestamp createdAt;

}