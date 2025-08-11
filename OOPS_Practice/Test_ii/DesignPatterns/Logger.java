package Test_ii.DesignPatterns;

public class Logger {
    private static Logger instance;
    private Logger(){};

    public static Logger getInstance() {
        if(instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) {
        System.out.println("LOG: "+message);
    }
}

/* ================================================================
   2. Singleton Pattern
   ---------------------------------------------------------------
   What: Ensures a class has only one instance and provides a global access point.
   Real-world analogy: Only one government in a country.
   Use case: Logging, configuration, thread pools, database connections.
================================================================ */