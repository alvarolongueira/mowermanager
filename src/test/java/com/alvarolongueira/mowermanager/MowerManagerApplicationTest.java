package com.alvarolongueira.mowermanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.alvarolongueira.mowermanager.comm.CommFactory;
import com.alvarolongueira.mowermanager.comm.output.OutputService;
import com.alvarolongueira.mowermanager.domain.Cardinal;
import com.alvarolongueira.mowermanager.domain.Mower;
import com.alvarolongueira.mowermanager.domain.PositionWithLimits;

@RunWith(MockitoJUnitRunner.class)
public class MowerManagerApplicationTest {

	CommFactory commFactory = Mockito.spy(new CommFactory());

	@Mock
	OutputService ouputService;

	@Test
	public void completeTest() {

		Mockito.when(commFactory.getOutputService()).thenReturn(ouputService);

		MowerManagerApplication.run(commFactory);

		PositionWithLimits position1 = PositionWithLimits.of(1, 3, 5, 5);
		Cardinal cardinal1 = Cardinal.N;
		Mower expectedMower1 = new Mower(position1, cardinal1);
		Mockito.verify(ouputService).write(expectedMower1);

		PositionWithLimits position2 = PositionWithLimits.of(5, 1, 5, 5);
		Cardinal cardinal2 = Cardinal.E;
		Mower expectedMower2 = new Mower(position2, cardinal2);
		Mockito.verify(ouputService).write(expectedMower2);
	}

}
