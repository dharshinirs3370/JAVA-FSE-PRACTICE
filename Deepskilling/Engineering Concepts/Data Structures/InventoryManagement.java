import java.util.HashMap;
import java.util.Scanner;

class Product {

    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: ₹" + price;
    }
}

public class InventoryManagement {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product Added Successfully.");
    }

    // Update Product
    static void updateProduct(int id, int quantity, double price) {

        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product Updated Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    // Delete Product
    static void deleteProduct(int id) {

        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product Deleted Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    // Display Products
    static void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }

        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    addProduct(new Product(id, name, quantity, price));
                    break;

                case 2:

                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    quantity = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    price = sc.nextDouble();

                    updateProduct(id, quantity, price);
                    break;

                case 3:

                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();

                    deleteProduct(id);
                    break;

                case 4:

                    displayProducts();
                    break;

                case 5:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}