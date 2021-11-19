package com.alvarolongueira.mowermanager.domain;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

	@Test
	public void createPosition() {
		Position position = new Position(4, 3, 10, 10);
		Assert.assertEquals(4, position.getCurrentX());
		Assert.assertEquals(3, position.getCurrentY());
		Assert.assertEquals(8, position.getMaxX());
		Assert.assertEquals(8, position.getMaxY());
	}

	@Test
	public void createPositionInZeroPosition() {
		Position position = new Position(0, 0, 10, 10);
	}

	@Test
	public void createPositionInLimits() {
		Position position = new Position(10, 10, 10, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createInvalidPositionOverXLimit() {
		Position position = new Position(11, 5, 10, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createInvalidPositionOverYLimit() {
		Position position = new Position(5, 11, 10, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createInvalidPositionUnderZeroX() {
		Position position = new Position(-1, 5, 10, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createInvalidPositioUnderZeroY() {
		Position position = new Position(5, -1, 10, 10);
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
