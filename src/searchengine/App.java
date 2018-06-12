package searchengine;

public class App {

    /*--------------------------------------------------------------------------------------------
     Typical search engine implemeting BTree and Bitmap with 4 document indicating 0,1 
     1 = keyworkd found in in the document id offset 
     0 = keyworkd not found in the document id offset
     */
    public static void main(String[] args) {

        BTree<String, String> index = new BTree<>();

        index.put("apple"     , "10000000");  // indexing terms in document 1
        index.put("orange"    , "01000000");  // indexing terms in document 2
        index.put("cucumber"  , "00100000");  // indexing terms in document 3
        index.put("carrot"    , "00010000");  // indexing terms in document 4
        index.put("artichokes", "00010000");  // indexing terms in document 4

        System.out.println("apple: " + index.get("apple"));
        System.out.println("orange: " + index.get("orange"));
        System.out.println("carrot: " + index.get("carrot"));
        System.out.println("artichokes: " + index.get("artichokes"));

        System.out.println();

        System.out.println("size:    " + index.size());
        System.out.println("height:  " + index.height());
    }
    /*--------------------------------------------------------------------------------------------*/
}
