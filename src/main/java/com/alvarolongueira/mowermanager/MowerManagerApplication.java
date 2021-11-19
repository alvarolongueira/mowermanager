package com.alvarolongueira.mowermanager;

import com.alvarolongueira.mowermanager.comm.CommFactory;
import com.alvarolongueira.mowermanager.service.ManagerService;

public class MowerManagerApplication {

	public static void main(String[] args) {
		CommFactory commFactory = new CommFactory();
		run(commFactory);
	}

	public static void run(CommFactory commFactory) {
		ManagerService service = new ManagerService(commFactory);
		service.run();
	}

}
