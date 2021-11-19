package com.alvarolongueira.mowermanager.comm.input;

public interface InputService {

	public Instruction readFirstInstruction();

	public Instruction readNextInstruction();

}
