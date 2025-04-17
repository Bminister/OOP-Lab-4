import java.util.Scanner;
public class Register {
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


    public Purse makeChange(double amt)
    {
        //takes an amt and returns a Purse containing that amount in the fewest number of bills and coins
        Purse p  = new Purse();
        int temp = (int) (amt * 100);
        int hundreds = 0;
        int fifty = 0,twenties = 0, tens = 0, fives = 0, ones = 0, quarters = 0, dimes = 0, nickles = 0, pennies = 0;

        /*  definitely could be a lot better
        Already thinking about an idea with using an array to test instead of all the variables?
        or even just putting it into the map immediately?
        Also thinking about using a for loop to clear up a lot of the if statements.
        for loop would have to include a variable to track the last one that you tested (ex: tens, fives, ones
        double amt = 389.93; improvement idea written on ipad

         */

    // 100
    if (temp > 10000)
        {
            hundreds = temp / 10000;
            temp = temp % 10000;
        }

    // 50
    if (temp > 5000 && temp < 10000)
    {
        fifty = temp / 5000;
        temp = temp % 5000;
    }

    //  20
    if (temp > 2000 && temp < 5000)
    {
        twenties = temp / 2000;
        temp = temp % 2000;
    }

    // 10
    if (temp > 1000 && temp < 2000)
    {
        tens = temp / 1000;
        temp = temp % 1000;
    }
    //  5
    if (temp > 500 && temp < 1000)
    {
        fives = temp / 500;
        temp = temp % 500;
    }

    //  1
    if (temp > 100 && temp < 500)
    {
        ones = temp / 100;
        temp = temp % 100;
    }

    //  0.25
    if (temp > 25 && temp < 100)
    {
        quarters = temp / 25;
        temp = temp % 25;
    }

    //  0.10
    if (temp > 10 && temp < 25)
    {
        dimes = temp / 10;
        temp = temp % 10;
    }

    //  0.05
    if (temp > 5 && temp < 10)
    {
        nickles = temp / 5;
        temp = temp % 5;
    }

    //  0.01
    if (temp > 1 && temp < 5)
    {
        pennies = temp;
    }

    p.add(US_CURRENCIES[0],hundreds);
    p.add(US_CURRENCIES[1],fifty);
    p.add(US_CURRENCIES[2],twenties);
    p.add(US_CURRENCIES[3],tens);
    p.add(US_CURRENCIES[4],fives);
    p.add(US_CURRENCIES[5],ones);
    p.add(US_CURRENCIES[6],quarters);
    p.add(US_CURRENCIES[7],dimes);
    p.add(US_CURRENCIES[8],nickles);
    p.add(US_CURRENCIES[9],pennies);


        return p;
    }
    public static void main(String[] args) {
        //creates a register and demonstrates that it works

        Register r = new Register();
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter money: ");

        double inputAmt = input.nextDouble();
        Purse p = r.makeChange(inputAmt);
        System.out.println(p.toString());
        //Print is coming out in a weird order? idk if that matters in the long run. ill find the bug later
    }

}
