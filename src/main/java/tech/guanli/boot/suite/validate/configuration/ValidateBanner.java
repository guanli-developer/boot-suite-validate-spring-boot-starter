package tech.guanli.boot.suite.validate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ValidateBanner {
	@Autowired
	private ValidateAutoConfigurationProperty property;

	@PostConstruct
	public void init() {
		StringBuilder bannerBuilder = new StringBuilder();
		bannerBuilder.append("__     __    _ _     _       _       \n");
		bannerBuilder.append("\\ \\   / /_ _| (_) __| | __ _| |_ ___ \n");
		bannerBuilder.append(" \\ \\ / / _` | | |/ _` |/ _` | __/ _ \\\n");
		bannerBuilder.append("  \\ V / (_| | | | (_| | (_| | ||  __/\n");
		bannerBuilder.append("   \\_/ \\__,_|_|_|\\__,_|\\__,_|\\__\\___|");
		bannerBuilder.append("Powered by guanli.tech");
		System.out.println(bannerBuilder.toString());
		if (property.getEnableDefaultHandler()) {
			System.out.println("enabled default validate handler");
		} else {
			System.out.println("disabled default validate handler");
		}
	}
}
