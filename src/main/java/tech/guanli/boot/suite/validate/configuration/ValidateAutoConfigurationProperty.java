package tech.guanli.boot.suite.validate.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "tech.guanli.boot.validate")
public class ValidateAutoConfigurationProperty {

	private Boolean enableDefaultHandler = true;

}
