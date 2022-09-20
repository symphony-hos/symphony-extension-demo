package io.symphony.demo.sync;

import io.symphony.common.point.data.Point;
import io.symphony.demo.StdoutClient;
import io.symphony.extension.point.data.PointRepo;
import io.symphony.extension.sync.Point2SystemSynchronizer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DemoPoint2StdoutSyncer implements Point2SystemSynchronizer {

    private final PointRepo repo;

    private final StdoutClient client;

    @Override
    public void toSystem(Point point) {
        client.send(point);
        repo.save(point);
    }

}
