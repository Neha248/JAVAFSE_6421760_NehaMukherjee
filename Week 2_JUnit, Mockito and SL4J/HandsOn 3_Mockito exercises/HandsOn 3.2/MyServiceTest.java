package com.verify.tests;

import com.verify.utils.MyDependency;
import com.verify.utils.MyService;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyServiceTest {

	@Test
	void test() {
		MyDependency mockDependency=mock(MyDependency.class);
		MyService myService=new MyService(mockDependency);
		String data="sample data";
		myService.processData(data);
		verify(mockDependency).getData(data);
		//verify(mockDependency).getOtherData(data);
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mockDependency).getOtherData(captor.capture());
		String capturedValue=captor.getValue();
		assertEquals("other sample data",capturedValue);
	}
}
