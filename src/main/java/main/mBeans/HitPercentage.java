package main.mBeans;

import main.models.Point;
import org.springframework.stereotype.Component;

@Component
public class HitPercentage implements HitPercentageMBean{
    private double percent;
    private double allPoints;
    private double inArea;

    public void countPercentage(Point point) {
        allPoints++;
        if (point.getHit()) inArea++;
        percent = inArea/allPoints * 100;
    }

    @Override
    public double getPercent() {
        return percent;
    }
}
