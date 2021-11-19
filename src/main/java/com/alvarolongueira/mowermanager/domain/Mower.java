package com.alvarolongueira.mowermanager.domain;

import java.rmi.UnexpectedException;

import org.apache.log4j.Logger;

import com.alvarolongueira.mowermanager.control.Action;
import com.alvarolongueira.mowermanager.control.CardinalFactory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mower {

	private static final Logger LOG = Logger.getLogger(Mower.class);

	private PositionWithLimits position;
	private Cardinal cardinal;

	public void move(Action action) {

		try {

			if (Action.FORWARD.equals(action)) {
				this.getPosition().apply(cardinal.getMovement());
			}

			if (Action.TURN_RIGHT.equals(action)) {
				Cardinal newCardinal = CardinalFactory.right(this.getCardinal());
				this.setCardinal(newCardinal);
			}

			if (Action.TURN_LEFT.equals(action)) {
				Cardinal newCardinal = CardinalFactory.left(this.getCardinal());
				this.setCardinal(newCardinal);
			}

		} catch (UnexpectedException e) {
			LOG.error("Error applying action: " + action + " in mower " + this);
			e.printStackTrace();
		}

	}
}
