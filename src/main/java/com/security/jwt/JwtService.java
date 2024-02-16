package com.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

/**
 * A sample JWT program to demonstrate create and validate a jwt token
 */
public class JwtService {

	//TODO: This should not be here.  It should be encrypted and loaded from env or vault
	private static final String SECRET_KEY = "kdIDNK73Jhu&jj#$gRekld09kdIDNK73JhukdIDNK73Jhu";

	
	public static void main(String[] args) throws Exception {

		JwtService service = new JwtService();  
		
		//create jwt

		String jwt = service.createJwt("TarunK");
		
		
		//verify jwt
				
		boolean verify = service.verifyJwt(jwt);
		System.out.println(verify);
		
	}
	
	public String createJwt(String subject) throws Exception {


		byte[] sharedSecret = new byte[32];
		sharedSecret = SECRET_KEY.getBytes();
		
		// Create HMAC signer
		JWSSigner signer = new MACSigner(sharedSecret);
	
		// Prepare JWT with claims set
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
		    .subject(subject)
		    .issuer("https://cts.com")
		    .expirationTime(new Date(new Date().getTime() + 10 * 1000))// 1200 seconds
		    .issueTime(new Date(new Date().getTime()))
		    .claim("firstName", "Mohanraj")
		    .claim("lastName", "Dhanasekar")
		    .build();
	
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
	
		// Apply the HMAC protection
		signedJWT.sign(signer);
	

		String jwt = signedJWT.serialize();
		
		System.out.println("jwt token = " + jwt);
		
		
		
		return jwt;
		
		
	

	}
	
	public boolean verifyJwt(String jwt) throws Exception {


		byte[] sharedSecret = new byte[32];
		sharedSecret = SECRET_KEY.getBytes();
		
		// On the consumer side, parse the JWS and verify its HMAC
		SignedJWT signedJWT = SignedJWT.parse(jwt);
	
		JWSVerifier verifier = new MACVerifier(sharedSecret);
		
		boolean verify = signedJWT.verify(verifier);
		
		System.out.println("verified = " + verify);
		
	
		
		//payload
		final Map<String, String> payloadMap = new HashMap<String, String>();
        JWTClaimsSet jwtClaimsSet = signedJWT.getJWTClaimsSet();
        Map<String,Object> claims = jwtClaimsSet.getClaims();
        claims.forEach(new BiConsumer<String, Object>() {
			@Override
			public void accept(String key, Object value) {
			    payloadMap.put(key, String.valueOf(value));
			    System.out.println(key + " : "+ String.valueOf(value));
			}
		});
        
        return verify;
	

	}



}
