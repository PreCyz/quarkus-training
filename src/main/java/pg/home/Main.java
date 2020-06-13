package pg.home;

import io.quarkus.runtime.Quarkus;

//@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(MainApp.class, args);
    }
}
