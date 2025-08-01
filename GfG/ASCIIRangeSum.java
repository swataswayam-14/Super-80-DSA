import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ASCIIRangeSum {
    public static ArrayList<Integer> asciiRange(String s) {
        //find first and last occurence index for each character
        //if a character donot have a first and last both then reject it
        //for every first and last index of each character that has it, find the sum of the between elements ascii value by running a loop from first+1 <= last-1
        //put the sum in an arraylist and then return it

        ArrayList<Integer> res = new ArrayList<>();

        ArrayList<ArrayList<Integer>> firstAndLast = new ArrayList<>();

        Set<Character> visited = new HashSet<>();

        for(char c: s.toCharArray()) {
            if(visited.contains(c)) continue;
            visited.add(c);
            int first = -1;
            int last = -1;

            int position[] = findFirstLast(c,s);

            first = position[0];
            last = position[1];

            if(first != -1 && last != -1 && first != last) {
                ArrayList<Integer> pos = new ArrayList<>();
                pos.add(first);
                pos.add(last);

                firstAndLast.add(pos);
            }
        }
        for(ArrayList<Integer> pos : firstAndLast) {
            int sum = 0;
            int i = pos.get(0) + 1;
            int j = pos.get(1) - 1;

            while(i<=j){
                sum += s.charAt(i);
                i++;
            }
            if(!(sum == 0))res.add(sum);
        }
        return res;
    }
    private static int[] findFirstLast(char c, String s) {

        int first = -1, last = -1;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == c) {
                if(first == -1) first = i;
                last = i;
            }
        
        }
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(asciiRange(s));
    }
}
