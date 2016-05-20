package searchengine;

/*------------------------------------------------------------------------------------------------*/
public class BTree<Key extends Comparable<Key>, Value> {

    private static final int M = 4;     // Max children per B-tree node = M-1 | minimum = 4
    private Node root;                  // Root of the B-tree
    private int HT;                     // Height of the B-tree
    private int N;                      // Number of key-value pairs in the B-tree

    /*--------------------------------------------------------------------------------------------
     Node Helper 
     B-tree node data type
     */
    private static final class Node {

        private int m;                             // Number of children
        private final Entry[] children = new Entry[M];   // The array of children

        private Node(int k) {
            m = k;
        }             // create a node with k children
    }

    /*--------------------------------------------------------------------------------------------
     Entry Helper Class
     Internal nodes: only use key and next
     External nodes: only use key and value    
     */
    private static class Entry {

        private Comparable key;
        private final Object value;
        private Node next;     // helper field to iterate over array entries

        public Entry(Comparable key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /*--------------------------------------------------------------------------------------------*/
    public BTree() {
        root = new Node(0);
    }

    /*--------------------------------------------------------------------------------------------
     The number of key-value pairs in the B-tree
     */
    public int size() {
        return N;
    }

    /*--------------------------------------------------------------------------------------------
     The height of B-tree
     */
    public int height() {
        return HT;
    }


    /*--------------------------------------------------------------------------------------------
     Search for given key, return associated value; return null if no such key    
     */
    public Value get(Key key) {
        return search(root, key, HT);
    }
    /*--------------------------------------------------------------------------------------------*/

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;

        // external node
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (eq(key, children[j].key)) {
                    return (Value) children[j].value;
                }
            }
        } // internal node
        else {
            for (int j = 0; j < x.m; j++) {
                if (j + 1 == x.m || less(key, children[j + 1].key)) {
                    return search(children[j].next, key, ht - 1);
                }
            }
        }
        return null;
    }
    /*--------------------------------------------------------------------------------------------
     Insert key-value pair
     Add code to check for duplicate keys    
     */

    public void put(Key key, Value value) {
        Node u = insert(root, key, value, HT);
        N++;
        if (u == null) {
            return;
        }

        // need to split root
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        HT++;
    }

    /*--------------------------------------------------------------------------------------------*/
    private Node insert(Node h, Key key, Value value, int ht) {
        int j;
        Entry t = new Entry(key, value, null);

        // external node
        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) {
                    break;
                }
            }
        } // internal node
        else {
            for (j = 0; j < h.m; j++) {
                if ((j + 1 == h.m) || less(key, h.children[j + 1].key)) {
                    Node u = insert(h.children[j++].next, key, value, ht - 1);
                    if (u == null) {
                        return null;
                    }
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--) {
            h.children[i] = h.children[i - 1];
        }
        h.children[j] = t;
        h.m++;
        if (h.m < M) {
            return null;
        } else {
            return split(h);
        }
    }
    /*--------------------------------------------------------------------------------------------
     Split node in half
     */

    private Node split(Node h) {
        Node t = new Node(M / 2);
        h.m = M / 2;
        for (int j = 0; j < M / 2; j++) {
            t.children[j] = h.children[M / 2 + j];
        }
        return t;
    }

    /*--------------------------------------------------------------------------------------------
     Comparison functions - make Comparable instead of Key to avoid casts
     */
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }
    /*--------------------------------------------------------------------------------------------
     Equal
     */

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }
    /*--------------------------------------------------------------------------------------------
     Debugging
     */

    @Override
    public String toString() {
        return toString(root, HT, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        String s = "";
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s += indent + children[j].key + " => " + children[j].value + "\n";
            }
        } else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) {
                    s += indent + "(" + children[j].key + ")\n";
                }
                s += toString(children[j].next, ht - 1, indent + "     ");
            }
        }
        return s;
    }
    /*--------------------------------------------------------------------------------------------*/

}
