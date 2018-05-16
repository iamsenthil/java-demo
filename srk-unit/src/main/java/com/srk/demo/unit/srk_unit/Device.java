package com.srk.demo.unit.srk_unit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

	private int id = -1;

	@JsonCreator
	public Device(@JsonProperty("id")int deviceID) {
		this.id = deviceID;
	}

	public int getID() {
		return id;
	}


}
