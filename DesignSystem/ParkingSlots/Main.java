public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();

        ParkingSlot ticket1 = parking.addCar("NSW-1");
        ParkingSlot ticket2 = parking.addCar("NSW-2");
        ParkingSlot ticket3 = parking.addCar("NSW-3");
        ParkingSlot ticket4 = parking.addCar("NSW-4");
        ParkingSlot ticket5 = parking.addCar("NSW-5");
        ParkingSlot ticket6 = parking.addCar("NSW-6");
        ParkingSlot ticket7 = parking.addCar("NSW-7");
        ParkingSlot ticket8 = parking.addCar("NSW-8");

        parking.displayParkingSlots();
        System.out.println("-----------");

        parking.removeCar(ticket2);
        ParkingSlot ticket9 = parking.addCar("NSW-9");
        ParkingSlot ticket10 = parking.addCar("NSW-10");
        parking.removeCar(ticket4);
        parking.removeCar(ticket7);
        ParkingSlot ticket11 = parking.addCar("NSW-11");
        ParkingSlot ticket12 = parking.addCar("NSW-12");
        ParkingSlot ticket13 = parking.addCar("NSW-13");

        parking.displayParkingSlots();
    }
}