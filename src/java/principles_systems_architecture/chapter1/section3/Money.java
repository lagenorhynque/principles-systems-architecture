package principles_systems_architecture.chapter1.section3;

public class Money {
    final int value;

    public Money(int value) {
        this.value = value;
    }

    public Money minus(Money other) {
        return new Money(this.value - other.value);
    }

    public Money multiply(Quantity quantity) {
        return new Money(this.value * quantity.value);
    }

    @Override
    public String toString() {
        return String.format("Money(value = %s)", this.value);
    }
}
