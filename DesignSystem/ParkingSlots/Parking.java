public class Parking {
	private final char[] ROWS = new char[] { 'A', 'B', 'C' };
	private final int COLUMN_SIZE = 3;
	private final int FREE_ROW_INDEX = 0;
	private final int FREE_COLUMN_INDEX = 1;

	private int[] freeSlot = new int[] { 0, 0 };
	private ParkingSlot[][] parkingSlots;

	public Parking() {
		initialize();
	}

	public void displayParkingSlots() {
		for (int row = 0; row < ROWS.length; row++) {
			for (int column = 0; column < COLUMN_SIZE; column++) {
				if (parkingSlots[row][column].isEmpty()) {
					System.out.print("Free");
				} else {
					System.out.print(parkingSlots[row][column].getNumberPlate());
				}

				if (column != COLUMN_SIZE - 1) {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	public ParkingSlot addCar(String numberPlate) {
		if (freeSlot[FREE_ROW_INDEX] > ROWS.length - 1) {
			System.out.println("No slot available for your car: " + numberPlate);
			return null;
		}
		ParkingSlot parkingSlot = parkingSlots[freeSlot[FREE_ROW_INDEX]][freeSlot[FREE_COLUMN_INDEX]];
		parkingSlot.setNumberPlate(numberPlate);

		updateFreeSlot();

		return parkingSlot;
	}

	public void removeCar(ParkingSlot ticket) {
		int ticketRow = ticket.getRow();
		int ticketColumn = ticket.getColumn();
		parkingSlots[ticketRow][ticketColumn].clearSlot();

		if (ticketRow < freeSlot[FREE_ROW_INDEX] || ticketColumn < freeSlot[FREE_COLUMN_INDEX]) {
			freeSlot[FREE_ROW_INDEX] = ticketRow;
			freeSlot[FREE_COLUMN_INDEX] = ticketColumn;
		}
	}

	private void initialize() {
		parkingSlots = new ParkingSlot[ROWS.length][COLUMN_SIZE];

		for (int row = 0; row < ROWS.length; row++) {
			for (int column = 0; column < COLUMN_SIZE; column++) {
				parkingSlots[row][column] = new ParkingSlot(String.format("%s%d", ROWS[row], column + 1), row, column);
			}
		}
	}

	private void updateFreeSlot() {
		freeSlot[FREE_COLUMN_INDEX]++;

		if (freeSlot[FREE_COLUMN_INDEX] == COLUMN_SIZE) {
			freeSlot[FREE_ROW_INDEX] = freeSlot[FREE_ROW_INDEX] + 1;
			freeSlot[FREE_COLUMN_INDEX] = 0;
		}

		if (freeSlot[FREE_ROW_INDEX] > ROWS.length - 1)
			return;

		if (parkingSlots[freeSlot[FREE_ROW_INDEX]][freeSlot[FREE_COLUMN_INDEX]].hasBooked()) {
			for (int row = freeSlot[FREE_ROW_INDEX]; row < ROWS.length; row++) {
				for (int column = 0; column < COLUMN_SIZE; column++) {
					if (parkingSlots[row][column].isEmpty()) {
						freeSlot[FREE_ROW_INDEX] = row;
						freeSlot[FREE_COLUMN_INDEX] = column;
						return;
					}
				}
			}
			freeSlot[FREE_ROW_INDEX] = ROWS.length;
		}
	}
}
