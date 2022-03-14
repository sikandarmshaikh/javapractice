package com.interviews.experience;

/*
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;
import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.ResponseBody;
*/
/**
 * 
 * You are given a Spring MVC application and your task is to build new RESTful
 * web service. You should implement two variants of reading the /healthcheck
 * resource using JSON as the response data format: Method to read simple
 * healthcheck 
 * 
 * A request to GET /healthcheck?format=short should return a simple
 * message: { "status": "OK" } 
 * 
 * Method to read detailed healthcheck 
 * A request to GET /healthcheck?format=full should return the application status and current
 * time (formatted as an ISO 8601 string) { "currentTime":
 * "2018-06-06T21:59:36Z", "status": "OK" } 
 * 
 * Other requirements and hints 
 * 1. Performance is not assessed; focus on correctness and code quality. 
 * 2. Your service is expected to handle only GET method. Other methods should return 405 status.
 * 3. If parameters' values do not match the specified possible
 * values or if no parameter is present, you should return HTTP status code 400
 * ("Bad Request"). 
 * 4. Responses should have Content-Type header with
 * appropriate value (application/json). 
 * 5. If you need to create multiple
 * classes, you can use nested classes or define multiple classes in one source
 * file. 
 * 6. You can use only the following libraries (and their dependencies) 
 * • Spring Web MVC (v. 5.0.7.RELEASE) 
 * You can use only the following libraries (and their dependencies)
 * • Spring Web MVC (v. 5.0.7.RELEASE) 
 * • FasterXML Jackson, Jackson Datatype JSR310 (v. 2.9.6)
 * 
 * Useful link:
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html#METHOD_NOT_ALLOWED
 * Score was 54% Passed 5 out of 9
 */
public class HealthCheckControllerCodility {
	
	/*  
	@GetMapping(value = "/healthcheck?format=short")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void healthcheck() {
        return;
    }

    @GetMapping(value = "/healthcheck?format=full")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public String detailed_healthcheck() {
        long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		Date resultdate = new Date(yourmilliseconds);
        return "currentTime:" + sdf.format(resultdate);
    }

    @PutMapping(value = "/healthcheck")
     @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, 
     reason = "METHOD_NOT_ALLOWED")
    public void healthcheckPut() {
        return;
    }

    @PostMapping(value = "/healthcheck")
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, 
     reason = "METHOD_NOT_ALLOWED")
    public void healthcheckPost() {
        return;
    }


    @DeleteMapping(value = "/healthcheck")
     @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, 
     reason = "METHOD_NOT_ALLOWED")
    public void healthcheckDelete() {
        return;
    }


	*/
}
