package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

import model.MessageAndPriceOrderProduct;
import model.Product;

public class ProductService {
    FileService fileService = new FileService();

    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        String add = "y";
        String name;
        double price;
        String detail;
        int amount;

        while (add.equals("y") || add.equals("yes")) {
            System.out.print("Enter product name: ");
            name = sc.nextLine();
            System.out.print("Enter price: $");
            price = new Scanner(System.in).nextDouble();
            System.out.print("Enter category: ");
            detail = sc.nextLine();
            System.out.print("Enter quantity: ");
            amount = new Scanner(System.in).nextInt();

            UUID uuid = UUID.randomUUID();
            Product product = new Product(uuid.toString(), name, price, amount, detail);

            String filepath = "src\\data\\Products.txt";
            List<Product> products = (List<Product>) fileService.readFile(filepath);
            if (products == null) {
                products = new ArrayList<>();
                products.add(product);
                fileService.writeFile(filepath, products);
            } else {
                List<Product> productsR = (List<Product>) fileService.readFile(filepath);
                productsR.add(product);
                fileService.writeFile(filepath, productsR);
            }
            System.out.println("\nProduct added");
            System.out.print("Do you have another product to add ? Y/N: ");
            add = sc.nextLine().toLowerCase();
            System.out.println();
        }
    }

    public void getProducts() {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);

        if (productsR != null) {
            System.out.println();
            for (Product product : productsR) {
                System.out.println(product.toStringProduct());
            }
        } else {
            System.out.println("No product available");
        }
        System.out.println();
    }

    public void getProductsDetail() {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);
        if (productsR != null) {
            System.out.print("Enter product ID: ");
            String id = new Scanner(System.in).nextLine();
            for (Product product : productsR) {
                if (id.equals(product.getId())) {
                    System.out.println(product);
                }
            }
            System.out.println();
        } else {
            System.out.println("No product available\n");
        }
    }

    public void getAvailableProduct() {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);
        if (productsR != null) {
            System.out.print("Enter product ID: ");
            String id = new Scanner(System.in).nextLine();
            for (Product product : productsR) {
                if (id.equals(product.getId())) {
                    System.out.println("Product: " + product.getName() + "\t" + (product.getAmount() > 0 ? "Available" : "Unavailable"));
                } else {
                    System.out.println("No product with such ID\n");
                }
            }
        } else {
            System.out.println("No product available\n");
        }
    }

    public void getProductSortByPrice() {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);
        if (productsR != null) {
            productsR.sort(Comparator.comparing(Product::getPrice));
            System.out.println();
            for (Product product : productsR) {
                System.out.println(product.toStringProduct());
            }
            System.out.println();
        } else {
            System.out.println("No product available\n");
        }
    }

    public MessageAndPriceOrderProduct checkProductToOrder(String id, int orderQuantity) {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);
        MessageAndPriceOrderProduct messageAndPriceOrderProduct = new MessageAndPriceOrderProduct();
        String message = "Product does not exist";
        Double price = (double) 0;
        if (productsR != null) {
            for (Product product : productsR) {
                if (id.equals(product.getId())) {
                    if (product.getAmount() < orderQuantity) {
                        message = "The store only has " + product.getAmount() + " products left";
                    } else {
                        message = "Order Successful";
                        product.setAmount(product.getAmount() - orderQuantity);
                        price = product.getPrice();
                    }
                    break;
                }
            }
            if (message.equals("Order Successful")) {
                fileService.writeFile(filepath, productsR);
            }
        }
        messageAndPriceOrderProduct.setMessage(message);
        messageAndPriceOrderProduct.setPrice(price);
        return messageAndPriceOrderProduct;
    }

    public void updatePrice() {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);
        if (productsR != null) {
            System.out.print("Enter product ID: ");
            String id = new Scanner(System.in).nextLine();
            for (Product product : productsR) {
                if (id.equals(product.getId())) {
                    System.out.print("Enter the new price: $");
                    Double price = new Scanner(System.in).nextDouble();
                    product.setPrice(price);
                    fileService.writeFile(filepath, productsR);
                    System.out.println("\nPrice updated successfully\n");
                    break;
                }
            }
        } else {
            System.out.println("No product available\n");
        }
    }

    public void removeProduct() {
        String filepath = "src\\data\\Products.txt";
        List<Product> productsR = (List<Product>) fileService.readFile(filepath);
        if (productsR != null) {
            System.out.print("Enter product ID: ");
            String id = new Scanner(System.in).nextLine();
            for (Product product : productsR) {
                if (id.equals(product.getId())) {
                    productsR.remove(product);
                    fileService.writeFile(filepath, productsR);
                    System.out.println("Product removed");
                    break;
                }
            }
            System.out.println();
        } else {
            System.out.println("No product available\n");
        }
        if (productsR.isEmpty()) {
            try {
                Files.deleteIfExists(Paths.get("src\\data\\Products.txt"));
            } catch (IOException e) {
                System.out.println("Cannot delete file\n");
            }
        }
    }
}