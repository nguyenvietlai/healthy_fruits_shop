package www.HealthyShop2023.Utils;



import javax.crypto.spec.SecretKeySpec;

import org.apache.poi.ss.formula.functions.T;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;


import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class JWT {
	private static final  String SECRET_KEY = "KieuAnhVan20YearsOld";
	private static final int EXPERIENCE =5;
	/*
	 * @param map includes info user(email , id );
	 * @param minute is set experiences for token
	 * @return token type string
	 * */
	public static String createJWT(Map<String, Object> map ) {
		byte[] decodedSecret = Base64.getDecoder().decode(SECRET_KEY);
		map.put("exp", (new Date().getTime() + (60000L * EXPERIENCE)));
		String jwtToken = Jwts.builder().setHeaderParam("alg"	, "HS256").setHeaderParam("typ", "JWT")
                .setClaims(map)
	            .signWith(SignatureAlgorithm.HS256,decodedSecret).compact();
		return jwtToken;
	}

	public static String decodess(String token) {
		 try {
			 String[] data =token.split("\\.");
			 return  new String(Base64.getUrlDecoder().decode(data[1]));
		} catch (Exception e) {
			return null;
		}
        
    }

	
	public static boolean checkSign(String token) {
		String[] data =token.split("\\.");
		SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        try {
        	SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY), sa.getJcaName());
            DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(SignatureAlgorithm.HS256, secretKeySpec);
            if (!validator.isValid(data[0] + "." +data[1], data[2])) {
                return false;
            }
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
    	return true;
   }
	
	public static boolean checkExp(String token) {
		JSONObject payload = new JSONObject(decodess(token));
      	Long expss = payload.getLong("exp");
      	System.out.println("Exp: " + expss);
      	if(expss < new Date().getTime()) {
      		return false;
      	}
      	return true;
   }

}
