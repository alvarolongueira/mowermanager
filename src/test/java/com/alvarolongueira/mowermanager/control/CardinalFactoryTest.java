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

		Assert.assertEquals(newCardinal, cardinalEast);
	}

	@Test
	public void northToEastLeft() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);

		Assert.assertEquals(newCardinal, cardinalEast);
	}

	@Test
	public void southToWestRight() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);

		Assert.assertEquals(newCardinal, cardinalWest);
	}

	@Test
	public void southToWesttLeft() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);

		Assert.assertEquals(newCardinal, cardinalWest);
	}

	@Test
	public void northToSouthSeveralTurns() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);

		Assert.assertEquals(newCardinal, cardinalSouth);
	}

	@Test
	public void westToEastSeveralTurns() throws UnexpectedException {

		Cardinal newCardinal = CardinalFactory.right(cardinalNorth);

		Assert.assertEquals(newCardinal, cardinalWest);
	}
}
