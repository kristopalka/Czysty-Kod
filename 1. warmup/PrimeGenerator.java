package exercises;

/** TODO
 * Jako rozgrzewkę, spróbuj pobawić się tym kodem.
 * Zrozum jego działanie, a następnie zepsuj go w taki sposób, aby był jak najmniej czytelny, ale wciąż działał
 * (testowanie czy kod działa jest również częścią zadania)
 */

public class PrimeGenerator
{
    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) return new int[0];
        else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++)
            if (notCrossed(i)) crossOutMultiplesOf(i);
    }

    private static int determineIterationLimit() {
        // Każda wielokrotność w tablicy ma podzielnik będący liczbą pierwszą
        // mniejszą lub równą pierwiastkowi kwadratowemu wielkości tablicy,
        // więc nie musimy wykreślać wielokrotności większych od tego pierwiastka.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i)
            crossedOut[multiple] = true;
    }

    private static boolean notCrossed(int i)
    {
        return crossedOut[i] == false;
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++)
            if (notCrossed(i)) result[j++] = i;
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (notCrossed(i)) count++;
        return count;
    }
}
