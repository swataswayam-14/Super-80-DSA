// LRU Cache
// Design a data structure that supports the following in O(1):

// 1. get(key) — Return value if key exists, else -1.

// 2. put(key, value) — Insert/Update key. If capacity is full, evict least recently used item.


/*
 * CONCEPTS : 
 HashMap : O(1) access
 Doubly LL to maintain recent usage order
    -> head = most recently used
    -> tail = least recently used
On get/put move node to head
on full capacity, remove from tail
 */

//  Time & Space:
// Time: O(1) for both get() and put()

// Space: O(capacity) for storing key-value pairs

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertToHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            remove(old);
        }
        if(map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
        }
        Node newNode = new Node(key, value);
        insertToHead(newNode);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);      
        cache.put(3, 3);    
        cache.get(2);       
        cache.put(4, 4);  
        cache.get(1);     
        cache.get(3);   
        cache.get(4);     
    }
}
