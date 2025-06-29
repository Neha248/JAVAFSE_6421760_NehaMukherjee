package com.verify.utils;

public class MyService {
	private MyDependency myDependency;
	public MyService(MyDependency myDependency) {
		this.myDependency=myDependency;
	}
	public void processData(String data) {
		myDependency.getData(data);
		myDependency.getOtherData("other "+data);
	}
}
