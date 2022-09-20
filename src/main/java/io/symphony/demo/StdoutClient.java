package io.symphony.demo;

import io.symphony.common.point.data.Point;
import io.symphony.extension.point.data.PointRepo;
import io.symphony.extension.sync.System2PointSynchronizer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StdoutClient implements CommandLineRunner {

    private final System2PointSynchronizer syncer;

    private final PointRepo repo;

    private final Pattern pattern = Pattern.compile("(\\w+): (.+)");

    public void send(Point point) {
        System.out.println(point.getId() + ": " + point.getValueAsString());
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
            handleLine(scanner.nextLine());
    }

    private void handleLine(String line) {
        System.err.println("Line: " + line);
        Matcher m = pattern.matcher(line);
        if (m.matches()) {
            String pointId = m.group(1);
            String valueStr = m.group(2).trim();
            Optional<Point> pointOpt = repo.findById(pointId);
            if (pointOpt.isPresent()) {
                Point point = pointOpt.get();
                if (valueStr != null && valueStr.length() > 0) {
                    try {
                        point.setValueAsString(valueStr);
                        syncer.toPoint(point);
                        System.err.println("Success.");
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                }
            } else {
                System.err.println("No such point with ID " + pointId);
            }
        } else {
            System.err.println("Invalid command: " + line);
        }
    }

}
