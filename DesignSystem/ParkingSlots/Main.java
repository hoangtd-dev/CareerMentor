public class Main {
    public static final char[] ROWS = new char[] { 'A', 'B', 'C' };
    public static final int COLUMN_SIZE = 3;
    public static final int FREE_ROW_INDEX = 0;
    public static final int FREE_COLUMN_INDEX = 1;

    public static int[] freeSlot = new int[] { 0, 0 };
    public static ParkingSlot[][] parkingSlots;

    public static void main(String[] args) {
        parkingSlots = initialize();

        ParkingSlot ticket1 = addCar("NSW-1");
        ParkingSlot ticket2 = addCar("NSW-2");
        ParkingSlot ticket3 = addCar("NSW-3");
        ParkingSlot ticket4 = addCar("NSW-4");
        ParkingSlot ticket5 = addCar("NSW-5");
        ParkingSlot ticket6 = addCar("NSW-6");
        ParkingSlot ticket7 = addCar("NSW-7");
        ParkingSlot ticket8 = addCar("NSW-8");

        displayParkingSlots();
        System.out.println("-----------");

        removeCar(ticket2);
        ParkingSlot ticket9 = addCar("NSW-9");
        ParkingSlot ticket10 = addCar("NSW-10");
        removeCar(ticket4);
        removeCar(ticket7);
        ParkingSlot ticket11 = addCar("NSW-11");
        ParkingSlot ticket12 = addCar("NSW-12");
        ParkingSlot ticket13 = addCar("NSW-13");

        displayParkingSlots();
    }

    public static ParkingSlot[][] initialize() {
        ParkingSlot[][] parkingSlots = new ParkingSlot[ROWS.length][COLUMN_SIZE];

        for (int row = 0; row < ROWS.length; row++) {
            for (int column = 0; column < COLUMN_SIZE; column++) {
                parkingSlots[row][column] = new ParkingSlot(String.format("%s%d", ROWS[row], column + 1), row, column);
            }
        }

        return parkingSlots;
    }

    public static void displayParkingSlots() {
        for (int row = 0; row < ROWS.length; row++) {
            for (int column = 0; column < COLUMN_SIZE; column++) {
                if (parkingSlots[row][column].isEmpty()) {
                    System.out.print("Free");
                } else {
                    System.out.print(parkingSlots[row][column].numberPlate);
                }

                if (column != COLUMN_SIZE - 1) {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public static ParkingSlot addCar(String numberPlate) {
        if (freeSlot[FREE_ROW_INDEX] > ROWS.length - 1) {
            System.out.println("No slot available for your car: " + numberPlate);
            return null;
        }
        ParkingSlot parkingSlot = parkingSlots[freeSlot[FREE_ROW_INDEX]][freeSlot[FREE_COLUMN_INDEX]];
        parkingSlot.numberPlate = numberPlate;

        updateFreeSlot();

        return parkingSlot;
    }

    private static void updateFreeSlot() {
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

    public static void removeCar(ParkingSlot ticket) {
        parkingSlots[ticket.row][ticket.column].clearSlot();

        if (ticket.row < freeSlot[FREE_ROW_INDEX] || ticket.column < freeSlot[FREE_COLUMN_INDEX]) {
            freeSlot[FREE_ROW_INDEX] = ticket.row;
            freeSlot[FREE_COLUMN_INDEX] = ticket.column;
        }
    }
}