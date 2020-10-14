package FrontEnd;

import BackEnd.Shop;
import java.util.Scanner;

/**
 * The front end of the retail store management system.  Note that this app was designed in accordance with
 * Dr. Moshirpour's UML diagram.
 */
public class Menu {

    /**
     * A Scanner object, used for reading user input
     */
    private Scanner scanner;

    /**
     * A Shop object
     */
    private Shop shop;

    public Menu() {
        scanner = new Scanner(System.in);
        shop = new Shop();
    }

    /**
     * The controller of the retail store management system.  Prints a menu, prompts user interaction, and
     * responds accordingly.
     * @param args
     */
    public static void main(String [] args) {
        Menu menu = new Menu();
        Scanner menuScanner = menu.getScanner();
        Shop menuShop = menu.getShop();

        boolean runMenu = true;
        String name = "";
        int id = -1;

        System.out.println("Welcome to your retail store management system!");
        while (runMenu) {
            try{
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
            catch (Exception ex) {
                // Consuming the \n character from the improper selection entry
                menuScanner.nextLine();
                System.out.println("Invalid selection. Please try again.");
            }

        }
    }

    /**
     * Prompts user for a String input, and parses the input
     * @return A String
     */
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

    /**
     * Prompts user for an int input, and parses the input
     * @return A String
     */
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

    /**
     * Calls the Shop object's member function to decrease an Item's quantity
     * @param id An int, the ID of the item to decrease
     */
    private void decreaseItemById(int id) {
        if (id < 0) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.decreaseQuantityById(id);
        }
    }

    /**
     * Calls the Shop object's member function to decrease an Item's quantity
     * @param name A string, the name of the item to decrease
     */
    private void decreaseItemByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.decreaseQuantityByName(name);
        }
    }

    /**
     * Calls the Shop object's member function to retrieve an Item's quantity
     * @param id An int, the ID of the Item to check
     */
    private void checkItemQuantityById(int id) {
        if (id < 0) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.getQuantityById(id);
        }
    }

    /**
     * Calls the Shop object's member function to retrieve an Item's quantity
     * @param name A String, the name of the Item to check
     */
    private void checkItemQuantityByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.getQuantityByName(name);
        }
    }

    /**
     * Calls the Shop object's member function to search for an Item
     * @param name A String, the name of the Item to search for
     */
    private void searchItemsByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.searchItemsByName(name);
        }
    }

    /**
     * Calls the Shop object's member function to search for an Item
     * @param id An int, the ID of the Item to search for
     */
    private void searchItemsById(int id) {
        if (id < 0) {
            System.out.println("Invalid input. Please try again.");
        }
        else {
            shop.searchItemsById(id);
        }
    }

    /**
     * Prints the menu items to the console
     */
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

    /**
     * Retrieves the Menu's Scanner object
     * @return A Scanner object
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Sets the 'scanner' attribute to the parameter
     * @param scanner A Scanner object
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Retrieves the Menu's Shop object
     * @return A Shop object
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * Sets the 'shop' attribute to the parameter
     * @param shop A Shop object
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
