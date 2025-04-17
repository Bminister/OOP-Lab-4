public class PurseFacade {
    private Register register;

    public PurseFacade(MakeChangeStrategy strategy) {
        this.register = new Register(strategy);
    }

    public Purse getChange(double amount) {
        return register.makeChange(amount);
    }

    public void setStrategy(MakeChangeStrategy strategy) {
        register.setStrategy(strategy);
    }
}