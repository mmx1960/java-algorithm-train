/**
 * @author Lenovo
 * @date 2017/11/9
 */
public class MyHashMap<K,V> {
     private static int INIT_SIZE = 2;
     private static int THREAD_HOLD = 5;
     MyHashMap(){
          this.entries = new Entry[INIT_SIZE];
          this.size = INIT_SIZE;
          this.used = 0;
          this.mask = size-1;
          this.rehashidx = -1;
     }
     MyHashMap(int size){
          this.entries = new Entry[size];
          this.size = size;
          this.used = 0;
          this.mask = size-1;
          this.rehashidx = -1;
     }
     private Entry<K,V>[] entries;
     private int size;
     private int mask;
     private int used;
     private int rehashidx;
     private MyHashMap<K,V> back;
     private int hash(Object key) {
          return key.hashCode();
     }
     private int index(int hash){
          return hash&mask;
     }

     public void put(K k,V v){
          //扩展&收缩处理
          if((used/size)>=THREAD_HOLD){
               //此时需要扩展
               //计算新表大小
               if (back == null){
                    int i = 0;
                    while (used>>(++i)>0){

                    }
                    int newSize =1<<i;
                    back = new MyHashMap<>(newSize);
                    //标志开始rehash
                    this.rehashidx = 0;
               }
               transToNewTable();
               putToEntries(back,k,v);
               return;
          }
          putToEntries(this,k,v);

     }

     private void transToNewTable() {
          if (this.rehashidx<this.used){
               for (int i = 0 ;i<this.size;i++){
                    Entry<K, V> tmp = this.entries[i];
                    if (tmp != null){
                        this.entries[i] = tmp.next;
                         int index = back.index(tmp.k.hashCode());
                         Entry<K, V> btmp = back.entries[index];
                         tmp.next = btmp;
                         back.entries[index] = tmp;
                         back.used++;
                         this.rehashidx++;
                         break;
                    }
               }
               return;
          }
          copyEntries();
          this.rehashidx = -1;
     }

     private void copyEntries() {
          this.entries = back.entries;
          this.size = back.size;
          this.used = back.used;
          this.mask = back.mask;
          back.entries = null;
          back = null;
     }

     private void putToEntries(MyHashMap map, K k, V v) {
          //计算索引
          int index = map.index(hash(k));
          Entry curr = map.entries[index];
          if (curr == null){
               map.entries[index] = new Entry();
               map.entries[index].v=v;
               map.entries[index].k = k;
               map.used++;
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
          //扩展&收缩处理
          if((used/size)>THREAD_HOLD&&back!=null){
               transToNewTable();
               V ret = getEntries(this, k);
               if (ret!= null){
                    //rehash移动原来表kv到新表
                     return ret;
               }

               return getEntries(back,k);
          }

          return getEntries(this,k);
     }
     private V getEntries(MyHashMap map, K k) {
          int index = map.index(hash(k));
          Entry<K,V> curr = map.entries[index];
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
          MyHashMap<String, String> myHashMap = new MyHashMap<>(2);
          myHashMap.put("name","张三");
          myHashMap.put("name1","李四");
          myHashMap.put("name2","李四");
          myHashMap.put("name3","李四");
          myHashMap.put("name4","李四");
          myHashMap.put("name5","李四");
          myHashMap.put("name6","李四");
          myHashMap.put("name7","李四");
          myHashMap.put("name8","李四");
          myHashMap.put("name9","李四");
          myHashMap.put("name10","李四");
          myHashMap.put("name11","李四");
          myHashMap.put("name12","李四");
          myHashMap.put("name13","李四");
          myHashMap.put("name14","李四");
          myHashMap.put("name15","李四");
          myHashMap.put("name16","李四");
          myHashMap.put("name17","李四");

          myHashMap.put("age","18");
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name1"));
          System.out.println(myHashMap.get("name2"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name2"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name"));
          System.out.println(myHashMap.get("name1"));
          System.out.println(myHashMap.get("name"));




     }

}

