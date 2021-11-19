package com.alvarolongueira.mowermanager.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class Position {

	private final int currentX;
	private final int currentY;
	private final int maxX;
	private final int maxY;

	private Position(int currentX, int currentY, int maxX, int maxY) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	static class Builder {

		Position build() {
			if (this.currentX < 0 || this.currentX > maxX) {
				throw new IllegalArgumentException("X está fuera de rango[0 to " + maxX + "]: " + currentX);
			}
			if (this.currentY < 0 || this.currentY > maxY) {
				throw new IllegalArgumentException("X está fuera de rango[0 to " + maxY + "]: " + currentY);
			}
			return new Position(currentX, currentY, maxX, maxY);
		}
	}

	public static Position of(int currentX, int currentY, int maxX, int maxY) {
		return Position.builder().currentX(currentX).currentY(currentY).maxX(maxX).maxY(maxY).build();
	}

	public void apply(Movement movement) {

	}
}
