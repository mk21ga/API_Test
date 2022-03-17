package resources;

import ApiRestAssured.ApiFramework.Base;
import io.restassured.response.Response;

public class Utilities extends Base {
	
	public static String getPayload(Response response)
	{
		String payload = response.asString();
		return payload;
	}
	
}
