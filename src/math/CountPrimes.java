package math;
//204. Count Primes
//https://leetcode.com/problems/count-primes/
// TODO Learn Sieve of Eratosthenes
public class CountPrimes {
    public int countPrimes(int n) {
        int primeCount=0;
        if(n<=2) return 0;

        for(int i=0;i<n;i++){
            if(prime(i))primeCount++;
        }
        return primeCount;
    }

    boolean prime(int n){
        if (n % 2 == 0)
            return false;
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
