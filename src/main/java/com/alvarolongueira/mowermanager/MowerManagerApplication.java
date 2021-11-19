package com.alvarolongueira.mowermanager;

import com.alvarolongueira.mowermanager.service.ManagerService;

public class MowerManagerApplication {

	public static void main(String[] args) {
		ManagerService service = new ManagerService();
		service.run();
	}

}
