import java.util.Map;
import java.util.HashMap;
/*
private static final Denomination[] US_CURRENCIES = {
                new Denomination("Hundred-Dollar Note",100.0,"Bill","images/hundred.png"),//Change with the actual .png name
                new Denomination("Fifty-Dollar Note", 50.0,"Bill","images/fifty-dollar.png"),
                new Denomination("Twenty-Dollar Note", 20.0,"Bill","images/twenty-dollar.png"),
                new Denomination("Ten-Dollar Note", 10.0,"Bill","images/ten-dollar.png"),
                new Denomination("Five-Dollar Note", 5.0,"Bill","images/five-dollar.png"),
                new Denomination("One-Dollar Note", 10.0,"Bill","images/one-dollar.png"),
                new Denomination("Quarter", 0.25,"Coin","images/quarter.png"),
                new Denomination("Dime", 0.10, "Coin","images/dime.png"),
                new Denomination("Nickel", 0.05, "Coin","images/nickel.png"),
                new Denomination("Penny", 0.01, "Coin","images/penny.png"),
        };
* */
public class Purse {
    HashMap<Denomination, Integer> cash;

    //Constructor for Purse
    public Purse()
    {
        cash = new HashMap<>();
    }


    //add(type: Denomination, num: int): void  // adds a number of a particular denomination
    public void add(Denomination d, int amount)
    {
        cash.put(d, amount);
    }
    //remove(type: Denomination, num: int): double //diminishes the money in the purse and returns that amount.
    public double remove(Denomination d, int amount)
    {
        double amountRemoved = d.amt() * amount;
        cash.remove(d, amount);
        return amountRemoved;
    }
    //getValue(): double    // returns the amount of money in the Purse
    public double getValue()
    {
        double total = 0;
        //For loop that goes through the cash map and counts the total for each denomination
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet())
        {
            total += entry.getKey().amt() * entry.getValue();
        }
        return total;
    }
    //toString(): String    // returns a string representation of the Purse and its contents
    public String toString()
    {
        String output = "";
        for (Denomination d : cash.keySet()) {
            if (cash.get(d) > 0)
                output += cash.get(d) + " " + d.name() + "\n ";
        }

        return output;
    }
}