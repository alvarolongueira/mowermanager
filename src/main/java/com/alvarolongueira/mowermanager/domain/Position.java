package com.alvarolongueira.mowermanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {

	private final int currentX;
	private final int currentY;
	private final int maxX;
	private final int maxY;
	
	public void apply (Movement movement) {
		
	}
}
