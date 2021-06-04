package main.mBeans;

import main.models.Point;
import org.springframework.stereotype.Component;

@Component
public class HitPercentage implements HitPercentageMBean{
    private double percent;
    private int allPoints;
    private int inArea;

    public void countPercentage(Point point) {
        allPoints++;
        if (point.getHit()) inArea++;
        if (allPoints != 0) percent = inArea/allPoints * 100;
        else percent = 0.0;
    }

    @Override
    public double getPercent() {
        return percent;
    }
}
