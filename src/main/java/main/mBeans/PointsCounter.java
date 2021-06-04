package main.mBeans;

import main.models.Point;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

@Component
public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {
    private int allPoints;
    private int outOfArea;
    private int sequenceNumber;

    public void addPoint(Point point) {
        allPoints++;
        if (!point.getHit()) outOfArea++;
        if (allPoints % 10 == 0) {
            sendNotification(new Notification("Notification!", this,
                    sequenceNumber++, "The number of set points is a multiple of 10"));
        }
    }

    @Override
    public int getAllPoints() {
        return allPoints;
    }

    @Override
    public int getOutOfArea() {
        return outOfArea;
    }
}
