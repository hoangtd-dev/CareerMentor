class Main {
  public static void main(String[] args){
    ScannerUtils scanner = new ScannerUtils();
    UserManagementSystem system = new UserManagementSystem(scanner);
    system.run();
    scanner.close();
  }
}
