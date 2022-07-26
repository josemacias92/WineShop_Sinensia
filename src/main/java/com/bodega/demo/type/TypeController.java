package com.bodega.demo.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypeController {

	@Autowired
	TypeService typeService;
	@GetMapping
	
	public List<Type> showAll(){
		return typeService.getAll();
	}
}