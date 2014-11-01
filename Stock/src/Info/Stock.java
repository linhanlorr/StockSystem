package Info;

public interface Stock {
	public abstract String getCtockName(String CardNumber);
	public abstract String getCtockSymbol(String CardNumber);
	public abstract int getCtockCount(String CardNumber);
	public abstract double getCtockPrice(String CardNumber);
	public abstract double getCtockHoldingCost(String CardNumber);
	public abstract double getCtockProfit(String CardNumber);
}
