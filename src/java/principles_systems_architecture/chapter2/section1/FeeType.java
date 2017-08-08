package principles_systems_architecture.chapter2.section1;

enum FeeType {
    adult(new AdultFee()),
    child(new ChildFee()),
    senior(new SeniorFee());

    private Fee fee;

    private FeeType(Fee fee) {
        this.fee = fee;
    }

    Yen yen() {
        return fee.yen();
    }

    String label() {
        return fee.label();
    }
}
