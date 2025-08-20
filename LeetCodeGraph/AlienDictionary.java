import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    /*
    Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language

    Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned

    sorted order according to alien dict: 

    baa
    abcd
    abca
    cab
    cad


    sorted order accroding to english dict : 

    abca
    abcd
    baa
    cab
    cad

    find out the alien order
    k=4 ( the alien dict would have first 4 letters of the english dict that is (a,b,c,d))

    b appears before a
    d appears before a
    a appears before c
    b appears before d

    alien order: bdac (this needs to be returned)

    the question says : 
    something before something : hence idea : topo sort algo

    how do we apply the topo sort???

    k=4
    a b c d
    0 1 2 3

    baa
    abcd

    figure out why baa appears before abcd

    conclusion: b < a

    b -> a

    abcd
    abca

    figure out why?

    concl : d < a

    d -> a

    abca
    cab

    conc: a -> c

    cab
    cad

    b -> d


    so the graph is
    b->a->c
    
    b->d->a

    so we have created the directed graph

    if k was 5 then there would be an alphabet 'e', but we donot have any word having 'e' hence we will consider e as a single node

    once the dg is created : 
    the order we will get by performing the topo sort

    bdac : answer
    bdace
    or
    ebdac 


    approach

    i=0
    s1 = arr[i] //baa
    s2 = arr[i+1] //abcd

    the moment you find a non equality
    b!a 
    hence b<a

    b -> a

    and so on....
     */

    public static String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0;ptr < len;ptr++) {
                if(s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K, adj);

        String ans = "";
        for(int it: topo) {
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
    }
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }

}
