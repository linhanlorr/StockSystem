package Info;

public interface Fund {
	public abstract String getAvailableFund(String CardNumber);
	public abstract String getBlockedFund(String CardNumber);
}
