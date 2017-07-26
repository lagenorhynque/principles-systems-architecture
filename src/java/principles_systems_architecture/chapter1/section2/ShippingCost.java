package principles_systems_architecture.chapter1.section2;

class ShippingCost {
    static final int MINIMUM_FOR_FREE = 3000;
    static final int COST = 500;

    final int basePrice;

    ShippingCost(int basePrice) {
        this.basePrice = basePrice;
    }

    int amount() {
        if (this.basePrice < MINIMUM_FOR_FREE) return COST;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("ShippingCost(basePrice = %s)", this.basePrice);
    }
}
