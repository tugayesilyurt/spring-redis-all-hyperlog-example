package com.spring.redis.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.redis.dto.Programmer;
import com.spring.redis.service.ProgrammerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/redis")
@RequiredArgsConstructor
public class AddRedisController {

	private final ProgrammerService programmerService;
	private final ObjectMapper objectMapper;

	@PostMapping("/add")
	public ResponseEntity<?> addRedisKeyValue(@RequestBody Programmer programmer) throws JsonProcessingException {

		programmerService.setObjectsAsString("programmer", objectMapper.writeValueAsString(programmer));
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<?> getProgrammer(@RequestParam(value = "key") String key) throws JsonProcessingException {

		String value = programmerService.getObjectAsString(key);
		Programmer response = objectMapper.readValue(value, Programmer.class);
		return new ResponseEntity<Programmer>(response, HttpStatus.OK);
	}

	@PostMapping("/add/list")
	public ResponseEntity<?> addRedisList(@RequestBody Programmer programmer) throws JsonProcessingException {

		programmerService.AddToProgrammersList(programmer);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<?> getProgrammerList() throws JsonProcessingException {

		List<Programmer> response = programmerService.getProgrammersListMembers();
		return new ResponseEntity<List<Programmer>>(response, HttpStatus.OK);
	}

	@PostMapping("/add/set")
	public ResponseEntity<?> addRedisSet(@RequestBody Programmer programmer) throws JsonProcessingException {

		programmerService.AddToProgrammersSet(programmer);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping("/set")
	public ResponseEntity<?> getProgrammerSet() throws JsonProcessingException {

		Set<Programmer> response = programmerService.getProgrammersSetMembers();
		return new ResponseEntity<Set<Programmer>>(response, HttpStatus.OK);
	}

	@PostMapping("/add/hash")
	public ResponseEntity<?> addRedisHas(@RequestBody Programmer programmer) throws JsonProcessingException {

		programmerService.saveHash(programmer);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping("/hash/{id}")
	public ResponseEntity<?> getProgrammerHash(@PathVariable(value="id") int id) throws JsonProcessingException {

		Programmer response = programmerService.findInHash(id);
		return new ResponseEntity<Programmer>(response, HttpStatus.OK);
	}

	@DeleteMapping("/hash/{id}")
	public ResponseEntity<?> deleteHash(@PathVariable(value="id") int id) throws JsonProcessingException {

		programmerService.deleteHash(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

}
