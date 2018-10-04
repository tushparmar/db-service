package com.tusharparmar.stock.dbservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck
{
	@GetMapping("/")
	public void healthCheck()
	{ }
}
