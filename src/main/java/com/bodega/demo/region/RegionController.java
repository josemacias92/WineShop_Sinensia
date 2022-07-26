package com.bodega.demo.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

	@Autowired
	RegionService regionService;

	@GetMapping

	public ResponseEntity<List<Region>> showAll() {

		List<Region> list = regionService.getAll();

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Region> showOne(@PathVariable int id) {

		Region item = regionService.getOne(id);

		return item == null 
				? ResponseEntity.notFound().build() 
				: ResponseEntity.ok().body(item);
	}

	@PostMapping
	public ResponseEntity<Region> save(@RequestBody Region item) {
		return ResponseEntity.ok().body(regionService.save(item));
	}

	@PutMapping
	public ResponseEntity<Region> edit(@RequestBody Region item) {
		return ResponseEntity.ok().body(regionService.save(item));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable int id) {
		regionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
