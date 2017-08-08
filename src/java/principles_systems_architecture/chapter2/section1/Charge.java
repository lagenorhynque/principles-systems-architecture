package principles_systems_architecture.chapter2.section1;

class Charge {
    Fee fee;

    Charge(Fee fee) {
        this.fee = fee;
    }

    Yen yen() {
        return fee.yen();
    }

    @Override
    public String toString() {
        return String.format("Charge(fee = %s)", this.fee);
    }
}
