public class ParkingSlot {
	private String slotNumber;
	private String numberPlate;
	private int row;
	private int column;

	public ParkingSlot(String slotNumber, int row, int column) {
		this.slotNumber = slotNumber;
		this.row = row;
		this.column = column;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean isEmpty() {
		return numberPlate == null;
	}

	public boolean hasBooked() {
		return numberPlate != null;
	}

	public void clearSlot() {
		numberPlate = null;
	}
}
