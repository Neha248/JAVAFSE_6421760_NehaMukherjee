package com.sample.utils;

public class MyService {
	private final ExternalAPI externalAPI;
	
	public MyService(ExternalAPI externalAPI)
	{
		this.externalAPI=externalAPI;
	}
	public String processData(int id)
	{
		String data=externalAPI.getData(id);
		if(data!=null && data.contains("success"))
			return "Processed "+data;
		else
			return "Error processing data";
	}
}
