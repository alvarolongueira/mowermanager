package com.alvarolongueira.mowermanager.domain;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

	@Test
	public void createPosition() {
		Position position = new Position(4, 3, 8, 8);
		Assert.assertEquals(4,position.getCurrentX());
		Assert.assertEquals(3,position.getCurrentY());
		Assert.assertEquals(8,position.getMaxX());
		Assert.assertEquals(8,position.getMaxY());
	}

	@Test
	public void createInvalidPositionOverXLimit() {
		Position position = new Position(10, 6, 8, 8);
	}

	@Test
	public void createInvalidPositionOverYLimit() {
		Position position = new Position(2, 11, 8, 8);
	}

	@Test
	public void createInvalidPositionUnderZeroX() {
		Position position = new Position(10, 6, 8, 8);
	}

	@Test
	public void createInvalidPositioUnderZeroY() {
		Position position = new Position(2, 11, 8, 8);
	}
	
	@Test
	public void movePositionOneNorth() {

	}

	@Test
	public void movePositionOneSouth() {

	}

	@Test
	public void movePositionOneEast() {

	}

	@Test
	public void movePositionOneWest() {

	}

	@Test
	public void moveSeveralWays() {

	}
	
	@Test
	public void moveOverLimitsStayInside() {

	}
	
}
