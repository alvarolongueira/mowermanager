package com.alvarolongueira.mowermanager.domain;

import com.alvarolongueira.mowermanager.control.Action;

import lombok.Data;

@Data
public class Mower {

	private final Position position;
	private final Cardinal cardinal;

	public void move(Action forward) {
		// TODO Auto-generated method stub
	}

}
