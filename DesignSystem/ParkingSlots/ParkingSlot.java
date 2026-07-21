public class ParkingSlot {
	public String slotNumber;
	public String numberPlate;
	public int row;
	public int column;

	public ParkingSlot(String slotNumber, int row, int column) {
		this.slotNumber = slotNumber;
		this.row = row;
		this.column = column;
	}

	public boolean isEmpty() {
		return numberPlate == null;
	}

	public boolean hasBooked() {
		return numberPlate != null;
	}
}
