package restassured;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import weatherreports.Cityweather;

public class WeatherReportTest {
	 @DataProvider
	    public Object[][] citydetails() {
	        return new Object[][]{
	                {"/Hyderabad", 200, "correct status code is generated"},
	                {"/949494949", 400, "correct status code is generated"},
	                
	        };
	    }
@Test(dataProvider="citydetails")

public void Statuscode(String Cityname, int Expectedstatuscode , String message) {
	Cityweather weather = new Cityweather(Cityname);
	Assert.assertEquals(weather.getstatuscode(), Expectedstatuscode, message);
	
}
}
