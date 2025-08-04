import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubStringBrute {
    static Set<String> countDistinctSubstrings(String s) {
        Set<String> st = new HashSet<>();
        int n = s.length();

        for(int i=0;i<n;i++) {
            StringBuilder str = new StringBuilder();
            for(int j=i;j<n;j++) {
                str.append(s.charAt(j));
                st.add(str.toString());
            }
        }
        return st;
    }
    public static void main(String[] args) {
        String s = "swayam";
        System.out.println("Given string: " + s);

        Set<String> substrings = countDistinctSubstrings(s);
        int count = 0;

        System.out.println("Distinct Substrings: ");
        for(String substr: substrings) {
            System.out.println(substr);
            count++;
        }
        System.out.println("No. of distinct substring: " + count+1);
    }
}
