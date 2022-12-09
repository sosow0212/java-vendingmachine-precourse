package vendingmachine.domain;

import java.util.HashMap;

public class ProductManager {
    private HashMap<String, Product> productInfo = new HashMap<>();
    private int minProductPrice = Integer.MIN_VALUE;

    public ProductManager(String input) {
        fillProduct(input);
        setMinPriceOfProduct();
    }

    public void fillProduct(String input) {
        String[] infos = input.split(";");
        for (String info : infos) {
            info = info.substring(1, info.length() - 1);
            String[] product = info.split(",");
            this.productInfo.put(product[0], new Product(Integer.valueOf(product[1]), Integer.valueOf(product[2])));
        }
    }

    public void setMinPriceOfProduct() {
        for (Product product : productInfo.values()) {
            if (product.getPrice() < minProductPrice) {
                minProductPrice = product.getPrice();
            }
        }
    }

    public boolean canPurchase(String purchaseGoods, int money) {
        Product product = productInfo.get(purchaseGoods);
        return product.getPrice() <= money && product.getQuantity() != 0;
    }

    public int purchaseGoods(String purchaseGoods, int money) {
        Product product = productInfo.get(purchaseGoods);
        if (product.getQuantity() != 0)
            product.buyProduct();
        return money - product.getPrice();
    }

    public boolean canPurchaseProduct(int money) {
        return money >= minProductPrice;
    }
}
