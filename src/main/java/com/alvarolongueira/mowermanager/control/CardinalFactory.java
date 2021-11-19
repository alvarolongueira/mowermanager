package com.alvarolongueira.mowermanager.control;

import java.rmi.UnexpectedException;

import com.alvarolongueira.mowermanager.domain.Cardinal;

public class CardinalFactory {

	public static Cardinal right(Cardinal cardinal) throws UnexpectedException {
		return rightSearch(cardinal);
	}

	public static Cardinal left(Cardinal cardinal) throws UnexpectedException {
		return leftSearch(cardinal);
	}

	private static Cardinal leftSearch(Cardinal cardinal) throws UnexpectedException {
		for (CardinalConection current : CardinalConection.values()) {
			if (current.getRight().equals(cardinal)) {
				return current.getLeft();
			}
		}
		throw new UnexpectedException("Conection not found");
	}

	private static Cardinal rightSearch(Cardinal cardinal) throws UnexpectedException {
		for (CardinalConection current : CardinalConection.values()) {
			if (current.getLeft().equals(cardinal)) {
				return current.getRight();
			}
		}
		throw new UnexpectedException("Conection not found");
	}

	private enum CardinalConection {
		NE(Cardinal.N, Cardinal.E), 
		ES(Cardinal.E, Cardinal.S), 
		SW(Cardinal.S, Cardinal.W), 
		WN(Cardinal.W, Cardinal.N);

		private final Cardinal left;
		private final Cardinal right;

		private CardinalConection(Cardinal left, Cardinal right) {
			this.left = left;
			this.right = right;
		}

		private Cardinal getLeft() {
			return left;
		}

		private Cardinal getRight() {
			return right;
		}
	}
}
