package FrontEnd;

import BackEnd.Order;
import BackEnd.Shop;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Shop shop;

    public Menu() {
        scanner = new Scanner(System.in);
        shop = new Shop();
    }


    public static void main(String [] args) {
        System.out.println("Hello");

        Menu menu = new Menu();

        Scanner menuScanner = menu.getScanner();
        Shop menuShop = menu.getShop();

        System.out.println("Welcome to your retail store management system!");

        boolean runMenu = true;
        String name = "";
        int id = -1;

        while (runMenu) {
             displayMenuItems();

            int selection = menuScanner.nextInt();

            // Consuming the \n character from the selection entry
            menuScanner.nextLine();

            switch (selection) {
                case 1:
                    menuShop.listItems();
                    break;
                case 2:
                    name = menu.getNameInput();
                    menu.searchItemsByName(name);
                    break;
                case 3:
                    id = menu.getIdInput();
                    if (id > 0) {
                        menu.searchItemsById(id);
                    }
                    break;
                case 4:
                    name = menu.getNameInput();
                    menu.checkItemQuantityByName(name);
                    break;
                case 5:
                    id = menu.getIdInput();
                    if (id > 0) {
                        menu.checkItemQuantityById(id);
                    }
                    break;
                case 6:
                    name = menu.getNameInput();
                    menu.decreaseItemByName(name);
                    break;
                case 7:
                    id = menu.getIdInput();
                    if (id > 0) {
                        menu.decreaseItemById(id);
                    }
                    break;
                case 8:
                    menuShop.printOrder();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    runMenu = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private String getNameInput() {
        System.out.println("Please enter a tool name.");

        boolean validInput = false;

        while (!validInput) {
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Invalid input. Please try again or type q to make another menu selection.");
            }
            else {
                if (name.toLowerCase().equals("q")) {
                    return null;
                }
                return name;
            }
        }
        return null;
    }

    private int getIdInput() {
        System.out.println("Please enter a tool ID.");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Invalid input. Please try again or type q to make another menu selection.");
            }
            else {
                if (input.toLowerCase().equals("q")) {
                    return -1;
                }
                else {
                    try {
                        int id = Integer.parseInt(input);
                        return id;
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Invalid input. Please try again or type q to make another menu selection.");
                    }
                }
            }
        }
    }

    private void decreaseItemById(int id) {
        if (id < 0) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.decreaseQuantityById(id);
        }
    }

    private void decreaseItemByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.decreaseQuantityByName(name);
        }
    }

    private void checkItemQuantityById(int id) {
        if (id < 0) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.getQuantityById(id);
        }
    }

    private void checkItemQuantityByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.getQuantityByName(name);
        }
    }

    private void searchItemsByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.searchItemsByName(name);
        }
    }

    private void searchItemsById(int id) {
        if (id < 0) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.searchItemsById(id);
        }
    }

    private static void displayMenuItems() {
        System.out.println("Please select from the following menu items:");
        System.out.println("  1) List all tools in the inventory");
        System.out.println("  2) Search for tool by name");
        System.out.println("  3) Search for tool by ID");
        System.out.println("  4) Check item quantity by name");
        System.out.println("  5) Check item quantity by ID");
        System.out.println("  6) Decrease item quantity by name");
        System.out.println("  7) Decrease item quantity by ID");
        System.out.println("  8) Print order");
        System.out.println("  9) Quit");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
