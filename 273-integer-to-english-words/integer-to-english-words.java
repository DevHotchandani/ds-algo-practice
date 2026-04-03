class Solution {

    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return solve(num).trim();
    }

    String solve(int n) {
        if (n < 20) return below20[n];

        if (n < 100)
            return tens[n / 10] + (n % 10 != 0 ? " " + solve(n % 10) : "");

        if (n < 1000)
            return below20[n / 100] + " Hundred" + (n % 100 != 0 ? " " + solve(n % 100) : "");

        if (n < 1000000)
            return solve(n / 1000) + " Thousand" + (n % 1000 != 0 ? " " + solve(n % 1000) : "");

        if (n < 1000000000)
            return solve(n / 1000000) + " Million" + (n % 1000000 != 0 ? " " + solve(n % 1000000) : "");

        return solve(n / 1000000000) + " Billion" + (n % 1000000000 != 0 ? " " + solve(n % 1000000000) : "");
    }
}