package com.alvarolongueira.mowermanager.service;

import java.util.List;

import com.alvarolongueira.mowermanager.control.Action;
import com.alvarolongueira.mowermanager.domain.Cardinal;
import com.alvarolongueira.mowermanager.domain.Mower;
import com.alvarolongueira.mowermanager.domain.Position;
import com.alvarolongueira.mowermanager.input.InputFactory;
import com.alvarolongueira.mowermanager.input.InputService;
import com.alvarolongueira.mowermanager.input.Instruction;
import com.alvarolongueira.mowermanager.ouput.OutputFactory;
import com.alvarolongueira.mowermanager.ouput.OutputService;

public class ManagerService {

	private int max_X;
	private int max_Y;
	
	private InputService inputService = InputFactory.getService();
	private OutputService outputService = OutputFactory.getService();

	public void run() {

		Instruction firstInstruction = inputService.readFirstInstruction();
		this.init(firstInstruction);

		Instruction instruction;
		do {
			instruction = inputService.readNextInstruction();
			Mower mower = this.mowerAction(instruction.getPosition(), instruction.getCardinal(), instruction.getActions());
			outputService.write(mower);

		} while (instruction != null);
	}

	public void init(Instruction instruction) {
		Position position = instruction.getPosition();
		this.max_X = position.getCurrentX();
		this.max_X = position.getCurrentY();
	}

	private Mower mowerAction(Position position, Cardinal cardinal, List<Action> actions) {
		// TODO Auto-generated method stub
		return null;
	}
}
