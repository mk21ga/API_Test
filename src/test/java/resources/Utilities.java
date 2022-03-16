package resources;

import io.restassured.response.Response;

public class Utilities {

	
	public static String getPayload(Response response)
	{
		String payload = response.asString();
		return payload;
	}
	
}
