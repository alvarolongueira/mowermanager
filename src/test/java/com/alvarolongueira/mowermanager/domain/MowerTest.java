package com.alvarolongueira.mowermanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alvarolongueira.mowermanager.control.Action;

public class MowerTest {

	private PositionWithLimits position;
	private Cardinal cardinal;
	private Mower mower;

	@Before
	public void inicializar() {
		this.position = PositionWithLimits.of(5, 5, 10, 10);
		this.cardinal = Cardinal.N;
		this.mower = new Mower(this.position, this.cardinal);
	}

	@Test
	public void createMower() {
		PositionWithLimits position = PositionWithLimits.of(5, 8, 9, 10);
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
		PositionWithLimits position = PositionWithLimits.of(-5, 8, 9, 10);
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
		Assert.assertEquals(Cardinal.S, mower.getCardinal());

		mower.move(Action.FORWARD);
		Assert.assertEquals(6, mower.getPosition().getCurrentX());
		Assert.assertEquals(1, mower.getPosition().getCurrentY());
		Assert.assertEquals(Cardinal.S, mower.getCardinal());

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
