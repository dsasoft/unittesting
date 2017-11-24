package br.com.dsasoft.unitweb.jjwt;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class QuickStartWithJJWT {

	// TODO Generate a private API Key
	final Key key = MacProvider.generateKey();

	public String generate(final String id, final String subject, final String issuer, final Date expires) {
		return Jwts.builder()
				.setId(id).setSubject(subject).setIssuer(issuer).setExpiration(expires)
				.signWith(SignatureAlgorithm.HS512, key).compact();
	}

	public String decodeJwt(final String jwtCompact) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtCompact).getBody().toString();
	}

	public Claims claim(final String jwtCompact) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtCompact).getBody();
	}
}
