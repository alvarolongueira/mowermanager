package com.alvarolongueira.mowermanager.domain;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

	@Test
	public void createPosition() {
		Position.builder().build();
		Position position = new Position(5, 3, 10, 10);
		Assert.assertEquals(5, position.getCurrentX());
		Assert.assertEquals(3, position.getCurrentY());
		Assert.assertEquals(10, position.getMaxX());
		Assert.assertEquals(10, position.getMaxY());
	}

	@Test
	public void createPositionInZeroPosition() {
		Position position = new Position(0, 0, 10, 10);
		Assert.assertEquals(0, position.getCurrentX());
		Assert.assertEquals(0, position.getCurrentY());
		Assert.assertEquals(10, position.getMaxX());
		Assert.assertEquals(10, position.getMaxY());
	}

	@Test
	public void createPositionInLimits() {
		Position position = new Position(10, 10, 10, 10);
		Assert.assertEquals(10, position.getCurrentX());
		Assert.assertEquals(10, position.getCurrentY());
		Assert.assertEquals(10, position.getMaxX());
		Assert.assertEquals(10, position.getMaxY());
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
		Position position = new Position(5, 3, 10, 10);
		Movement movement = Cardinal.N.getMovement();
		position.apply(movement);
		Assert.assertEquals(5, position.getCurrentX());
		Assert.assertEquals(4, position.getCurrentY());
	}

	@Test
	public void movePositionOneSouth() {
		Position position = new Position(5, 3, 10, 10);
		Movement movement = Cardinal.S.getMovement();
		position.apply(movement);
		Assert.assertEquals(5, position.getCurrentX());
		Assert.assertEquals(2, position.getCurrentY());
	}

	@Test
	public void movePositionOneEast() {
		Position position = new Position(5, 3, 10, 10);
		Movement movement = Cardinal.E.getMovement();
		position.apply(movement);
		Assert.assertEquals(6, position.getCurrentX());
		Assert.assertEquals(3, position.getCurrentY());
	}

	@Test
	public void movePositionOneWest() {
		Position position = new Position(5, 3, 10, 10);
		Movement movement = Cardinal.E.getMovement();
		position.apply(movement);
		Assert.assertEquals(4, position.getCurrentX());
		Assert.assertEquals(3, position.getCurrentY());
	}

	@Test
	public void moveSeveralWays() {
		Position position = new Position(9, 9, 10, 10);
		Movement movementNorth = Cardinal.N.getMovement();
		Movement movementEast = Cardinal.E.getMovement();
		Movement movementSouth = Cardinal.S.getMovement();
		Movement movementWest = Cardinal.W.getMovement();
		position.apply(movementNorth);
		position.apply(movementWest);
		position.apply(movementEast);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementSouth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementWest);
		position.apply(movementSouth);
		position.apply(movementSouth);
		Assert.assertEquals(8, position.getCurrentX());
		Assert.assertEquals(8, position.getCurrentY());
	}

	@Test
	public void moveOverLimitsStayInside() {
		Position position = new Position(9, 9, 10, 10);
		Movement movementNorth = Cardinal.N.getMovement();
		Movement movementEast = Cardinal.E.getMovement();
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementNorth);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		position.apply(movementEast);
		Assert.assertEquals(10, position.getCurrentX());
		Assert.assertEquals(10, position.getCurrentY());
	}

	@Test
	public void moveUnderLimitsStayInside() {
		Position position = new Position(1, 1, 10, 10);
		Movement movementSouth = Cardinal.S.getMovement();
		Movement movementWest = Cardinal.W.getMovement();
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementSouth);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		position.apply(movementWest);
		Assert.assertEquals(0, position.getCurrentX());
		Assert.assertEquals(0, position.getCurrentY());
	}

}
