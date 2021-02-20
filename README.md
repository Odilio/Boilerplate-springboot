# Boilerplate-springboot
	Para Iniciar execute a classe Starter passando como parametro 
	--jasypt.encryptor.password=pass
	Para gerar uma nova senha criptografada usar o jasypt que está dentro de resources
	comando pra gerar senha
	>encrypt.bat input=coder password=pass algorithm=PBEWITHHMACSHA512ANDAES_256 ivGeneratorClassName=org.jasypt.iv.RandomIvGenerator
	Para Iniciar usando setando o profile por parametro usar a classe StarterProfileArgument e passar --spring.profiles.active=dev como argumento
	Para acessar por swagger va para http://localhost:8080/swagger-ui.html
	Postman Collecions ficam dentro do pacote resources na raiz do projeto

# Technology stack 
	Spring Boot for application configuration
	Profiles Dev And Prod
	Maven configuration for building, testing and running the application
	Spring Security
	Spring MVC REST
	Spring HATEOAS
	Internationalization I18n
	Spring Data JPA + Bean Validation
	Embedded Database with H2 for dev profile
	Database updates with flyway
	Automated JSON API documentation for API's with SpringDoc/Swagger 2
	Authentication system using JWT
	Encrypted Password using bcrypt
	Converter to DTOs using ModelMapper
	Getters/Setters, Constructors Auto Generating with Lombok
	
#My Personal Blog
	https://medium.com/rapaduratech
	
