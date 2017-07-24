package principles_systems_architecture.chapter1.section2;

public class ShippingCost {
    public static final int MINIMUM_FOR_FREE = 3000;
    public static final int COST = 500;

    final int basePrice;

    public ShippingCost(int basePrice) {
        this.basePrice = basePrice;
    }

    public int amount() {
        if (this.basePrice < MINIMUM_FOR_FREE) return COST;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("ShippingCost(basePrice = %s)", this.basePrice);
    }
}
