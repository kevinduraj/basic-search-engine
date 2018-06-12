package searchengine;

public class App {

    /*--------------------------------------------------------------------------------------------
     Typical search engine implemeting BTree and Bitmap with 4 document indicating 0,1 
     1 = keyworkd found in in the document id offset 
     0 = keyworkd not found in the document id offset
     */
    public static void main(String[] args) {

        BTree<String, String> index = new BTree<>();

        index.put("aaaa", "0000");
        index.put("bbbb", "0001");
        index.put("cccc", "0010");
        index.put("dddd", "0011");
        index.put("eeee", "0100");
        index.put("ffff", "0101");
        index.put("gggg", "0110");
        index.put("hhhh", "0111");
        index.put("eeee", "1000");
        index.put("jjjj", "1001");
        index.put("kkkk", "1010");
        index.put("llll", "1011");
        index.put("mmmm", "1100");

        System.out.println("aaaa: " + index.get("aaaa"));
        System.out.println("bbbb: " + index.get("bbbb"));
        System.out.println("cccc: " + index.get("cccc"));
        System.out.println("mmmm: " + index.get("mmmm"));

        System.out.println();

        System.out.println("size:    " + index.size());
        System.out.println("height:  " + index.height());

        System.out.println("-----------------------------");
        System.out.println(st);
        System.out.println("-----------------------------");
    }
    /*--------------------------------------------------------------------------------------------*/
}
