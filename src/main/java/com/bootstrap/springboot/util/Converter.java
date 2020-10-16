<<<<<<< HEAD
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
=======
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
	
		public Object stringToObject(String mensagemKafka, Object classe) {
		Class<?> clazz = classe.getClass();
		
		Field[] fields = clazz.getFields();
		List<String> users = Stream.of(mensagemKafka.split(",", -1))
				  .collect(Collectors.toList());
		try {
		for (int i = 0; i < fields.length; i++) {
			Field fieldID = clazz.getField(fields[i].getName());
			
			if (fieldID.getType().getSimpleName().equalsIgnoreCase("Integer"))
				fieldID.set(classe, new Integer(users.get(i)));
			if (fieldID.getType().getSimpleName().equalsIgnoreCase("int"))
				fieldID.set(classe, Integer.parseInt(users.get(i)));
			if (fieldID.getType().getSimpleName().equalsIgnoreCase("String"))
				fieldID.set(classe, users.get(i));

		}
		}catch (NumberFormatException e) {
			logger.error("Formato de parametros da mensagem do kafka incorretos, favor checar topico. "  + mensagemKafka);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return classe;
}
	
	public String objectToString(String mensagemKafka, Object classe) {
		String deserialize = "";
		Class<?> clazz = classe.getClass();
		
		Field[] fields = clazz.getFields();
		List<String> users = Stream.of(mensagemKafka.split(",", -1))
				  .collect(Collectors.toList());
		try {
		for (int i = 0; i < fields.length; i++) {
			Field fieldID = clazz.getField(fields[i].getName());
			
			deserialize += fieldID.get(classe) + ",";
		}
		}catch (NumberFormatException e) {
			logger.error("Formato de parametros da mensagem do kafka incorretos, favor checar topico. "  + mensagemKafka);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return deserialize.substring(0, deserialize.length()-1);
	}
}
>>>>>>> 11f07b4c55acbfc64922457f8c5add16a142542f
