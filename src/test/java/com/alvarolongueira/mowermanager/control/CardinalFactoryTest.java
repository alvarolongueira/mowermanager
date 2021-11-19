package com.alvarolongueira.mowermanager.control;

import java.rmi.UnexpectedException;

import org.junit.Assert;
import org.junit.Test;

import com.alvarolongueira.mowermanager.domain.Cardinal;

public class CardinalFactoryTest {

	private final Cardinal cardinalNorth = Cardinal.N;
	private final Cardinal cardinalSouth = Cardinal.S;
	private final Cardinal cardinalWest = Cardinal.W;
	private final Cardinal cardinalEast = Cardinal.E;

	@Test
	public void northToEastRight() throws UnexpectedException {
		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);
		Assert.assertEquals(cardinalEast, newCardinal);
	}

	@Test
	public void northToEastLeft() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.left(cardinalNorth);
		Assert.assertEquals(cardinalWest, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalSouth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalEast, newCardinal);
	}

	@Test
	public void southToWestRight() throws UnexpectedException {
		Cardinal newCardinal = CardinalFactory.right(cardinalSouth);
		Assert.assertEquals(cardinalWest, newCardinal);
	}

	@Test
	public void southToWestLeft() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.left(cardinalSouth);
		Assert.assertEquals(cardinalEast, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalNorth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalWest, newCardinal);
	}

	@Test
	public void northToSouthSeveralTurns() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);
		Assert.assertEquals(cardinalEast, newCardinal);

		newCardinal = CardinalFactory.right(newCardinal);
		Assert.assertEquals(cardinalSouth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalEast, newCardinal);

		newCardinal = CardinalFactory.right(newCardinal);
		Assert.assertEquals(cardinalSouth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalEast, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalNorth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalWest, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalSouth, newCardinal);
	}

	@Test
	public void westToEastSeveralTurns() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalWest);
		Assert.assertEquals(cardinalNorth, newCardinal);

		newCardinal = CardinalFactory.right(newCardinal);
		Assert.assertEquals(cardinalEast, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalNorth, newCardinal);

		newCardinal = CardinalFactory.right(newCardinal);
		Assert.assertEquals(cardinalEast, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalNorth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalWest, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalSouth, newCardinal);

		newCardinal = CardinalFactory.left(newCardinal);
		Assert.assertEquals(cardinalEast, newCardinal);
	}
}
