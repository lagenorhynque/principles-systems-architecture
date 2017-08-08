package principles_systems_architecture.chapter1.section3;

/*
 * CHAPTER 1: 小さくまとめてわかりやすくする
 * 小さなクラスでわかりやすく安全に
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.execute1();
        m.execute2();
        m.execute3();
    }

    void execute1() {
        Quantity q = new Quantity(30);
        System.out.println("q: " + q);
        System.out.println("q.canAdd(new Quantity(70)): " + q.canAdd(new Quantity(70)));
        System.out.println("q.add(new Quantity(70)): " + q.add(new Quantity(70)));
        System.out.println("q.canAdd(new Quantity(71)): " + q.canAdd(new Quantity(71)));
    }

    void execute2() {
        Money basePrice = new Money(3000);
        System.out.println("basePrice: " + basePrice);
        Money discounted = basePrice.minus(new Money(100));
        System.out.println("discounted: " + discounted);
        Money option = new Money(1000);
        System.out.println("option: " + option);
    }

    void execute3() {
        Money unitPrice = new Money(2500);
        System.out.println("unitPrice: " + unitPrice);
        Quantity quantity = new Quantity(10);
        System.out.println("quantity: " + quantity);
        Money amount = amount(unitPrice, quantity);
        System.out.println("amount: " + amount);
    }

    Money amount(Money unitPrice, Quantity quantity) {
        if (quantity.isDiscountable) return discount(unitPrice, quantity);
        return unitPrice.multiply(quantity);
    }

    Money discount(Money unitPrice, Quantity quantity) {
        return new Money((int) (unitPrice.value * 0.8)).multiply(quantity);
    }
}
