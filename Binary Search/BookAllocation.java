import java.util.ArrayList;
import java.util.Collections;

public class BookAllocation {
    // Brute force......

//     public static int countStudents(ArrayList<Integer> arr, int pages){
//         int students = 1;
//         int pagesStudent = 0;
//         int n = arr.size();

//         for(int i = 0; i < n; i++){
//             if(pagesStudent + arr.get(i) <= pages){
//                 pagesStudent += arr.get(i);
//             }

//             else{
//                 students++;
//                 pagesStudent = arr.get(i);
//             }
//         }

//         return students;
//     }

//     public static int findPages(ArrayList<Integer> arr, int n, int m) {

//         if(m > n){
//             return -1;
//         } 

//         int low = Collections.max(arr);
//         int high = 0;
//         for(int num : arr){
//             high += num;
//         }

//         for(int pages = low; pages <= high; pages++){
//             int cntStudent = countStudents(arr, pages);
//             if(cntStudent == m) return pages;
//         }

//         return low;
// }

// Optimal Solution using Binary Search..........

public static int countStudents(ArrayList<Integer> arr, int pages){
    int students = 1, pagesStudent = 0;
    int n = arr.size();

    for(int i = 0; i < n; i++){
        if(pagesStudent + arr.get(i) <= pages){
            pagesStudent += arr.get(i);
        }

        else{
            students++;
            pagesStudent = arr.get(i);
        }
    }

    return students;
}

public static int findPages(ArrayList<Integer> arr, int n, int m){

    if(m > n){
        return -1;
    }

    int low = Collections.max(arr);
    int high = 0;
     for(int num : arr){
        high += num;
     }

     while(low <= high){
        int mid = (low + high) / 2;

        if(countStudents(arr, mid) <= m){
            high = mid - 1;
        }

        else{
            low = mid + 1;
        }
     }

     return low;
}
}
