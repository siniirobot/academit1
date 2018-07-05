package Range.ru.FilesForFindRange;

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

    public double[] getNewRange(double secondLineBegan, double secondLineEnd) {

        if (secondLineEnd <= this.from || secondLineBegan >= this.to) {
            return null;
        } else {
            if (secondLineBegan >= this.from && secondLineBegan <= this.to) {
                if (secondLineEnd < this.to) {
                    return new double[]{secondLineBegan, secondLineEnd};
                } else {
                    return new double[]{secondLineBegan, this.to};
                }
            } else {
                if (secondLineEnd < this.to) {
                    return new double[]{this.from, secondLineEnd};
                } else {
                    return new double[]{this.from, this.to};
                }
            }
        }
    }

    public double[] getUnionRange(double secondLineBegan, double secondLineEnd) {

        if (secondLineEnd < this.from || secondLineBegan > this.to) {
            return new double[]{this.from, this.to, secondLineBegan, secondLineEnd};
        } else {
            if (secondLineBegan >= this.from && secondLineBegan <= this.to) {
                if (secondLineEnd < this.to) {
                    return new double[]{this.from, this.to};
                } else {
                    return new double[]{this.from, secondLineEnd};
                }
            } else {
                if (secondLineEnd < this.to) {
                    return new double[]{secondLineBegan, this.to};
                } else {
                    return new double[]{secondLineBegan, secondLineEnd};
                }
            }
        }
    }

    public double[] getDifference(double secondLineBegan, double secondLineEnd) {

        if (secondLineEnd < this.from || secondLineBegan > this.to) {
            return new double[]{this.from, this.to};
        } else {
            if (secondLineBegan > this.from && secondLineBegan < this.to) {
                if (secondLineEnd < this.to) {
                    return new double[]{this.from, secondLineBegan, secondLineEnd, this.to};
                } else {
                    return new double[]{this.from, secondLineBegan};
                }
            } else {
                if (secondLineEnd < this.to) {
                    return new double[]{secondLineEnd, this.to};
                } else {
                    return new double[]{};
                }
            }
        }
    }
}
