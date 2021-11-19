package com.alvarolongueira.mowermanager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.alvarolongueira.mowermanager.control.CardinalFactoryTest;
import com.alvarolongueira.mowermanager.domain.MowerTest;
import com.alvarolongueira.mowermanager.domain.PositionWithLimitsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	PositionWithLimitsTest.class, 
	CardinalFactoryTest.class, 
	MowerTest.class, 
	MowerManagerApplicationTest.class 
})

public class TestSuite {

}
