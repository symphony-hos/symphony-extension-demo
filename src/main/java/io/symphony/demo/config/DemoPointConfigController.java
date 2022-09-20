package io.symphony.demo.config;

import io.symphony.extension.config.rest.AbstractPointConfigController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class DemoPointConfigController extends AbstractPointConfigController<DemoPointConfig> {

    public DemoPointConfigController(@Autowired EntityLinks links, @Autowired DemoPointConfigRepo configRepo, @Autowired DemoPointConfigUpdater updateHandler) {
        super(links, configRepo, updateHandler);
    }

}
