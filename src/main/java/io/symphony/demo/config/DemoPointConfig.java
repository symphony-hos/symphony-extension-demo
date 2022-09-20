package io.symphony.demo.config;


import io.symphony.extension.config.data.PointConfig;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class DemoPointConfig extends PointConfig {

    private String name;

}
