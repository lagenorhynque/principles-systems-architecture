package principles_systems_architecture.chapter1.section3;

class Money {
    final int value;

    Money(int value) {
        this.value = value;
    }

    Money minus(Money other) {
        return new Money(this.value - other.value);
    }

    Money multiply(Quantity quantity) {
        return new Money(this.value * quantity.value);
    }

    @Override
    public String toString() {
        return String.format("Money(value = %s)", this.value);
    }
}
