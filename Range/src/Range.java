import java.util.ArrayList;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return this.from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return this.to - this.from;
    }

    public boolean isInRange(double tryNumber) {
        return from <= tryNumber && tryNumber <= to;
    }

    public double[] getNewRange (double firstLineBegan, double firstLineEnd, double secondLineBegan,double secondLineEnd) {

        boolean intersection = false;
        double intersectionPointOpen = 0;
        double intersectionPointClose = 0;

        for (double i = firstLineBegan; i <= firstLineEnd; ++i) {
            for (double j = secondLineBegan; j <= secondLineEnd; ++j) {
                if (!intersection) {
                    intersectionPointOpen = j;
                }
                if (i == j) {
                    intersection = true;
                    intersectionPointClose = j;
                    break;
                }
            }
        }

        if (intersection) {
            return new double[] {intersectionPointOpen, intersectionPointClose};
        }else {
            return null;
        }
    }

    public double[] getUnionRange (double firstLineBegan, double firstLineEnd, double secondLineBegan,double secondLineEnd) {

        for (double i = firstLineBegan; i <= firstLineEnd; ++i) {
            if (i == secondLineBegan){
                return new double[] {secondLineBegan,secondLineEnd};
            }
        }
        return new double[] {firstLineBegan,firstLineEnd,secondLineBegan,secondLineEnd};
    }
}
