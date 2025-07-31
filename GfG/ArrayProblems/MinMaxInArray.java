package ArrayProblems;

class Pair<K,V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue(){
        return value;
    }
}

public class MinMaxInArray {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        if(arr.length == 1) {
            Pair<Integer, Integer> result = new Pair(arr[0],arr[0]);
            return result;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        Pair<Integer, Integer> result = new Pair(min, max);
        
        return result;
    }
}
