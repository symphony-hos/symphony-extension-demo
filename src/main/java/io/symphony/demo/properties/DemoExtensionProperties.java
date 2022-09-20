package io.symphony.demo.properties;

import io.symphony.extension.properties.ExtensionProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "symphony.demo")
public class DemoExtensionProperties extends ExtensionProperties<DemoPointProperties> {

}
