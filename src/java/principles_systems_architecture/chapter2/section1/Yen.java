package principles_systems_architecture.chapter2.section1;

class Yen {
    final int value;

    Yen() {
        this.value = 0;
    }

    Yen(int value) {
        this.value = value;
    }

    Yen add(Yen yen) {
        return new Yen(this.value + yen.value);
    }

    @Override
    public String toString() {
        return String.format("Yen(value = %s)", this.value);
    }
}
