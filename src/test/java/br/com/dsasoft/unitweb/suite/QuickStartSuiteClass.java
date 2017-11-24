package br.com.dsasoft.unitweb.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.ContextConfiguration;

import br.com.dsasoft.unitweb.config.AppConfig;
import br.com.dsasoft.unitweb.config.AppConfigTest;
import br.com.dsasoft.unitweb.jjwt.JSONWebTokenTest;

@RunWith(Suite.class)
@ContextConfiguration(classes = { AppConfig.class })
@SuiteClasses({ JSONWebTokenTest.class, AppConfigTest.class })
public class QuickStartSuiteClass {

}
