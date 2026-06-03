class Main {
  public static void main(String[] args){
    ScannerUtils scanner = new ScannerUtils();
    new UserManagementSystem(scanner).run();
    scanner.close();
  }
}
