package pg.home;

import io.quarkus.runtime.QuarkusApplication;

//@QuarkusMain
public class MainApp implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello World");
        return 10;
    }
}
