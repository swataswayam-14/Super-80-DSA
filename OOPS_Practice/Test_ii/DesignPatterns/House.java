package Test_ii.DesignPatterns;

public class House {
    private String walls;
    private String roof;
    private boolean hasGarden;

    private House(Builder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.hasGarden = builder.hasGarden;
    }

    static class Builder {
        private String walls;
        private String roof;
        private boolean hasGarden;

        public Builder setWalls(String walls) {
            this.walls = walls;
            return this;
        }
        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }
        public Builder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }
        public House build() {
            return new House(this);
        }
    }
    @Override
    public String toString() {
        return "House with "+ walls+", "+roof+", Garden: "+hasGarden;
    }
}


/* ================================================================
   3. Builder Pattern
   ---------------------------------------------------------------
   What: Allows step-by-step construction of complex objects.
   Real-world analogy: Ordering a pizza — choose size, toppings, crust separately.
   Use case: Creating immutable objects with many optional parameters.
================================================================ */