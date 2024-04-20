import java.util.PriorityQueue;

public class MinimizeMaxDistToGasStation {

    // Brute force solution...........


    // public static double MinimiseMaxDistance(int[] arr, int K) {
    //     int n = arr.length;
    //     int howMany[] = new int[n - 1];

    //     for (int gasStations = 1; gasStations <= K; gasStations++) {
    //         double maxSection = -1;
    //         int maxIndex = -1;

    //         for (int i = 0; i < n - 1; i++) {
    //             double diff = arr[i + 1] - arr[i];
    //             double sectionLength = diff / (double) (howMany[i] + 1);

    //             if (sectionLength > maxSection) {
    //                 maxSection = sectionLength;
    //                 maxIndex = i;
    //             }
    //         }

    //         howMany[maxIndex]++;
    //     }

    //     double maxAns = -1;
    //     for (int i = 0; i < n - 1; i++) {
    //         double diff = arr[i + 1] - arr[i];
    //         double sectionLength = diff / (double) (howMany[i] + 1);

    //         maxAns = Math.max(maxAns, sectionLength);
    //     }

    //     return maxAns;
    // }

    // Better solution using Priority Queue..........

    public static class Pair{
        double first;
        int second;
    
        Pair(double first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static double MinimiseMaxDistance(int arr[] , int K){
        int n = arr.length;
        int howMany[] = new int[n - 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> Double.compare(b.first , a.first));

        for(int i = 0; i < n - 1; i++){
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        for(int gasStations = 1; gasStations <= K; gasStations++){

            Pair tp = pq.poll();
            int secInd = tp.second;

            howMany[secInd]++;

            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double)(howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }

        return pq.peek().first;
    }
}
