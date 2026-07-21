public class Main {
    public static final char[] ROWS = new char[] { 'A', 'B', 'C', 'D' };
    public static final int COLUMN_SIZE = 5;

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
        displayParkingSlots();
        System.out.println("-----------");

        ParkingSlot ticket9 = addCar("NSW-9");
        ParkingSlot ticket10 = addCar("NSW-10");
        displayParkingSlots();
    }

    public static ParkingSlot[][] initialize() {
        ParkingSlot[][] parkingSlots = new ParkingSlot[ROWS.length][COLUMN_SIZE];

        for (int row = 0; row < ROWS.length; row++) {
            for (int column = 0; column < COLUMN_SIZE; column++) {
                parkingSlots[row][column] = new ParkingSlot(
                        String.format("%s%d", ROWS[row], column + 1),
                        row,
                        column);
            }
        }

        return parkingSlots;
    }

    public static void displayParkingSlots() {
        for (int row = 0; row < ROWS.length; row++) {
            for (int column = 0; column < COLUMN_SIZE; column++) {
                if (parkingSlots[row][column].numberPlate == null) {
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
        if (freeSlot[0] > ROWS.length - 1) {
            System.out.println("No slot available !!!");
            return null;
        }
        ParkingSlot parkingSlot = parkingSlots[freeSlot[0]][freeSlot[1]];
        parkingSlot.numberPlate = numberPlate;
        freeSlot[1]++;

        if (freeSlot[1] == COLUMN_SIZE) {
            freeSlot[0] = freeSlot[0] + 1;
            freeSlot[1] = 0;
        }

        return parkingSlot;
    }

    public static void removeCar(ParkingSlot ticket) {
        parkingSlots[ticket.row][ticket.column].numberPlate = null;

        if (ticket.row < freeSlot[0] || ticket.column < freeSlot[1]) {
            freeSlot[0] = ticket.row;
            freeSlot[1] = ticket.column;
        }
    }
}