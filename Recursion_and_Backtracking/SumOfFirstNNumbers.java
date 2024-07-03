public class SumOfFirstNNumbers {

    long sum(long n, long result){
        if(n < 1) return result;
        
        result = sum(n - 1, result + (long)Math.pow(n, 3));
        
        return result;
    }
    
    long sumOfSeries(long n) {
        return sum(n, 0);
    }

    public static void main(String[] args) {
        SumOfFirstNNumbers calculator = new SumOfFirstNNumbers();
        long result = calculator.sumOfSeries(5);  // Example usage: sum of cubes of first 5 natural numbers
        System.out.println(result);  // Should print the result
    }
}
