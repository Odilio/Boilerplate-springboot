package com.bootstrap.springboot;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FieldTest {
    public static void main(String[] args) throws Exception {
	Username user = new Username();
	System.out.println();
	String countries = "100,Germany,England";
	String deserialize = "";
	Class<Username> clazz = Username.class;
	
	Field[] fields = clazz.getFields();
	List<String> users = Stream.of(countries.split(",", -1))
			  .collect(Collectors.toList());
	System.out.println("campos" + fields[0].getName() + "tamanho" + fields.length);
	for (int i = 0; i < fields.length; i++) {
		Field fieldID = clazz.getField(fields[i].getName());
		System.out.println(fieldID.getType());
		System.out.println(fieldID.getType().getName());
		System.out.println(fieldID.getType().getSimpleName());

		if (fieldID.getType().getSimpleName().equalsIgnoreCase("int"))
			fieldID.set(user, Integer.parseInt(users.get(i)));
		if (fieldID.getType().getSimpleName().equalsIgnoreCase("String"))
			fieldID.set(user, users.get(i));
		System.out.println("resultado final " + user.getId());
		System.out.println("resultado final " + user.getName());
		System.out.println("resultado final " + user.getEmail());

	}
	Field fieldID = clazz.getField("id");
	fieldID.set(user, 100);
	
	
	System.out.println();
	user.display();
	
	for (int i = 0; i < fields.length; i++) {
		Field field = clazz.getField(fields[i].getName());
		System.out.println(field.get(user));
		deserialize += field.get(user) + ",";
	}
	
	System.out.println(deserialize.substring(0, deserialize.length() - 1));
    }
}
