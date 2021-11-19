package com.alvarolongueira.mowermanager.control;

import org.junit.Assert;
import org.junit.Test;

import com.alvarolongueira.mowermanager.domain.Cardinal;

public class CardinalFactoryTest {

	private final Cardinal cardinalNorth = Cardinal.N;
	private final Cardinal cardinalSouth = Cardinal.S;
	private final Cardinal cardinalWest = Cardinal.W;
	private final Cardinal cardinalEast = Cardinal.E;

	@Test
	public void northToEastRight() {

		Cardinal newCardinal = CardinalFactory.of(cardinalNorth).turnRight();

		Assert.assertEquals(newCardinal, cardinalEast);
	}

	@Test
	public void northToEastLeft() {

		Cardinal newCardinal = CardinalFactory.of(cardinalNorth).turnRight();

		Assert.assertEquals(newCardinal, cardinalEast);
	}

	@Test
	public void southToWestRight() {

		Cardinal newCardinal = CardinalFactory.of(cardinalNorth).turnRight();

		Assert.assertEquals(newCardinal, cardinalWest);
	}

	@Test
	public void southToWesttLeft() {

		Cardinal newCardinal = CardinalFactory.of(cardinalNorth).turnRight();

		Assert.assertEquals(newCardinal, cardinalWest);
	}

	@Test
	public void northToSouthSeveralTurns() {

		Cardinal newCardinal = CardinalFactory.of(cardinalNorth).turnRight();

		Assert.assertEquals(newCardinal, cardinalSouth);
	}

	@Test
	public void westToEastSeveralTurns() {

		Cardinal newCardinal = CardinalFactory.of(cardinalNorth).turnRight();

		Assert.assertEquals(newCardinal, cardinalWest);
	}
}
