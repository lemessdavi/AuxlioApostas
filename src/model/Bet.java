package model;

public class Bet {
	private int id;
	private double odd;
	private double stake;
	private double lucro;
	private boolean green;
	private Casa casa;
	
	public Bet(double odd, double stake, boolean green, double lucro, Casa casa) {
		this.odd = odd;
		this.stake = stake;
		this.green = green;
		this.lucro = lucro;
		this.casa = casa;
		casa.addBet(this);
		
		
	}
	
	public void setId(int id) {
		this.id = id;
	};
	
	public double getLucro() {
		return lucro;
	}
	public double getOdd() {
		return odd;
	}
	public double getStake() {
		return stake;
	}
	
	public boolean getGreen() {
		return green;
	}
}
