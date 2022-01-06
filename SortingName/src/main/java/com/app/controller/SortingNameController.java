package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.SortingNameService;
import com.app.util.SortedNameResponse;

@RestController
public class SortingNameController {
	@Autowired
	private SortingNameService service;
	
	private SortedNameResponse response;
	
	@GetMapping("name-sorter/{filename}")
	public ResponseEntity<SortedNameResponse> sortingName(@PathVariable String filename) {
		response = new SortedNameResponse();
		try {
			List<String> dataSorted = service.sortingName(filename);
			response = new SortedNameResponse(HttpStatus.OK.value(), "success", dataSorted);
            return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (IOException e) {
            response = SortedNameResponse.getError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
