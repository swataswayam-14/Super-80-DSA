package Test_ii.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

class NewsChannel implements Observer {
    private String name;
    public NewsChannel(String name) {
        this.name = name;
    }
    public void update(String news) {
        System.out.println(name+" received update: "+news);
    }
}

public class NewsAgency {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void setNews(String news) {
        this.news = news;
        for(Observer o: observers)o.update(news);
    }
}
/* ================================================================
   4. Observer Pattern
   ---------------------------------------------------------------
   What: Defines a one-to-many dependency so when one object changes state, all dependents are notified.
   Real-world analogy: You subscribe to a YouTube channel; when it uploads a video, you get notified.
   Use case: Event systems, messaging systems, UI updates.
================================================================ */