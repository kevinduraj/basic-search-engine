Search Engine Implementation
============================

* Output

```
 Typical search engine implemeting BTree and Bitmap with 4 document indicating 0,1 
     1 = keyworkd found in in the document id offset 
     0 = keyworkd not found in the document id offset

aaaa: 0000
bbbb: 0001
cccc: 0010
mmmm: 1100

size:    13
height:  2
-----------------------------
          aaaa => 0000
          bbbb => 0001
     (cccc)
          cccc => 0010
          dddd => 0011
     (eeee)
          eeee => 0100
          eeee => 1000
          ffff => 0101
     (gggg)
          gggg => 0110
          hhhh => 1111
     (jjjj)
          jjjj => 1001
          kkkk => 1010
     (llll)
          llll => 1011
          mmmm => 1100


-----------------------------
```

