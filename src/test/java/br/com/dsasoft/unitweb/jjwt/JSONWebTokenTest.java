package br.com.dsasoft.unitweb.jjwt;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import io.jsonwebtoken.Claims;

public class JSONWebTokenTest {

	private static final String ID = "UBLYVJY4WEureTcGUbinozmDlLQ4n0-g";

	private static final String SUBJECT = "_SUBJECT";

	private static final Date EXPIRES = new Date(System.currentTimeMillis() + 86400 * 1000);

	private static final String ISSUER = "eyJhbGciOiJIUzUxMiJ9";

	private static QuickStartWithJJWT quickStartJwt;

	private static String jwtCompact;

	private static Claims claimed;

	static {
		System.out.println(ID);
		System.out.println(SUBJECT);
		System.out.println(ISSUER);
		System.out.println(EXPIRES);

		quickStartJwt = new QuickStartWithJJWT();

		jwtCompact = quickStartJwt.generate(ID, SUBJECT, ISSUER, EXPIRES);

		System.out.println("---------------------------------------------------------\n");
		System.out.println(jwtCompact);
		System.out.println("---------------------------------------------------------\n");

		claimed = quickStartJwt.claim(jwtCompact);
	}

	@Before
	public void setUp() {
		System.out.println("█▓▓▒▒░░░ @Before method ░░▒▒▓▓█");
	}

	@Test
	public void assertSubject() {

		System.out.println("Subject → " + claimed.getSubject());

		assertEquals(claimed.getSubject(), SUBJECT);
	}

	@Test
	public void assertIssuer() {
		System.out.println("Issuer 	→ " + claimed.getIssuer());

		assertEquals(claimed.getIssuer(), ISSUER);
	}

	@Test
	public void assertExpiration() {
		System.out.println("Expires → " + claimed.getExpiration());

		assertEquals(claimed.getExpiration().toString(), EXPIRES.toString());
	}

	@Test
	public void assertId() {
		System.out.println("Id\t→ " + claimed.getId());

		assertEquals(claimed.getId().toString(), ID);
	}

	@Test
	public void assertNullAudience() {
		System.out.println("Audience ►► " + claimed.getAudience());
		
		assertEquals(null, claimed.getAudience());
	}
	
	@Test
	public void assertDecoded(){
		System.out.println(quickStartJwt.decodeJwt(jwtCompact));
		
		assertNotEquals(null, quickStartJwt.decodeJwt(jwtCompact));
	}
}
