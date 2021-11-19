package com.alvarolongueira.mowermanager.comm.input.filereader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.log4j.Logger;

import com.alvarolongueira.mowermanager.comm.input.InputService;
import com.alvarolongueira.mowermanager.comm.input.Instruction;

public class InputServiceFileReader implements InputService {

	private static final Logger LOG = Logger.getLogger(InputServiceFileReader.class);

	private final String fileName = "instructions_list.txt";
	private final Queue<String> queue = new LinkedList<String>();

	public InputServiceFileReader() {
		readFile();
	}

	@Override
	public Instruction readFirstInstruction() {

		return null;
	}

	@Override
	public Instruction readNextInstruction() {

		return null;
	}

	private void readFile() {
		try {
			URL url = getClass().getClassLoader().getResource(fileName);
			File file = new File(url.toURI());
			List<String> lines = Files.readAllLines(Paths.get(file.getCanonicalPath()));
			queue.addAll(lines);

		} catch (URISyntaxException | IOException e) {
			LOG.error("Error leyendo archivo: " + fileName);
		}
	}

}
