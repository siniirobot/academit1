

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

        double[] newLine = {intersectionPointOpen, intersectionPointClose};

        if (intersection) {
            return newLine;
        }else {
            return null;
        }
    }

    public double[] getUnionRange (double firstLineBegan, double firstLineEnd, double secondLineBegan,double secondLineEnd) {

        int firstArrayLength = (int)(firstLineEnd - firstLineBegan);
        double[] firstArray = new double[firstArrayLength];

        int secondArrayLength = (int)(secondLineEnd - secondLineBegan);
        double[] secondArray = new double[secondArrayLength];

        double[] newArray = new double[]
        int arrayCount = 0;

        for (double i = firstLineBegan; i < firstLineEnd; ++i) {
            firstArray[arrayCount] = i;
            arrayCount++;
        }
        arrayCount = 0;
        for (double i = secondLineBegan; i < secondLineEnd; ++i) {
            secondArray[arrayCount] = i;
        }

        for (int i = 0; i < firstArray.length; ++i) {
            for (int j = i; j < secondArray.length; ++j) {
                if (firstArray[i] == secondArray[j]) {

                }
            }
        }
    }
}
