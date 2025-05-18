package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.userEndpoint;
import api.payloads.userpojo;
import io.restassured.response.Response;

public class UserTest {

	
	userpojo userPayload;
	public Logger logger; 
	
	@BeforeClass
	public void setup()
	{
		userPayload=new userpojo();
		
		userPayload.setId(2);
		userPayload.setUsername("Ram");
		userPayload.setFirstName("Shyam");
		userPayload.setLastName("Patil");
		userPayload.setEmail("Ram@gmail.com");
		userPayload.setPassword("Ram@123");
		userPayload.setPhone("1234567890");
		
		//logs
		logger= LogManager.getLogger(this.getClass());
		logger.debug("debugging.....");
	}	
	
	@Test (priority = 1)
	public void testPostUser() {
		logger.info("**************  Creating user  **************");
		Response response = userEndpoint.creatuser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************** User is created **************");
	}
	
	@Test (priority = 2)
	public void testgetUser() {
		
		logger.info("************** get User Data **************");
		Response response = userEndpoint.readuser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************** User Data displayed **************");
	}
	
	@Test (priority = 3)
	public void testUpdateUser() {
		
		//update data
		logger.info("************** User Data Updated **************");
		userPayload.setLastName("suryavanshi");
		userPayload.setEmail("Ramrajya@gmail.com");
		userPayload.setPassword("Ramrajya@123");
		
		Response response = userEndpoint.updateuser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Response after update
		Response responseAfterUpdate = userEndpoint.readuser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("************** User Data Updated **************");
	}
	
	@Test (priority = 4)
	public void testDeleteUseer() {
		
		logger.info("************** Deleting User **************");
		Response response =userEndpoint.deleteuser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);	
		logger.info("************** User deleted **************");
	}
}
