package br.com.dsasoft.unitweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = { "br.com.dsasoft.unitweb.config" })
@PropertySource(value = "classpath:app.config.properties")
public class AppConfig {

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.name}")
	private String appName;

	public String getAppVersion() {
		return appVersion;
	}

	public String getAppName() {
		return appName;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
