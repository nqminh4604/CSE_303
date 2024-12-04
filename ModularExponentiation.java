import java.util.Scanner;

public class ModularExponentiation {

    // Function to calculate x^n % k using iterative modular exponentiation
    public static long modExponentiation(long x, long n, long k) {
        // Reduce x modulo k to handle very large x efficiently
        x = x % k;
        
        long result = 1;
        
        // While n is not zero
        while (n > 0) {
            // If n is odd, multiply the result by x and take modulo k
            if (n % 2 == 1) {
                result = (result * x) % k;
            }
            
            // Square x and reduce n by half
            x = (x * x) % k;
            n /= 2;  // Integer division by 2
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Example where x is very large
        long x = sc.nextLong();  // Very large base
        long n = sc.nextLong();  // Very large exponent
        long k = sc.nextLong();  // Modulus
        
        // Output the result of x^n % k
        System.out.println(modExponentiation(x, n, k));
    }
}
