package opr.shared;

import java.io.Serializable;

public class UnitDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2846969203314216759L;
	
	private double value;
	private double weightPerUnit;
	private double tolerance;
	
	public UnitDTO() {
		
	}
	
	public UnitDTO(double weightPerUnit, double tolerance) {
		this.weightPerUnit = weightPerUnit;
		this.tolerance = tolerance;
	}

	public double getWeightPerUnit() {
		return weightPerUnit;
	}

	public void setWeightPerUnit(int weightPerUnit) {
		this.weightPerUnit = weightPerUnit;
	}

	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}
	
}
