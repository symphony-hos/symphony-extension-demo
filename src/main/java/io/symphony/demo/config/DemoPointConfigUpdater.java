package io.symphony.demo.config;

import io.symphony.demo.config.DemoPointConfig;
import io.symphony.extension.config.data.PointConfig;
import io.symphony.extension.config.rest.PointConfigUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DemoPointConfigUpdater implements PointConfigUpdater {

    @Override
    public void updateNonNull(PointConfig from, PointConfig to) {
        if (from instanceof DemoPointConfig && to instanceof DemoPointConfig)
            updateNonNull((DemoPointConfig) from, (DemoPointConfig) to);
    }

    private void updateNonNull(DemoPointConfig from, DemoPointConfig to) {
        if (from.getName() != null)
            to.setName(from.getName());
    }

    @Override
    public void updateAll(PointConfig from, PointConfig to) {
        if (from instanceof DemoPointConfig && to instanceof DemoPointConfig)
            updateAll((DemoPointConfig) from, (DemoPointConfig) to);
    }

    private void updateAll(DemoPointConfig from, DemoPointConfig to) {
        to.setName(from.getName());
    }

}
