package main.mBeans;

import main.models.Point;
import org.springframework.stereotype.Component;

@Component
public class HitPercentage implements HitPercentageMBean{
    private int percent;
    private int allPoints;
    private int inArea;

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
