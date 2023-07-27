package www.HealthyShop2023.User.Controller;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;    
import org.json.simple.JSONValue;

import www.HealthyShop2023.Utils.JWT;

public class test {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("1", "user");
		map.put("2", "user");
		String token = JWT.createJWT(map);
		System.out.println(token);
		System.out.println();
		System.out.println(JWT.decodess(token));
		
		Object obj=JSONValue.parse(JWT.decodess(token)); 
		JSONObject jsonObject = (JSONObject) obj;   
		String dataString = jsonObject.get("1").toString();
		System.out.println(   dataString);
	}
}
