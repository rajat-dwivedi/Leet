import java.util.*;

public class SubsequencePrinter {
    
    // Recursive function to generate subsequences
    public static void generateSubsequences(int index, int[] arr, List<Integer> current) {
        // Base case: if we've processed all elements
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // TAKE the current element
        current.add(arr[index]);
        generateSubsequences(index + 1, arr, current);

        // NOT TAKE the current element (backtrack)
        current.remove(current.size() - 1);
        generateSubsequences(index + 1, arr, current);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> current = new ArrayList<>();
        
        System.out.println("All possible subsequences:");
        generateSubsequences(0, arr, current);
    }
}
