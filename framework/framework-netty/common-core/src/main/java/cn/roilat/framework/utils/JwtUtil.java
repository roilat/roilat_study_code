package cn.roilat.framework.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

public class JwtUtil {
	
	public static final String SECKET = "tfkj";
	
	/*********
	 * 解析token值  获取后  {"username":"xxx"}
	 * @param jsonWebToken
	 * @return
	 */
	public static String parseJWT(String jsonWebToken) {
	try {
			Claims claims = Jwts.parser()
			.setSigningKey(DatatypeConverter.parseBase64Binary(SECKET))
			.parseClaimsJws(jsonWebToken).getBody();
			System.out.println("ID: " + claims.getId());
			System.out.println("Subject: " + claims.getSubject());
			System.out.println("Issuer: " + claims.getIssuer());
			System.out.println("Expiration: " + claims.getExpiration());
			return claims.getSubject();
			//return claims;
			/**/
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	/********
	 * 獲取token值
	 * @param subject   json格式的字符串(包括用戶信息)
	 * @param ttlMillis 過期時間
	 * @return
	 * @throws Exception
	 * 
	 * 
	 * 
    iss(Issuser)：代表这个JWT的签发主体；
    sub(Subject)：代表这个JWT的主体，即它的所有人；
    aud(Audience)：代表这个JWT的接收对象；
    exp(Expiration time)：是一个时间戳，代表这个JWT的过期时间；
    nbf(Not Before)：是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的；
    iat(Issued at)：是一个时间戳，代表这个JWT的签发时间；
    jti(JWT ID)：是JWT的唯一标识。
	 * 
	 * 
	 */
	public static String createJWT(String subject) throws Exception {
	       SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
	       long nowMillis = System. currentTimeMillis();
	       Date now = new Date( nowMillis);
	       byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECKET);
	       SecretKey key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	       JwtBuilder builder = Jwts.builder()
	            //.setId(id)
	            .setIssuedAt(now)
	            .setSubject(subject)
	           .signWith(signatureAlgorithm, key);
	       /*
	        * 设置过期时间
	        * if (ttlMillis >= 0){
	           long expMillis = nowMillis + ttlMillis;
	           Date exp = new Date( expMillis);
	           builder.setExpiration( exp);
	       }*/
	       return builder.compact();
	 }

	public static void main(String[] args) throws Exception {
		String json = "{\"username\":\"admin\"}";
		String token = createJWT(json);
		System.out.println("token--->"+token);
		String tokens = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1MTM5MzYwMTMsInN1YiI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwifSJ9.CtMJKOAJS5bLuYe-XJhoNhumneYxzGGF-EyKjq19ylw";
		System.out.println(parseJWT(tokens));/**/
	}
}
