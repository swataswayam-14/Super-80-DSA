import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class FailedRefundRollback {
    /* Refunds are pushed into a stack. If a refund fails, it must be rolled back (popped). Print final refund sequence. */
    public static List<Integer> processRefunds(int[] refunds, int[] fails) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> failSet = new HashSet<>();

        for(int f: fails) failSet.add(f);

        for(int r: refunds) {
            stack.push(r);
            if(failSet.contains(r)) stack.pop();
        }
        return stack;
    }
    public static void main(String[] args) {
        int[] refunds = {101,102,103,104};
        int[] fails = {103};
        System.out.println(processRefunds(refunds, fails));
    }
}
