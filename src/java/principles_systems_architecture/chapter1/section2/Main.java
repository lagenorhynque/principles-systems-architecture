package principles_systems_architecture.chapter1.section2;

/*
 * CHAPTER 1: 小さくまとめてわかりやすくする
 * プログラムの変更が楽になる書き方
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.execute1();
    }

    void execute1() {
        int quantity = 3;
        int unitPrice = 5000;

        int basePrice = quantity * unitPrice;

        int shippingCost = shippingCost(basePrice);

        int itemPrice = (int) ((basePrice + shippingCost) * taxRate());
        System.out.println("itemPrice: " + itemPrice);
    }

    int shippingCost(int basePrice) {
        ShippingCost cost = new ShippingCost(basePrice);
        return cost.amount();
    }

    double taxRate() {
        return 1.08;
    }
}
