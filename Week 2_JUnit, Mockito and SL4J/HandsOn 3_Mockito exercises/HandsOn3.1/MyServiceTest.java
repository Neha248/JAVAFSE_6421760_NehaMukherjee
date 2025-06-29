package com.sample.test;

import com.sample.utils.ExternalAPI;
import com.sample.utils.MyService;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyServiceTest {

	@Test
	void test() {
		ExternalAPI externalAPImock=Mockito.mock(ExternalAPI.class);
		when(externalAPImock.getData(1)).thenReturn("Data for ID 1 - success");
		when(externalAPImock.getData(2)).thenReturn("Data for ID 2 - failure");
		
		MyService myService=new MyService(externalAPImock);
		
		assertEquals("Processed Data for ID 1 - success",myService.processData(1));
		assertEquals("Error processing data",myService.processData(2));
		
		verify(externalAPImock).getData(1);
	}

}
