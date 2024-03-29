package com.alvarolongueira.mowermanager.comm.input;

import java.util.List;

import com.alvarolongueira.mowermanager.control.Action;
import com.alvarolongueira.mowermanager.domain.Cardinal;
import com.alvarolongueira.mowermanager.domain.Position;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instruction {

	private Cardinal cardinal;

	private Position position;

	private List<Action> actions;

}
