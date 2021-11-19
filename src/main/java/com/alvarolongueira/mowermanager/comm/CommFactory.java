package com.alvarolongueira.mowermanager.comm;

import com.alvarolongueira.mowermanager.comm.input.InputService;
import com.alvarolongueira.mowermanager.comm.input.filereader.InputServiceFileReader;
import com.alvarolongueira.mowermanager.comm.output.OutputService;
import com.alvarolongueira.mowermanager.comm.output.console.OutputServiceConsole;

public class CommFactory {

	public InputService getInputService() {
		return new InputServiceFileReader();
	}

	public OutputService getOutputService() {
		return new OutputServiceConsole();
	}

}
