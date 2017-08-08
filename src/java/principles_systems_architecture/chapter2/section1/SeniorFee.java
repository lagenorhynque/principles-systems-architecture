package principles_systems_architecture.chapter2.section1;

class SeniorFee implements Fee {
    public Yen yen() {
        return new Yen(80);
    }

    public String label() {
        return "シニア";
    }
}
