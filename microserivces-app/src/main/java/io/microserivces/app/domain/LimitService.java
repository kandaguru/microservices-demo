package io.microserivces.app.domain;

public class LimitService {

	private double minimum;
	private double maximum;

	public LimitService(double minimum, double maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public double getMinimum() {
		return minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

}
