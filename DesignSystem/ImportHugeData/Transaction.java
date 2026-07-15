public class Transaction {
	private int transactionId;
	private String type;
	private double amount;

	public int getTransactionId() {
		return transactionId;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s", transactionId, type, amount);
	}
}
