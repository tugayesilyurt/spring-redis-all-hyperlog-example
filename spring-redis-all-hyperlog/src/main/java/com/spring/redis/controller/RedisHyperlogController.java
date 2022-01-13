package com.spring.redis.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.dto.Hyperlog;
import com.spring.redis.service.ProgrammerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/redis/hyperlog")
@RequiredArgsConstructor
public class RedisHyperlogController {

	private final ProgrammerService programmerService;

	@PostMapping("/add")
	public ResponseEntity<?> addHyperlogForMonitoring(@RequestBody Hyperlog hyperlog){

		String keyLasthHour = "HYPERLOG-" + LocalDate.now().toString();
		
		programmerService.setHyperlog(keyLasthHour, hyperlog.getDeviceName());
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<?> getCountLastDay(){

		String keyLasthHour = "HYPERLOG-" + LocalDate.now().toString();
		
		long count = programmerService.getHyperlog(keyLasthHour);
		return new ResponseEntity<Long>(count, HttpStatus.OK);
	}


}
