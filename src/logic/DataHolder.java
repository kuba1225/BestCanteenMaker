package logic;

import javax.swing.JLabel;

public class DataHolder {

	private Double wallA;
	private Double wallB;
	private Double wallC;
	private Double wallD;
	private Double wallE;
	private Double wallF;

	private Double budget;
	private Integer capacity;
	private Integer iterations;
	private Integer iterationsSpeed;
	private Integer numberOfIndividualsInGeneration;
	private Double hybrydizationFactor;
	private Double mutationFactor;

	public Double getWallA() {
		return wallA;
	}

	public void setWallA(Double wallA) {
		this.wallA = wallA;
	}

	public Double getWallB() {
		return wallB;
	}

	public void setWallB(Double wallB) {
		this.wallB = wallB;
	}

	public Double getWallC() {
		return wallC;
	}

	public void setWallC(Double wallC) {
		this.wallC = wallC;
	}

	public Double getWallD() {
		return wallD;
	}

	public void setWallD(Double wallD) {
		this.wallD = wallD;
	}

	public Double getWallE() {
		return wallE;
	}

	public void setWallE(Double wallE) {
		this.wallE = wallE;
	}

	public Double getWallF() {
		return wallF;
	}

	public void setWallF(Double wallF) {
		this.wallF = wallF;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(Integer iterations) {
		this.iterations = iterations;
	}

	public Integer getIterationsSpeed() {
		return iterationsSpeed;
	}

	public void setIterationsSpeed(Integer iterationsSpeed) {
		this.iterationsSpeed = iterationsSpeed;
	}

	public Integer getNumberOfIndividualsInGeneration() {
		return numberOfIndividualsInGeneration;
	}

	public void setNumberOfIndividualsInGeneration(Integer numberOfIndividualsInGeneration) {
		this.numberOfIndividualsInGeneration = numberOfIndividualsInGeneration;
	}

	public Double getHybrydizationFactor() {
		return hybrydizationFactor;
	}

	public void setHybrydizationFactor(Double hybrydizationFactor) {
		this.hybrydizationFactor = hybrydizationFactor;
	}

	public Double getMutationFactor() {
		return mutationFactor;
	}

	public void setMutationFactor(Double mutationFactor) {
		this.mutationFactor = mutationFactor;
	}

	@Override
	public String toString() {
		return "DataHolder [wallA=" + wallA + ", wallB=" + wallB + ", wallC=" + wallC + ", wallD=" + wallD + ", wallE="
				+ wallE + ", wallF=" + wallF + ", budget=" + budget + ", capacity=" + capacity + ", iterations="
				+ iterations + ", iterationsSpeed=" + iterationsSpeed + ", numberOfIndividualsInGeneration="
				+ numberOfIndividualsInGeneration + ", hybrydizationFactor=" + hybrydizationFactor + ", mutationFactor="
				+ mutationFactor + "]";
	}

}
