package com.srk.demo.unit.srk_unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json Parsing
 *
 */
public class App {
	public static void main(String[] args) {

		ObjectMapper objectMapper = new ObjectMapper();
		Device device = new Device(100);
		try {
			System.out.println(objectMapper.writeValueAsString(device));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
