package principles_systems_architecture.chapter2.section1;

class AdultFee implements Fee {
    public Yen yen() {
        return new Yen(100);
    }

    public String label() {
        return "大人";
    }
}
