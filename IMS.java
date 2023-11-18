import java.util.*;


class ElectronicProduct {
    String category;
    String name;
    String specification;
    double cost;
    int quantity;

    public ElectronicProduct(String category, String name, String specification, double cost, int quantity) {
        this.category = category;
        this.name = name;
        this.specification = specification;
        this.cost = cost;
        this.quantity = quantity;
    }

    
    public void displayDetails() {
        System.out.println("Category: " + category);
        System.out.println("Name: " + name);
        System.out.println("Specification: " + specification);
        System.out.println("Cost: $" + cost);
        System.out.println("Quantity: " + quantity);
    }

    
    public void updateDetails(String specification, double cost) {
        this.specification = specification;
        this.cost = cost;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
}


class MobilePhone extends ElectronicProduct {
    String manufacturer;

    public MobilePhone(String name, String specification, double cost, int quantity, String manufacturer) {
        super("Mobile Phones", name, specification, cost, quantity);
        this.manufacturer = manufacturer;
    }

    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Manufacturer: " + manufacturer);
    }
}


class ElectronicsStore {
    String name;
    String location;
    String branch;
    List<ElectronicProduct> inventory;

    public ElectronicsStore(String name, String location, String branch) {
        this.name = name;
        this.location = location;
        this.branch = branch;
        this.inventory = new ArrayList<>();
    }

    
    public void addProduct(ElectronicProduct product) {
        inventory.add(product);
    }

    
    public void displayProductList() {
        System.out.println("=== Product List ===");
        for (ElectronicProduct product : inventory) {
            product.displayDetails();
            System.out.println("---------------");
        }
    }

    
    public void displayProductCount(String productName) {
        System.out.println("=== Product Count ===");
        for (ElectronicProduct product : inventory) {
            if (product.name.equals(productName)) {
                System.out.println("Product: " + productName);
                System.out.println("Quantity: " + product.quantity);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    
    public void viewProductDetails(String productName) {
        System.out.println("=== Product Details ===");
        for (ElectronicProduct product : inventory) {
            if (product.name.equals(productName)) {
                product.displayDetails();
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    
    public void editProduct(String productName, String specification, double cost) {
        for (ElectronicProduct product : inventory) {
            if (product.name.equals(productName)) {
                product.updateDetails(specification, cost);
                System.out.println("Product details updated successfully.");
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    
    public void updateInventory(String productName, int quantityChange) {
        for (ElectronicProduct product : inventory) {
            if (product.name.equals(productName)) {
                int newQuantity = product.quantity + quantityChange;
                if (newQuantity >= 0) {
                    product.updateQuantity(newQuantity);
                    System.out.println("Inventory updated successfully.");
                } else {
                    System.out.println("Cannot decrease quantity below 0.");
                }
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }


    public void displayIndividualInventoryReport() {
        System.out.println("=== Individual Inventory Report ===");
        for (ElectronicProduct product : inventory) {
            product.displayDetails();
            System.out.println("---------------");
        }
    }

    
    public void displayAggregatedInventoryReport() {
        System.out.println("=== Aggregated Inventory Report ===");
        for (ElectronicProduct product : inventory) {
            System.out.println("Category: " + product.category);
            System.out.println("Name: " + product.name);
            System.out.println("Total Quantity: " + product.quantity);
            System.out.println("---------------");
        }
    }
}

public class IMS {
    public static void main(String[] args) {
        
        ElectronicsStore myStore = new ElectronicsStore("ElectroMart", "City Center", "Branch 1");

        
        myStore.addProduct(new MobilePhone("iPhone 13", "5.4-inch Super Retina XDR display", 999.99, 50, "Apple"));
        myStore.addProduct(new MobilePhone("Galaxy S21", "6.2-inch Dynamic AMOLED display", 899.99, 40, "Samsung"));
        myStore.addProduct(new ElectronicProduct("Laptop", "Dell XPS 13", "13-inch FHD display", 1299.99, 30));

        
        myStore.displayProductList();
        
        myStore.displayProductCount("iPhone 13");

        myStore.viewProductDetails("Galaxy S21");

        myStore.editProduct("Galaxy S21", "6.7-inch Dynamic AMOLED display", 999.99);

        myStore.displayProductList();

        myStore.updateInventory("iPhone 13", 20);

        myStore.displayIndividualInventoryReport();

        myStore.displayAggregatedInventoryReport();
    }
}
