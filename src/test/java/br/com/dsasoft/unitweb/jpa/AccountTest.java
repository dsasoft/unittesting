package br.com.dsasoft.unitweb.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {

	private static final String PERSISTENCE_UNIT = "em-test";

	private static EntityManagerFactory emf;

	private EntityManager em;

	private Account fakeAccount;
	
	@BeforeClass
	public static void setUpClass() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Before
	public void setUp() {
		em = emf.createEntityManager();
		em.getTransaction().begin();

		persistFakeAccount();
	}

	private void persistFakeAccount() {
		fakeAccount = new Account("Wallet", new BigDecimal(0.0d));
		em.persist(fakeAccount);
	}
	
	@Test
	public void listAll(){
		Query query = em.createQuery("SELECT a FROM Account a");
		
		List<?> rs = query.getResultList();
		
		for(int i = 0; i < rs.size(); i++)
			System.out.println(rs.get(i));
	}

	@Test
	public void assertGeneratedId() {
		assertNotNull(fakeAccount.getId());
	}

	@Test
	public void findByIdMakeAssertions() {
		Account retrieved = em.find(Account.class, fakeAccount.getId());

		assertEquals(fakeAccount, retrieved);

		assertEqualsMethod(fakeAccount, retrieved);
		
		assertEqualsNames(fakeAccount, retrieved);
		
		assertEqualsBalance(fakeAccount, retrieved);
		
		assertEqualsHashCode(fakeAccount, retrieved);
	}

	private void assertEqualsHashCode(Account arg0, Account arg1){
		assertEquals(arg0.hashCode(), arg1.hashCode());
	}
	
	private void assertEqualsMethod(Account arg0, Account arg1) {
		assertEquals(arg0.equals(arg1), arg1.equals(arg0));
	}
	
	private void assertEqualsNames(Account arg0, Account arg1){
		assertEquals(arg0.getName(), arg1.getName());
	}
	
	private void assertEqualsBalance(Account arg0, Account arg1){
		assertEquals(arg0.getBalance(), arg1.getBalance());
	}
	
	@Test
	public void assertEqualsEntitiesNullId(){
		assertEquals(new Account("", new BigDecimal(0.0d)), new Account("", new BigDecimal(0.0d)));
	}
	
	@Test
	public void assertNotEqualsAccounts(){
		Account actual = new Account("Wallet", new BigDecimal(0.0d));
		em.persist(actual);
		assertNotEquals(fakeAccount, actual);
		
	}
	
	@Test
	public void assertNotEqualsPersistedAndNonPersistedAccount(){
		Account actual = new Account("Wallet", new BigDecimal(0.0d));
		assertNotEquals(actual, fakeAccount);
		assertNotEquals(fakeAccount.hashCode(), actual.hashCode());
	}
	
	@Test
	public void assertNotEqualsString(){
		assertNotEquals(fakeAccount, "");
	}
	
	@Test
	public void assertNotEqualsNull(){
		assertNotEquals(fakeAccount, null);
	}

	@After
	public void tearDown() {
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@AfterClass
	public static void tearDownClass() {
		emf.close();
	}
}
