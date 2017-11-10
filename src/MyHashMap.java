/**
 * @author Lenovo
 * @date 2017/11/9
 */
public class MyHashMap<K,V> {
     MyHashMap(){
          this.entries = new Entry[8];
          this.size = 8;
          this.used = 0;
          this.mask = 7;
     }
     private Entry<K,V>[] entries;
     private int size;
     private int mask;
     private int used;
     private MyHashMap<K,V> back;
     private int hash(Object key) {
          return key.hashCode();
     }
     private int index(int hash){
          return hash&mask;
     }
     public void put(K k,V v){
          int index = index(hash(k));
          Entry curr = entries[index];
          if (curr == null){
               entries[index] = new Entry();
               entries[index].v=v;
               entries[index].k = k;
               used++;
               return;
          }
          if (curr.k.equals(k)){
               curr.v = v;
               return;
          }
          while (curr.hasNext()){
               curr = curr.next;
               if (curr.k.equals(k)) {
                    curr.v = v;
                    return;
               }
          }
          Entry<K, V> tmp = new Entry<>();
          tmp.k = k;
          tmp.v = v;
          curr.next = tmp;
          used++;
     }
     public V get(K k){
          int index = index(hash(k));
          Entry<K,V> curr = entries[index];
          if (curr == null){
               return null;
          }
          if (k.equals(curr.k)){
              return curr.v;
          }
          while (curr.hasNext()){
               curr = curr.next;
               if (curr.k.equals(k)){
                    return curr.v;
               }
          }
          return null;
     }

     class Entry<K,V>{
           K k;
          V v;
          Entry<K,V> next;
          boolean hasNext(){
               return next==null?false:true;
          }


     }

     public static void main(String[] args) {
          MyHashMap<String, String> myHashMap = new MyHashMap<>();
          myHashMap.put("name","张三");
          myHashMap.put("name","李四");
          myHashMap.put("age","18");
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("age"));
          System.out.println(myHashMap.get("age1"));




     }

}

