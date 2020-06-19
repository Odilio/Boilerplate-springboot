package com.bootstrap.springboot.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Converter {

	@Autowired
    private ModelMapper modelMapper;
	
	 public Object toModel(Object user) {
			return modelMapper.map(user , user.getClass());

		}
	    
	 public List<?> toCollection(List<?> users) {
			return users.stream()
					.map(user -> toModel(user)).collect(Collectors.toList());

		}
}
