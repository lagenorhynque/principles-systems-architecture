package principles_systems_architecture.chapter2.section1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

interface Fee {
    Yen yen();
    String label();
}

class AdultFee implements Fee {
    public Yen yen() {
        return new Yen(100);
    }

    public String label() {
        return "大人";
    }
}

class ChildFee implements Fee {
    public Yen yen() {
        return new Yen(50);
    }

    public String label() {
        return "子供";
    }
}

class SeniorFee implements Fee {
    public Yen yen() {
        return new Yen(80);
    }

    public String label() {
        return "シニア";
    }
}

class FeeFactory {
    static Map<String, Fee> types;

    static {
        Map<String, Fee> map = new HashMap<>();
        map.put("adult", new AdultFee());
        map.put("child", new ChildFee());
        map.put("senior", new SeniorFee());
        types = Collections.unmodifiableMap(map);
    }

    static Fee feeByName(String name) {
        return types.get(name);
    }
}

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
