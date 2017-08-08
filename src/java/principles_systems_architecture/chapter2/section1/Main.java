package principles_systems_architecture.chapter2.section1;

/*
 * CHAPTER 2: 場合分けのロジックを整理する
 * プログラムを複雑にする「場合分け」のコード
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.execute1();
    }

    void execute1() {
        StateTransitions stateTransitions = new StateTransitions();
        System.out.println("stateTransitions.canTransit(State.審査中, State.承認済): "
            + stateTransitions.canTransit(State.審査中, State.承認済));
    }
}
