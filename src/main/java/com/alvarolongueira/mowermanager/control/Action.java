package com.alvarolongueira.mowermanager.control;

public enum Action {
	FORWARD("M"), 
	TURN_LEFT("L"), 
	TURN_RIGHT("R");

	private final String code;

	private Action(String code) {
		this.code = code;
	}

	public static Action get(String code) {
		for (Action current : Action.values()) {
			if (current.getCode().equals(code)) {
				return current;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

}
