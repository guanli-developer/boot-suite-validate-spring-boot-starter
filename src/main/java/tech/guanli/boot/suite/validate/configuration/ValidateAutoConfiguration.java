package tech.guanli.boot.suite.validate.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import tech.guanli.boot.suite.validate.Package;

@AutoConfiguration
@ComponentScan(basePackageClasses = { Package.class })
@EnableConfigurationProperties({ ValidateAutoConfigurationProperty.class })
public class ValidateAutoConfiguration {

}
