package com.alvarolongueira.mowermanager.domain;

import com.alvarolongueira.mowermanager.control.Movement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class PositionWithLimits {

	private int currentX;
	private int currentY;
	private int maxX;
	private int maxY;

	private PositionWithLimits(int currentX, int currentY, int maxX, int maxY) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	static class Builder {

		PositionWithLimits build() {
			if (this.currentX < 0 || this.currentX > maxX) {
				throw new IllegalArgumentException("X out of range [0 to " + maxX + "]: " + currentX);
			}
			if (this.currentY < 0 || this.currentY > maxY) {
				throw new IllegalArgumentException("X out of range [0 to " + maxY + "]: " + currentY);
			}
			return new PositionWithLimits(currentX, currentY, maxX, maxY);
		}
	}

	public static PositionWithLimits of(int currentX, int currentY, int maxX, int maxY) {
		return PositionWithLimits.builder().currentX(currentX).currentY(currentY).maxX(maxX).maxY(maxY).build();
	}

	public void apply(Movement movement) {
		this.currentX += movement.getX();
		this.currentY += movement.getY();

		this.currentX = this.keepMinMax(this.currentX, this.maxX);
		this.currentY = this.keepMinMax(this.currentY, this.maxY);
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
