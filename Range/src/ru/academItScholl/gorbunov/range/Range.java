package ru.academItScholl.gorbunov.range;

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
        }
        return new Range(Math.max(range.from, this.from), Math.min(range.to, this.to));

    }

    public Range[] getUnionRange(Range range) {
        if (range.to < this.from || range.from > this.to) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }
        return new Range[]{new Range(Math.min(range.from, this.from), Math.max(range.to, this.to))};

    }

    public Range[] getDifference(Range range) {
        if (this.from >= range.to || this.to <= range.from) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (this.from < range.from && this.to > range.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (this.from < range.from) {
            return new Range[]{new Range(this.from, range.from)};
        } else if (this.to > range.to) {
            return new Range[]{new Range(range.to, this.to)};
        } else {
            return new Range[]{};
        }
    }

    public String toString() {
        return (from + " " + to);
    }
}
