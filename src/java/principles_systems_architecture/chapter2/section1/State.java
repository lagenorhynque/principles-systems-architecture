package principles_systems_architecture.chapter2.section1;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

enum State {
  審査中,
  承認済,
  実施中,
  終了,
  差し戻し中,
  中断中
}

class StateTransitions {
  Map<State, Set<State>> allowed;

  {
    allowed = new HashMap<>();
    allowed.put(State.審査中, EnumSet.of(State.承認済, State.差し戻し中));
    allowed.put(State.差し戻し中, EnumSet.of(State.審査中, State.終了));
    allowed.put(State.承認済, EnumSet.of(State.実施中, State.終了));
    allowed.put(State.実施中, EnumSet.of(State.中断中, State.終了));
    allowed.put(State.中断中, EnumSet.of(State.実施中, State.終了));
  }

  boolean canTransit(State from, State to) {
    return allowed.get(from).contains(to);
  }
}
