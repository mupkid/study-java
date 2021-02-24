import java.util.Iterator;
import java.util.List;

public class ArrayListStudy {

    public void arrayListTraversal1(List<Integer> lists){
        System.out.println("原始的for循环形式");
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }
        System.out.println();
    }
    public void arrayListTraversal2(List<Integer> lists){
        System.out.println("foreach的遍历方式");
        for(int list:lists){
            System.out.println(list);
        }
        System.out.println();
    }
    public void arrayListTraversal3(List<Integer> lists){
        System.out.println("迭代器遍历");
        for(Iterator<Integer> list=lists.iterator();list.hasNext();){
            System.out.println(list.next());
        }
        System.out.println();
    }
}
