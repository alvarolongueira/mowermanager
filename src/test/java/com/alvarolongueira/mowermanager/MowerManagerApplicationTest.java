package com.alvarolongueira.mowermanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.alvarolongueira.mowermanager.comm.CommFactory;
import com.alvarolongueira.mowermanager.comm.output.OutputService;
import com.alvarolongueira.mowermanager.domain.Mower;

@RunWith(MockitoJUnitRunner.class)
public class MowerManagerApplicationTest {

	@Mock
	CommFactory commFactory;

	@Mock
	OutputService ouputService;

	@Test
	public void completeTest() {
		Mockito.when(commFactory.getOutputService()).thenReturn(ouputService);


		MowerManagerApplication.run(commFactory);
		
		
		Mower expectedMower = null;
		Mockito.verify(ouputService).write(expectedMower);
	}

}
