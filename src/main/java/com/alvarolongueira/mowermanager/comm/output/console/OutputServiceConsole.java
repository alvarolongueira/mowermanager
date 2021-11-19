package com.alvarolongueira.mowermanager.comm.output.console;

import com.alvarolongueira.mowermanager.comm.output.OutputService;
import com.alvarolongueira.mowermanager.domain.Mower;

public class OutputServiceConsole implements OutputService {

	@Override
	public void write(Mower mower) {
		int x = mower.getPosition().getCurrentX();
		int y = mower.getPosition().getCurrentY();
		String cardinalCode = mower.getCardinal().getCode();
		System.out.println(x + " " + y + " " + cardinalCode);
	}

}
