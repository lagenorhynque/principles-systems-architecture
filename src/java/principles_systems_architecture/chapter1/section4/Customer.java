package principles_systems_architecture.chapter1.section4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

class Customers {
    List<Customer> customers;

    Customers() {
        customers = Collections.emptyList();
    }

    Customers(List<Customer> customers) {
        this.customers = customers;
    }

    Customers add(Customer customer) {
        List<Customer> result = new ArrayList<>(customers);
        result.add(customer);
        return new Customers(result);
    }

    Customers removeIfExist(Customer customer) {
        List<Customer> result = new ArrayList<>(customers);
        result.remove(customer);
        return new Customers(result);
    }

    Customers importantCustomers() {
        return new Customers(Arrays.asList(
            new Customer("A"),
            new Customer("B"),
            new Customer("C")
        ));
    }

    List<Customer> asList() {
        return Collections.unmodifiableList(customers);
    }

    @Override
    public String toString() {
        return String.format("Customers(customers = %s)", this.customers);
    }
}
