package com.lawencon.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lawencon.springboot.model.Mahasiswa;

/**
 * @author lawencon05
 */
@RestController
@RequestMapping("/mhs")
public class MahasiswaContoller {

	@GetMapping
	public ResponseEntity<?> getMhs(@RequestParam("id") String id, @RequestParam("name") String name) {
		Long realId = Long.valueOf(id);
		return new ResponseEntity<>("Get data : " + realId + " with " + name, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getMhsPath(@PathVariable("id") String id) {
		Long realId = Long.valueOf(id);
		return new ResponseEntity<>("Get data path: " + realId, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule()); // for localdate or localdatetime
			Mahasiswa mhs = mapper.readValue(body, Mahasiswa.class);
			return new ResponseEntity<>(mhs, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
