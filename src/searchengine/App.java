package searchengine;

public class App {

    /*--------------------------------------------------------------------------------------------
     Typical search engine implemeting BTree and Bitmap with 4 document indicating 0,1 
     1 = keyworkd found in in the document id offset 
     0 = keyworkd not found in the document id offset
     */
    public static void main(String[] args) {

        BTree<String, String> st = new BTree<>();

        st.put("aaaa", "0000");
        st.put("bbbb", "0001");
        st.put("cccc", "0010");
        st.put("dddd", "0011");
        st.put("eeee", "0100");
        st.put("ffff", "0101");
        st.put("gggg", "0110");
        st.put("hhhh", "0111");
        st.put("eeee", "1000");
        st.put("jjjj", "1001");
        st.put("kkkk", "1010");
        st.put("llll", "1011");
        st.put("mmmm", "1100");

        System.out.println("aaaa: " + st.get("aaaa"));
        System.out.println("bbbb: " + st.get("bbbb"));
        System.out.println("cccc: " + st.get("cccc"));
        System.out.println("mmmm: " + st.get("mmmm"));

        System.out.println();

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());

        System.out.println("-----------------------------");
        System.out.println(st);
        System.out.println("-----------------------------");
    }
    /*--------------------------------------------------------------------------------------------*/
}
