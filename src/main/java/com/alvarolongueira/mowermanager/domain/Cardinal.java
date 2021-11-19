package com.alvarolongueira.mowermanager.domain;

public enum Cardinal {
	N("N", 0, 1), 
	S("S", 0, -1), 
	E("E", 1, 0), 
	W("W", -1, 0);
	;

	private final String code;
	private final Movement movement;

	private Cardinal(String code, int x, int y) {
		this.code = code;
		this.movement = new Movement(x, y);
	}

	public String getCode() {
		return code;
	}

	public Movement getMovement() {
		return movement;
	}

}
