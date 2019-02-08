package weatherreports;

import org.apache.http.HttpRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

 
public class Cityweather {
	private  String cityname;
	private int statuscode;
	private String statusline;
	public static RequestSpecification weatherreports() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		return httprequest;
	}

	public Cityweather(String cityname) {
		this.cityname = cityname;
		setup();
	}
	
	public Response getresponse() {
		Response response = weatherreports().get(cityname);
		return response;
	}
	public int getstatuscode () {
		return statuscode;
	}
	public String getstatusline () {
		return statusline;
	}
	public void setstatuscode() {
		statuscode = getresponse().getStatusCode();
	}
	public void setstatusline() {
		statusline = getresponse().getStatusLine();
	}
	public void  setup() {
		this.setstatuscode();
		this.setstatusline();
	}
}


