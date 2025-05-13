import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private final int capacity;
    private final Map<K, Node<K,V>> cache;
    private final Node<K,V> head;
    private final Node<K,V> tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next=tail;
        tail.prev=head;
    }
    public synchronized V get(K key){
        Node<K,V> node= cache.get(key);
        if (node==null){
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node<K,V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node<K,V> node) {
        node.prev=head;
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
    }

    private void removeNode(Node<K,V> node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=null;
        node.prev=null;
    }
    public synchronized void put(K key, V value){
        Node<K,V> node=cache.get(key);
        if (node==null){
            node= new Node<>(key,value);
            addToHead(node);
            cache.put(key,node);
            if (cache.size()>capacity){
                Node<K,V> removeNode=removeTail();
                cache.remove(removeNode.key);
            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }

    private Node<K,V> removeTail() {
        Node<K,V> node=tail.prev;
        removeNode(node);
        return node;
    }

}
