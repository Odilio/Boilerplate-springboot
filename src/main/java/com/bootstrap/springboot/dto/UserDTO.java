package com.bootstrap.springboot.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;


/**
 * The persistent class for the users database table.
 * 
 */
@Data
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Timestamp createdAt;

	@NotNull
	private String email;

	private String name;

	private String password;


}