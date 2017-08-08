package principles_systems_architecture.chapter1.section4;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Customer(name = %s)", this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return other.name.equals(this.name);
    }
}
