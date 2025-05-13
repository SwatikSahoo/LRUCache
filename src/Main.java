//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LRUCache<Integer,String> sys= new LRUCache(3);
        sys.put(1,"Value is 1");
        sys.put(2,"Value is 2");
        sys.put(3,"Value is 3");
        System.out.println(sys.get(1));
        System.out.println(sys.get(2));

        sys.put(4,"Value is 4");
        sys.put(2,"Updated Value is 2");
        System.out.println(sys.get(3));
        System.out.println(sys.get(2));

    }
}