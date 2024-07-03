public class PrintNto1 {
    
    void print(int i, int N){
        if(i > N) return;
        
        print(i + 1, N);
        System.out.print(i + " ");
    }
    
    void printNos(int N){
        print(1, N);
    }

    public static void main(String[] args) {
        PrintNto1 printer = new PrintNto1();
        printer.printNos(5);  // Example usage: prints numbers from 5 to 1
    }
}
