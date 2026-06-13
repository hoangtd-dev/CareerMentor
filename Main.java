import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 = ANZ\n2 = NAB");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                ANZCard card = new ANZCard();
                card.showCardInfo();
            }
            case 2 -> {
                NABCard card = new NABCard();
                card.showCardInfo();
            }
            default -> System.out.println(" ...");
        }
    }
    
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 = ANZ\n2 = NAB");
        int option = scanner.nextInt();

        BaseCard card = switch (option) {
            case 1 ->new ANZCard();
            case 2 -> new NABCard();
            default -> null;
        };
        
        card.showCardInfo();
    }
}