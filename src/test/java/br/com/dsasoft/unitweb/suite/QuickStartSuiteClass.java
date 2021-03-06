package br.com.dsasoft.unitweb.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.dsasoft.unitweb.config.AppConfigTest;
import br.com.dsasoft.unitweb.jjwt.JSONWebTokenTest;
import br.com.dsasoft.unitweb.jpa.AccountTest;

@RunWith(Suite.class)
@SuiteClasses({ JSONWebTokenTest.class, AppConfigTest.class, AccountTest.class })
public class QuickStartSuiteClass {

}
