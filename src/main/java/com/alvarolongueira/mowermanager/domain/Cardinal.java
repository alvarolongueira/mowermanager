package com.alvarolongueira.mowermanager.domain;

public enum Cardinal {
	N("N", 0, 1), 
	S("S", 0, -1), 
	E("E", 1, 0), 
	W("W", -1, 0);
	;

	private final String name;
	private final Movement movement;

	private Cardinal(String name, int x, int y) {
		this.name = name;
		this.movement = new Movement(x, y);
	}

	public String getName() {
		return name;
	}

	public Movement getMovement() {
		return movement;
	}

}
