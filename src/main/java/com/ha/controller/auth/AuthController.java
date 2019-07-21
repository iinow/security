package com.ha.controller.auth;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/test/{id}/{dd}")
	ResponseEntity<?> getString(
			@PathVariable(name = "id") String id,
			@PathVariable(name = "dd") String dd,
			HttpServletRequest request, UriComponentsBuilder builder) {
		URI uri = builder.path(request.getRequestURI()).buildAndExpand(id, dd).toUri();
		return ResponseEntity.created(uri).build();
	}
}
