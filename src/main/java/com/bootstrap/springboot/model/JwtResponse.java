package com.bootstrap.springboot.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {

private static final long serialVersionUID = -8091879091924046844L;
private final String jwttoken;

}