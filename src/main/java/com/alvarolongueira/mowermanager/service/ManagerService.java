package com.alvarolongueira.mowermanager.service;

import java.util.List;
import java.util.Optional;

import com.alvarolongueira.mowermanager.comm.CommFactory;
import com.alvarolongueira.mowermanager.comm.input.InputService;
import com.alvarolongueira.mowermanager.comm.input.Instruction;
import com.alvarolongueira.mowermanager.comm.output.OutputService;
import com.alvarolongueira.mowermanager.control.Action;
import com.alvarolongueira.mowermanager.domain.Cardinal;
import com.alvarolongueira.mowermanager.domain.Mower;
import com.alvarolongueira.mowermanager.domain.Position;
import com.alvarolongueira.mowermanager.domain.PositionWithLimits;

public class ManagerService {

	private int maxX;
	private int maxY;

	private final InputService inputService;
	private final OutputService outputService;

	public ManagerService(CommFactory commFactory) {
		inputService = commFactory.getInputService();
		outputService = commFactory.getOutputService();
	}

	public void run() {

		Optional<Position> maxDimensions = inputService.readFirstInstruction();
		if (!maxDimensions.isPresent()) {
			return;
		}

		this.saveMaxParameters(maxDimensions.get());

		Optional<Instruction> optionalInstruction = inputService.readNextInstruction();
		while (optionalInstruction.isPresent()) {

			Instruction instruction = optionalInstruction.get();
			Mower mower = this.mowerAction(instruction.getPosition(), instruction.getCardinal(), instruction.getActions());
			outputService.write(mower);

			optionalInstruction = inputService.readNextInstruction();
		}
	}

	public void saveMaxParameters(Position maxDimensions) {
		this.maxX = maxDimensions.getX();
		this.maxY = maxDimensions.getY();
	}

	private Mower mowerAction(Position position, Cardinal cardinal, List<Action> actions) {
		PositionWithLimits positionWithLimits = PositionWithLimits.of(position.getX(), position.getY(), this.maxX, this.maxY);
		Mower mower = new Mower(positionWithLimits, cardinal);
		mower.move(actions);
		return mower;
	}

}
