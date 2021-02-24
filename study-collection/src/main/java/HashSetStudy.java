import java.util.Iterator;
import java.util.Set;

public class HashSetStudy {

    public void hashSetTraversal1(Set sets){
        for(Iterator iterator=sets.iterator();iterator.hasNext();){
            System.out.print(iterator.next());
        }
    }

    public void hashSetTraversal2(Set sets){
        for(Object set:sets){
            System.out.println(set);
        }
    }


}
