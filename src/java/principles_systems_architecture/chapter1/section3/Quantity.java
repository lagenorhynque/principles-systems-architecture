package principles_systems_architecture.chapter1.section3;

public class Quantity {
    public static final int MIN = 1;
    public static final int MAX = 100;
    public static final int MIN_FOR_DISCOUNT = 10;

    final int value;

    final boolean isDiscountable;

    public Quantity(int value) {
        if (value < MIN) throw new IllegalArgumentException("不正: " + MIN + "未満");
        if (value > MAX) throw new IllegalArgumentException("不正: " + MAX + "超");
        this.value = value;
        this.isDiscountable = value >= MIN_FOR_DISCOUNT;
    }

    public boolean canAdd(Quantity other) {
        int added = addValue(other);
        return added <= MAX;
    }

    public Quantity add(Quantity other) {
        if (!canAdd(other)) throw new IllegalArgumentException("不正: 合計が" + MAX + "超");
        int added = addValue(other);
        return new Quantity(added);
    }

    private int addValue(Quantity other) {
        return this.value + other.value;
    }

    @Override
    public String toString() {
        return String.format("Quantity(value = %s)", this.value);
    }
}
