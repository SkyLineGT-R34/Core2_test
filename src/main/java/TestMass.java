import java.util.*;

import static java.lang.System.currentTimeMillis;

public class TestMass {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Random random = new Random(currentTimeMillis());
        for (int i=0; i<10000000; i++) {
            list1.add(random.nextInt(10000000));
            list2.add(random.nextInt(10000000));
        }
        Long time1 = currentTimeMillis();
        System.out.println("мой вариант " + (set_test_grigorii(list1,list2) - time1));
        time1 = currentTimeMillis();
        System.out.println("вариант юко " + (set_test_yuko(list1,list2) - time1));
        time1 = currentTimeMillis();
        System.out.println("вариант map " + (set_test_map(list1,list2) - time1));
    }
    public static long set_test_grigorii(List<Integer> list1, List<Integer> list2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer integer : list1) {
            if (!set1.add(integer)) {
                set2.add(integer);
            }
        }
        for (Integer integer : list2) {
            if (!set1.add(integer)) {
                set2.add(integer);
            }
        }
        set1.removeAll(set2);
        return currentTimeMillis();
    }
    public static long set_test_yuko(List<Integer> list1, List<Integer> list2){
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        Set<Integer> set3 = new HashSet<>(set1);
        set1.removeAll(set2);
        set2.removeAll(set3);
        set1.addAll(set2);
        return currentTimeMillis();
    }

    public static long set_test_map(List<Integer> list1, List<Integer> list2){
        Map<Integer,Integer> map = new HashMap<>();
        list1.addAll(list2);
        for (int value:list1){
            map.merge(value, 1, (prev, one) -> prev + one);
        }
        Iterator<Map.Entry<Integer, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = entryIterator.next();
            if (entry.getValue() > 1) {
                entryIterator.remove();
            }
        }
        return currentTimeMillis();
    }
}
