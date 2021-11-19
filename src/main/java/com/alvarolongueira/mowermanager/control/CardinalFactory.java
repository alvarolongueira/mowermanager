package com.alvarolongueira.mowermanager.control;

import com.alvarolongueira.mowermanager.domain.Cardinal;

public class CardinalFactory {

	private Cardinal current;

	public static CardinalFactory of(Cardinal cardinal) {
		return new CardinalFactory(cardinal);
	}

	private CardinalFactory(Cardinal cardinal) {
		this.current = cardinal;
	}

	public Cardinal turnRight() {
		// TODO
		return null;
	}

	public Cardinal turnLeft() {
		// TODO
		return null;
	}
}
