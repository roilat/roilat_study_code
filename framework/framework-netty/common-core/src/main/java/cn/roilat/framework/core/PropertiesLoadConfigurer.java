package cn.roilat.framework.core;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class PropertiesLoadConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
	}
	
}
