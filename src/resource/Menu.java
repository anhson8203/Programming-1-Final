package resource;

public class Menu {
    public String menu(int menu) {
        String menuContent = "";

        switch (menu) {
            case 0 -> menuContent = """
                    1. Customer
                    2. Member
                    3. Admin
                    4. Exit
                    """;
            case 1 -> menuContent = """
                    1. Register to become a member
                    2. View your information
                    3. View all products
                    4. View product details
                    5. Search all available products
                    6. Sort all products by price
                    0. Back
                    """;
            case 2 -> menuContent = """
                    1. View your information
                    2. View all products
                    3. View product details
                    4. Search all available products
                    5. Sort all products by price
                    6. Create an Order
                    7. List all your Orders
                    0. Back
                    """;
            case 3 -> menuContent = """
                    1. View your information
                    2. View all products
                    3. View product details
                    4. View all orders
                    5. View all members
                    6. Add new Products
                    7. Remove products
                    8. Update product prices
                    9. Get orders by a member's ID
                    10. Change orders' status
                    0. Back
                    """;
            case 4 -> System.exit(0);
        }
        return menuContent + "\nEnter your choice: ";
    }
}