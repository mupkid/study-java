import java.util.Iterator;
import java.util.Map;

public class HashMapStudy {

    public void hashMapTraversal1(Map maps){
        for(Iterator iterator=maps.entrySet().iterator();iterator.hasNext();){
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key =entry.getKey();
            Object val = entry.getValue();

        }
    }

    public void hashMapTraversal2(Map maps){
        for(Iterator iterator=maps.keySet().iterator();iterator.hasNext();){
            Object key=iterator.next();
            Object val=maps.get(key);
        }
    }

    public void hasMapTraversal3(Map maps){
        for(Object key:maps.keySet()){
            Object val=maps.get(key);
        }
    }

    public void hasMapTraversal4(Map maps){
//        for(Map.Entry<Object,Object> entry:maps.entrySet()){
//            Object key=entry.getKey();
//            Object val=entry.getValue();
//        }
    }
}
