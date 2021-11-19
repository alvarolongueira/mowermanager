package com.alvarolongueira.mowermanager.comm.input;

import java.util.Optional;

import com.alvarolongueira.mowermanager.domain.Position;

public interface InputService {

	public Optional<Position> readFirstInstruction();

	public Optional<Instruction> readNextInstruction();

}
