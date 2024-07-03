public class Print1toN {
    
    public void print(int i, int N){
        if(i < 1) return;
        print(i - 1, N);
        System.out.print(i + " ");
    }
    
    public void printNos(int N){
        print(N, N);
    }

    public static void main(String[] args) {
        Print1toN printer = new Print1toN();
        printer.printNos(5);  // Example usage: prints numbers from 1 to 5
    }
}
