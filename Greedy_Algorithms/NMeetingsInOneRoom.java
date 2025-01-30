package Greedy_Algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meet {
    int start;
    int end;
    int index;
    Meet(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
class MeetComparator implements Comparator<Meet> {
    @Override
    public int compare(Meet m1, Meet m2) {
        return Integer.compare(m1.end, m2.end);
    }
}

public class NMeetingsInOneRoom {
    public static int countMeetings(int start[], int end[]) {
        int n = start.length;
        Meet meets[] = new Meet[n];
        for (int i = 0; i < n; i++) {
            meets[i] = new Meet(start[i], end[i], i+1);
        }
        Arrays.sort(meets, new MeetComparator());

        List<Integer>indices = new ArrayList<>();
        indices.add(meets[0].index);
        int count = 1;
        int endTime = meets[0].end;

        for (int i = 1; i < meets.length; i++) {
            if (meets[i].start > endTime) {
                count += 1;
                endTime = meets[i].end;
                indices.add(meets[i].index);
            }
        }
        int countM = 0;
        for (Integer integer : indices) {
            ++countM;
            System.out.println("Meeting scheduled: "+"MEETING  "+countM+" Start Time: "+start[integer - 1]+" End time: "+end[integer - 1]);
        }
        return count;
    }
    public static void main(String[] args) {
        int start[] = new int[] {0,3,1,5,5,8};
        int end[] = new int[] {5,4,2,9,7,9};
        System.out.println(countMeetings(start, end));
    }
}
