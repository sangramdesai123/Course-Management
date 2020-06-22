# Spring Boot Starter Email

This is a project contains examples for sending e-mails with Spring Boot and Java Mail Sender.

## Running the project

1. Open terminal, navigate to your project
2. Type command **mvn clean install**
3. Type command **mvn spring-boot:run**

## Packaging application

1. Navigate to project directory 
2. Type command: ```mvn clean package -DskipTests``` 
3. You can find your <app>.jar file in ```target``` folder.

## Disabling authentication
If you want to disable authentication (or your server does not require authentication), in ```EmailConfiguration.java``` set **smtp.auth** property to **false**.
<br>

**NOTE:** If you are using G-mail as your mail provided for sending e-mails make sure you
allow less secure apps in G-mail support.

## Author

Heril Muratović  
Software Engineer  
<br>
**Mobile**: +38269657962  
**E-mail**: hedzaprog@gmail.com  
**Skype**: hedza06  
**Twitter**: hedzakirk  
**LinkedIn**: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
**StackOverflow**: https://stackoverflow.com/users/4078505/heril-muratovic
