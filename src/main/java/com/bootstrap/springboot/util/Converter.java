package com.bootstrap.springboot.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

/**
 * A Simple Converter to DTO from Model
 *
 * @author Odilio Noronha Filho
 */
public class Converter {

	
    private static  ModelMapper modelMapper = new ModelMapper();
	
	 public static <D> Object toModel(final Object user, Class<D> outClass) {
			return modelMapper.map(user , outClass);

		}
	    
	 public static  <D> List<?> toCollection(List<?> users, Class<D> outClass) {
			return users.stream()
					.map(user -> toModel(user, outClass)).collect(Collectors.toList());

		}
}
