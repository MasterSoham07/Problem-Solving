public class PrintNameNTimes {
    
    void print(int i, int N){
        if(i > N) return;
        
        System.out.print("GFG ");
        print(i + 1, N);
    }

    void printGfg(int N) {
        print(1, N);
    }

    public static void main(String[] args) {
        PrintNameNTimes printer = new PrintNameNTimes();
        printer.printGfg(5);  // Example usage: prints "GFG " 5 times
    }
}
