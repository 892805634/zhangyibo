package commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.buffer.UnboundedFifoBuffer;
import org.apache.commons.collections4.*;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.LinkedMap;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/3
 * Time:15:41
 */
public class MapTest {

    public static void main(String[] args) {
        /**
         *  map迭代
         *  jdk中的map接口很难进行迭代。api用户总是需要通过entryset或者keyset进行迭代。
         *  commons-collectons现在提供了一个新的接口—mapiterator来允许对maps进行简单的迭代。
         *  */
        IterableMap iterableMap = (IterableMap) new HashMap();
        MapIterator it = iterableMap.mapIterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object value = it.getValue();
            //      it.setValue(newValue);
        }


        /**
         * 得到集合里按顺序存放的key之后的某一Key
         */
        OrderedMap map = new LinkedMap();
        map.put("FIVE", "5");
        map.put("SIX", "6");
        map.put("SEVEN", "7");
        map.firstKey(); // returns "FIVE"
        map.nextKey("FIVE"); // returns "SIX"
        map.nextKey("SIX"); // returns "SEVEN"

        /**
         * BidiMap
         * 通过key得到value
         * 通过value得到key
         * 将map里的key和value对调
         */
        BidiMap bidi = new TreeBidiMap();
        bidi.put("SIX", "6");
        bidi.get("SIX");  // returns "6"
        bidi.getKey("6");  // returns "SIX"
        //       bidi.removeValue("6");  // removes the mapping
        // System.out.println(inverse);

        /**
         * CollectionUtils.retainAll
         * 得到两个集合中相同的元素
         */
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("5");
        Collection c = CollectionUtils.retainAll(list1, list2);
        System.out.println(c);

        /**
         *  buffer接口用来支持队列和缓冲。这些接口表示集合可以定义删除的顺序。
         *  fifo(队列)、lifo(堆栈)和priority（根据比较器的顺序）的接口实现已经被提供。
         */

        Buffer buffer = new UnboundedFifoBuffer();
        buffer.add("one");
        buffer.add("two");
        buffer.add("three");
        buffer.remove();   //removes and returns the next in order,”one” as this is a fifo
        buffer.remove();   //removes and returns the next in order,”two” as this is a fifo
        /**
         * bag接口用于支持bag。它用于表示包含了一个对象的多个拷贝的结合。
         */
        Bag bag = new HashBag();
        bag.add("one", 6); //add 6 copies of “one”
        bag.remove("one", 2);  //removes 2 copies of “one”
        bag.getCount("one");  //returns 4


    }

}

