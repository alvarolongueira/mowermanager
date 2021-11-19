package com.alvarolongueira.mowermanager.domain;

import org.junit.Assert;
import org.junit.Test;

public class MowerTest {

	private Position position = Position.of(5, 5, 10, 10);
	private Cardinal cardinal = Cardinal.N;
	private Mower mower = new Mower(position, cardinal);

	@Test
	public void createMower() {
		Position position = Position.of(5, 8, 9, 10);
		Cardinal cardinal = Cardinal.S;
		Mower mower = new Mower(position, cardinal);

		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(8, mower.getPosition().getCurrentY());
		Assert.assertEquals(9, mower.getPosition().getMaxX());
		Assert.assertEquals(10, mower.getPosition().getMaxY());
		Assert.assertEquals(Cardinal.S, mower.getCardinal());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createInvalidMower() {
		Position position = Position.of(-5, 8, 9, 10);
		Cardinal cardinal = Cardinal.S;
		new Mower(position, cardinal);
	}

	@Test
	public void moveMowerForward() {
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(6, mower.getPosition().getCurrentY());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(7, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());
	}

	@Test
	public void moveMowerLeft() {
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.TURN_LEFT);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());

		mower.move(Action.TURN_LEFT);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(4, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.S, mower.getCardinal());
	}

	@Test
	public void moveMowerRight() {
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.TURN_RIGHT);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.E, mower.getCardinal());
	}

	@Test
	public void tryMoveOverLimits() {
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(6, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(7, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(8, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(9, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(10, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(10, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());
	}

	@Test
	public void moveSeveralTimest() {
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.TURN_RIGHT);
		Assert.assertEquals(5, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.E, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.E, mower.getCardinal());

		mower.move(Action.TURN_RIGHT);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(5, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.S, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(4, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.S, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(3, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.S, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(2, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(1, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.N, mower.getCardinal());

		mower.move(Action.TURN_LEFT);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(1, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.E, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(7, mower.getPosition().getCurrentX());
		Assert.assertEquals(1, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.E, mower.getCardinal());
	}

}
