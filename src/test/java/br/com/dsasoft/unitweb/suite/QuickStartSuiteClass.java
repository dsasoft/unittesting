package br.com.dsasoft.unitweb.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.dsasoft.unitweb.config.AppConfigTest;
import br.com.dsasoft.unitweb.jjwt.JSONWebTokenTest;

@RunWith(Suite.class)
@SuiteClasses({ JSONWebTokenTest.class, AppConfigTest.class })
public class QuickStartSuiteClass {

}
