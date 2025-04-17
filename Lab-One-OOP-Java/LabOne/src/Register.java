public class Register {
    private MakeChangeStrategy strategy;

    // Constructor that accepts a strategy
    public Register(MakeChangeStrategy strategy) {
        this.strategy = strategy;
    }

    // Method to set a new strategy dynamically
    public void setStrategy(MakeChangeStrategy strategy) {
        this.strategy = strategy;
    }

    // This method will use the current strategy to make change
    public Purse makeChange(double amt) {
        return strategy.makeChange(amt);
    }
}