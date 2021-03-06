package com.srk.demo.unit.srk_unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.demo.java.http.WebClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp1() {
		final Device device = new Device(1);
		assertEquals("Device ID mismatch ", 1, device.getID());
	}

	public void testApp2() {
		final Device device = mock(Device.class);
		when(device.getID()).thenReturn(2);
		assertEquals("Device ID mismatch ", 2, device.getID());
	}

	public void testApp3() throws JsonProcessingException {
		final Device device = new Device(100);
		final ObjectMapper objectMapper = new ObjectMapper();
		assertEquals("Device JSON mismatch ", "{\"id\":100}", objectMapper.writeValueAsString(device));
	}

	public void testApp4() {
		final WebClient webClient = mock(WebClient.class);
		when(webClient.sendData("", "")).thenReturn(true);
		assertEquals("Send Web Reqest failes", true, webClient.sendData("", ""));

	}
}
