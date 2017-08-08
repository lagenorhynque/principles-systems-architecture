package principles_systems_architecture.chapter2.section1;

class ChildFee implements Fee {
    public Yen yen() {
        return new Yen(50);
    }

    public String label() {
        return "子供";
    }
}
