public class DefaultMakeChangeStrategy implements MakeChangeStrategy {
    private static final Denomination[] US_CURRENCIES = {
            new Denomination("Hundred-Dollar Note", 100.0, "Bill", "images/hundred.png"),
            new Denomination("Fifty-Dollar Note", 50.0, "Bill", "images/fifty-dollar.png"),
            new Denomination("Twenty-Dollar Note", 20.0, "Bill", "images/twenty-dollar.png"),
            new Denomination("Ten-Dollar Note", 10.0, "Bill", "images/ten-dollar.png"),
            new Denomination("Five-Dollar Note", 5.0, "Bill", "images/five-dollar.png"),
            new Denomination("One-Dollar Note", 1.0, "Bill", "images/one-dollar.png"),
            new Denomination("Quarter", 0.25, "Coin", "images/quarter.png"),
            new Denomination("Dime", 0.10, "Coin", "images/dime.png"),
            new Denomination("Nickel", 0.05, "Coin", "images/nickel.png"),
            new Denomination("Penny", 0.01, "Coin", "images/penny.png")
    };

    @Override
    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        int temp = (int) (amt * 100);
        int[] coinCounts = new int[US_CURRENCIES.length];

        if (temp >= 10000) {
            coinCounts[0] = temp / 10000;
            temp %= 10000;
        }
        if (temp >= 5000) {
            coinCounts[1] = temp / 5000;
            temp %= 5000;
        }
        if (temp >= 2000) {
            coinCounts[2] = temp / 2000;
            temp %= 2000;
        }
        if (temp >= 1000) {
            coinCounts[3] = temp / 1000;
            temp %= 1000;
        }
        if (temp >= 500) {
            coinCounts[4] = temp / 500;
            temp %= 500;
        }
        if (temp >= 100) {
            coinCounts[5] = temp / 100;
            temp %= 100;
        }
        if (temp >= 25) {
            coinCounts[6] = temp / 25;
            temp %= 25;
        }
        if (temp >= 10) {
            coinCounts[7] = temp / 10;
            temp %= 10;
        }
        if (temp >= 5) {
            coinCounts[8] = temp / 5;
            temp %= 5;
        }
        if (temp >= 1) {
            coinCounts[9] = temp;
        }

        // Add the coins and bills to the purse
        for (int i = 0; i < US_CURRENCIES.length; i++) {
            purse.add(US_CURRENCIES[i], coinCounts[i]);
        }

        return purse;
    }
}