package io.symphony.demo.properties;

import io.symphony.demo.config.DemoPointConfig;
import io.symphony.extension.config.data.PointConfig;
import io.symphony.extension.properties.PointProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DemoPointProperties extends PointProperties {

	private String name;

	@Override
	public PointConfig toPointConfig() {
		return DemoPointConfig.builder()
			.id(getId())
			.name(getName())
			.build();
	}

}
