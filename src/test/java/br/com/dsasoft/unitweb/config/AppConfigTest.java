package br.com.dsasoft.unitweb.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AppConfigTest {

	@Autowired
	private AppConfig appConfig;

	private static final String APP_VERSION = "1.0.0";

	private static final String APP_NAME = "Quick start analysis";

	@Test
	public void assertAppVersion() {
		System.out.println(appConfig.getAppVersion());

		assertEquals(appConfig.getAppVersion(), APP_VERSION);
	}

	@Test
	public void assertAppName() {
		System.out.println(appConfig.getAppName());

		assertEquals(appConfig.getAppName(), APP_NAME);
	}
}
