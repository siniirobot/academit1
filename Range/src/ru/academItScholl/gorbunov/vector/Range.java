package ru.academItScholl.gorbunov.vector;

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

    public Range intersection(Range range) {
        if (range.to < this.from || range.from > this.to) {
            return null;
        } else {
            if (range.from > this.from && range.from < this.to) {
                if (range.to < this.to) {
                    return new Range(range.from, range.to);
                } else {
                    return new Range(range.from, this.to);
                }
            } else {
                if (range.to < this.to) {
                    return new Range(this.from, range.to);
                } else {
                    return new Range(this.from, this.to);
                }
            }
        }
    }

    public Range[] getUnionRange(Range range) {
        if (range.to < this.from || range.from > this.to) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        } else {
            if (range.from > this.from && range.from < this.to) {
                if (range.to < this.to) {
                    return new Range[]{new Range(this.from, this.to)};
                } else {
                    return new Range[]{new Range(this.from, range.to)};
                }
            } else {
                if (range.to < this.to) {
                    return new Range[]{new Range(range.from, this.to)};
                } else {
                    return new Range[]{new Range(range.from, range.to)};
                }
            }
        }
    }

    public Range[] getDifference(Range range) {
        if (range.to <= this.from || range.from >= this.to) {
            return new Range[]{new Range(this.from, this.to)};
        } else {
            if (range.from > this.from && range.from < this.to) {
                if (range.to < this.to) {
                    return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
                } else {
                    return new Range[]{new Range(this.from, range.from)};
                }
            } else {
                if (range.to < this.to) {
                    return new Range[]{new Range(range.to, this.to)};
                } else {
                    return new Range[]{};
                }
            }
        }
    }

    public String toString() {
        return (from + " " + to);
    }
}
