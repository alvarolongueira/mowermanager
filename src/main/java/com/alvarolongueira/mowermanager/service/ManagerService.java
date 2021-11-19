package com.alvarolongueira.mowermanager.service;

import java.util.List;

import com.alvarolongueira.mowermanager.comm.CommFactory;
import com.alvarolongueira.mowermanager.comm.input.InputService;
import com.alvarolongueira.mowermanager.comm.input.Instruction;
import com.alvarolongueira.mowermanager.comm.output.OutputService;
import com.alvarolongueira.mowermanager.control.Action;
import com.alvarolongueira.mowermanager.domain.Cardinal;
import com.alvarolongueira.mowermanager.domain.Mower;
import com.alvarolongueira.mowermanager.domain.Position;

public class ManagerService {

	private int max_X;
	private int max_Y;

	private final InputService inputService;
	private final OutputService outputService;

	public ManagerService(CommFactory commFactory) {
		inputService = commFactory.getInputService();
		outputService = commFactory.getOutputService();
	}

	public void run() {
		
		Instruction firstInstruction = inputService.readFirstInstruction();
		this.saveMaxParameters(firstInstruction);

		Instruction instruction;
		do {
			instruction = inputService.readNextInstruction();
			Mower mower = this.mowerAction(instruction.getPosition(), instruction.getCardinal(), instruction.getActions());
			outputService.write(mower);

		} while (instruction != null);
		
	}

	public void saveMaxParameters(Instruction instruction) {
		Position position = instruction.getPosition();
		this.max_X = position.getCurrentX();
		this.max_X = position.getCurrentY();
	}

	private Mower mowerAction(Position position, Cardinal cardinal, List<Action> actions) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMax_X() {
		return max_X;
	}

	public int getMax_Y() {
		return max_Y;
	}

}
