import java.util.Scanner;

import resource.Menu;
import service.AccountAndInformationService;
import service.OrderService;
import service.ProductService;

public class Main {
    static int customerSelection;
    static boolean loginSuccess = true;

    public static void intFunction(Menu menu) {
        customerSelection = 0;
        while (customerSelection != 1 && customerSelection != 2 && customerSelection != 3 && customerSelection != 4) {
            try {
                System.out.print(menu.menu(0));
                customerSelection = new Scanner(System.in).nextInt();
                loginSuccess = true;
            } catch (Exception e) {
                System.out.println("Input must be a number between 1 and 4\n");
            }
        }
    }

    public static void main(String[] args) {
        AccountAndInformationService accountAndInformationService = new AccountAndInformationService();
        accountAndInformationService.autoGenerateAccountAdmin();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        intFunction(menu);

        int choice;
        while (true) {
            switch (customerSelection) {
                case 1 -> {
                    System.out.print(menu.menu(1));
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Your choice: 1. Register to become a member");
                            accountAndInformationService.register();
                        }
                        case 2 -> {
                            System.out.println("Your choice: 2. View your information");
                            accountAndInformationService.viewInformation();
                        }
                        case 3 -> {
                            System.out.println("Your choice: 3. View all products");
                            productService.getProducts();
                        }
                        case 4 -> {
                            System.out.println("Your choice: 4. View product details");
                            productService.getProductsDetail();
                        }
                        case 5 -> {
                            System.out.println("Your choice: 5. Search all available products");
                            productService.getAvailableProduct();
                        }
                        case 6 -> {
                            System.out.println("Your choice: 6. Sort all products by price");
                            productService.getProductSortByPrice();
                        }
                        case 0 -> intFunction(menu);
                    }
                }
                case 2 -> {
                    if (loginSuccess) {
                        accountAndInformationService.login(1);
                        loginSuccess = false;
                    }
                    System.out.print(menu.menu(2));
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Your choice: 1. View your information");
                            accountAndInformationService.viewInformation();
                        }
                        case 2 -> {
                            System.out.println("Your choice: 2. View all products");
                            productService.getProducts();
                        }
                        case 3 -> {
                            System.out.println("Your choice: 3. View product details");
                            productService.getProductsDetail();
                        }
                        case 4 -> {
                            System.out.println("Your choice: 4. Search all available products");
                            productService.getAvailableProduct();
                        }
                        case 5 -> {
                            System.out.println("Your choice: 5. Sort all products by price");
                            productService.getProductSortByPrice();
                        }
                        case 6 -> {
                            System.out.println("Your choice: 6. Create an Order");
                            orderService.order();
                        }
                        case 7 -> {
                            System.out.println("Your choice: 7. List all your Orders");
                            orderService.listOrder();
                        }
                        case 0 -> intFunction(menu);
                    }
                }
                case 3 -> {
                    if (loginSuccess) {
                        accountAndInformationService.login(0);
                        loginSuccess = false;
                    }
                    System.out.print(menu.menu(3));
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Your choice: 1. View your information");
                            accountAndInformationService.viewInformation();
                        }
                        case 2 -> {
                            System.out.println("Your choice: 2. View all products");
                            productService.getProducts();
                        }
                        case 3 -> {
                            System.out.println("Your choice: 3. View product details");
                            productService.getProductsDetail();
                        }
                        case 4 -> {
                            System.out.println("Your choice: 4. View all orders");
                            orderService.listOrderAdmin();
                        }
                        case 5 -> {
                            System.out.println("Your choice: 5. View all members");
                            accountAndInformationService.getMembers();
                        }
                        case 6 -> {
                            System.out.println("Your choice: 6. Add new Products");
                            productService.addProduct();
                        }
                        case 7 -> {
                            System.out.println("Your choice: 7. Remove products");
                            productService.removeProduct();
                        }
                        case 8 -> {
                            System.out.println("Your choice: 8. Update product prices");
                            productService.updatePrice();
                        }
                        case 9 -> {
                            System.out.println("Your choice: 9. Get orders by a member's ID");
                            orderService.listOrderByMemberID();
                        }
                        case 10 -> {
                            System.out.println("Your choice: 10. Change orders' status");
                            orderService.changeOrderStatus();
                        }
                        case 0 -> intFunction(menu);
                    }
                }
                case 4 -> {
                    System.out.println("\nThank you for visiting our store!");
                    System.exit(0);
                }
            }
        }
    }
}