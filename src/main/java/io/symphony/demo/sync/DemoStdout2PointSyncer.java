package io.symphony.demo.sync;

import io.symphony.common.point.data.Point;
import io.symphony.extension.event.PointPublisher;
import io.symphony.extension.point.data.PointRepo;
import io.symphony.extension.sync.System2PointSynchronizer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DemoStdout2PointSyncer implements System2PointSynchronizer {

    private final PointRepo repo;

    private final PointPublisher publisher;

    @Override
    public void toPoint(Point point) {
        publisher.publish(repo.save(point));
    }

}
