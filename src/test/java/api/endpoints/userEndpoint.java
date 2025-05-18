package api.endpoints;

import api.payloads.userpojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoint {
	
	public static Response creatuser(userpojo payload) {
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routs.Post_URL);
		
		return response;
	}
	
	public static Response readuser(String userName) {
		
		Response response = RestAssured
				.given()
				.pathParam("username", userName)
				.when()
				.get(Routs.Get_URL);
		
		return response;
	}
	
	public static Response updateuser(String userName, userpojo payload) {
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				
				.when()
				.put(Routs.Update_URL);
		
		return response;
	}
	
	public static Response deleteuser(String userName) {
		
		Response response = RestAssured
				.given()
				.pathParam("username", userName)
				
				.when()
				.delete(Routs.Delete_URL);
		
		return response;
	}

}
