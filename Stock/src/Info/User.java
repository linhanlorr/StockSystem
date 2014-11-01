package Info;

public interface User {
	public abstract String getCardNumber(String IDcard,String BankID);
	public abstract String getPassword(String CardNumber);
	public abstract String getName(String CardNumber);
	public abstract String getIDcard(String CardNumber);
	public abstract String getPhoneNumber(String CardNumber);
	public abstract String getBankID(String CardNumber);
}
