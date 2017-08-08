package principles_systems_architecture.chapter2.section1;

import java.util.ArrayList;
import java.util.List;

class Reservation {
    List<Fee> fees;

    Reservation() {
        fees = new ArrayList<>();
    }

    void addFee(Fee fee) {
        fees.add(fee);
    }

    Yen feeTotal() {
        return fees.stream().reduce(new Yen(), (total, each) -> total.add(each.yen()), Yen::add);
    }
}
