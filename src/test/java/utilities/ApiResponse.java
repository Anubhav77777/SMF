
package utilities;

import base.setupbase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiResponse extends setupbase{

	
	    public static int getApiResponseBody (String endpoint ) {
	        Response response = RestAssured.get(endpoint);
	        return response.getStatusCode();
//	        System.out.println("Backend API Message: " + response);
//	        return response.jsonPath().getString(key);
//	      return  response.jsonPath().getString("data.message");

//	        String responseBody = response.getBody().asString();
//	        System.out.println("Backend API Message: " + responseBody);
//			return responseBody;/
	    }
	}




