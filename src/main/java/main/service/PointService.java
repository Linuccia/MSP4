package main.service;

import main.mBeans.HitPercentage;
import main.mBeans.PointsCounter;
import main.models.Point;
import main.models.User;
import main.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Collection;

@Service
public class PointService {
    private PointsCounter counter;
    private HitPercentage percentage;

    @Autowired
    private PointRepository pointRepository;

    PointService(PointsCounter counter, HitPercentage percentage) {
        this.counter = counter;
        this.percentage = percentage;
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        try {
            mbs.registerMBean(this.counter, new ObjectName("main.java.mBeans:type=PointsCounter"));
            mbs.registerMBean(this.percentage, new ObjectName("main.java.mBeans:type=HitPercentage"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void countPoints(Point point) {
        counter.addPoint(point);
    }

    public void countPercentage(Point point) {
        percentage.countPercentage(point);
    }

    public Point save(Point point){
        return pointRepository.save(point);
    }

    @Transactional
    public Collection<Point> findByUser(User user){
        return pointRepository.findByUser(user);
    }
}
