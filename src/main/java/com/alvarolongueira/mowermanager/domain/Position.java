package com.alvarolongueira.mowermanager.domain;

import com.alvarolongueira.mowermanager.control.Movement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class Position {

	private int currentX;
	private int currentY;
	private int max_X;
	private int max_Y;

	private Position(int currentX, int currentY, int max_X, int max_Y) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.max_X = max_X;
		this.max_Y = max_Y;
	}

	private Position(int currentX, int currentY) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.max_X = currentX;
		this.max_Y = currentY;
	}
	
	static class Builder {

		Position build() {
			if (this.currentX < 0 || this.currentX > max_X) {
				throw new IllegalArgumentException("X out of range [0 to " + max_X + "]: " + currentX);
			}
			if (this.currentY < 0 || this.currentY > max_Y) {
				throw new IllegalArgumentException("X out of range [0 to " + max_Y + "]: " + currentY);
			}
			return new Position(currentX, currentY, max_X, max_Y);
		}
	}

	public static Position of(int currentX, int currentY, int max_X, int max_Y) {
		return Position.builder().currentX(currentX).currentY(currentY).max_X(max_X).max_Y(max_Y).build();
	}

	public void apply(Movement movement) {
		this.currentX += movement.getX();
		this.currentY += movement.getY();

		this.currentX = this.keepMinMax(this.currentX, this.max_X);
		this.currentY = this.keepMinMax(this.currentY, this.max_Y);
	}

	private int keepMinMax(int current, int max) {
		if (current < 0) {
			return 0;
		}
		if (current > max) {
			return max;
		}
		return current;
	}
}
