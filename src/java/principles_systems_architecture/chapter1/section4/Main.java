package principles_systems_architecture.chapter1.section4;

/*
 * CHAPTER 1: 小さくまとめてわかりやすくする
 * 複雑さを閉じ込める
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.execute1();
    }

    void execute1() {
        Customers cs1 = new Customers();
        System.out.println("cs1: " + cs1);
        Customers cs2 = cs1
            .add(new Customer("X"))
            .add(new Customer("Y"))
            .add(new Customer("Z"));
        System.out.println("cs2: " + cs2);
        Customers cs3 = cs2.removeIfExist(new Customer("Y"));
        System.out.println("cs3: " + cs3);
        System.out.println("cs3.importantCustomers(): " + cs3.importantCustomers());
        System.out.println("cs3.asList(): " + cs3.asList());
    }
}
