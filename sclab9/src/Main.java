import java.util.*;

class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public boolean reduceStock(int quantity) {
        if (quantity > 0 && stockQuantity >= quantity) {
            stockQuantity -= quantity;
            return true;
        }
        return false;
    }

    public void increaseStock(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
        }
    }

    public double calculateDiscount(double discountPercentage) {
        return price * (discountPercentage / 100);
    }

    public String getProductDetails() {
        return name + " (ID: " + productId + ") - $" + price + " - Stock: " + stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }
}

class ShoppingCart {
    private List<Product> items;
    private Map<String, Integer> quantities;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.quantities = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        if (product.reduceStock(quantity)) {
            items.add(product);
            quantities.put(product.getProductId(), quantity);
        }
    }

    public void removeItem(Product product) {
        items.remove(product);
        Integer quantity = quantities.remove(product.getProductId());
        if (quantity != null) {
            product.increaseStock(quantity);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            Integer quantity = quantities.get(item.getProductId());
            total += item.getPrice() * quantity;
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Shopping Cart Contents all :");
        for (Product item : items) {
            Integer quantity = quantities.get(item.getProductId());
            System.out.println(item.getProductDetails() + " x " + quantity);
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

class PaymentProcessor {
    public boolean processPayment(double amount, String paymentMethod) {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        return true;
    }
}

class OrderService {
    public void createOrder(ShoppingCart cart, String customerInfo) {
        double total = cart.calculateTotal();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        if (paymentProcessor.processPayment(total, "Credit Card")) {
            System.out.println("Order created successfully for " + customerInfo);
            System.out.println("Total amount: $" + total);
        }
    }
}

class ECommerceApp {
    public static void main(String[] args) {
        Product pc = new Product("Prod1", "Gaming Pc", 10000.99, 12);
        Product mouse = new Product("Prod2", "Wireless Mouse", 209.99, 500);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(pc, 1);
        cart.addItem(mouse, 2);

        cart.displayCart();

        OrderService orderService = new OrderService();
        orderService.createOrder(cart, "Awais Khan");
    }
}