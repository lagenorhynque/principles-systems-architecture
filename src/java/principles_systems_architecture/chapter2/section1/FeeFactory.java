package principles_systems_architecture.chapter2.section1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
