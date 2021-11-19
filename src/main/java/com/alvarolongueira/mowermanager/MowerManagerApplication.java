package com.alvarolongueira.mowermanager;

import com.alvarolongueira.mowermanager.comm.CommFactory;
import com.alvarolongueira.mowermanager.service.ManagerService;

public class MowerManagerApplication {

	public static void main(String[] args) {
		ManagerService service = new ManagerService(new CommFactory());
		service.run();
	}

}
