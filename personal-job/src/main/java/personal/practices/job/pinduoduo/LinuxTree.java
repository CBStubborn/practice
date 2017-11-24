package personal.practices.job.pinduoduo;

import java.util.*;

/**
 * Created by Stubborn on 2017/9/2.
 */
public class LinuxTree {

    private static Map<String, Integer> nodeOrderMap = new HashMap<>();

    private static Map<Integer, List<String>> nodeChildrenMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String nodeName = line.split(" ")[0];
            int parentNode = Integer.valueOf(line.split(" ")[1]);
            List children = nodeChildrenMap.get(parentNode);
            if (children == null) {
                children = new ArrayList<>();
                nodeChildrenMap.put(parentNode, children);
            }
            children.add(nodeName);
            nodeOrderMap.put(nodeName, i);
        }
        String root = nodeChildrenMap.get(-1).get(0);
        process(root, false, -1);
    }


    private static void process(String node, boolean isLast, int level) {
        int order = nodeOrderMap.get(node);
        if (order == 0) {
            System.out.println(node);
        } else {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            if (!isLast) {
                System.out.println("|-- " + node);
            } else {
                System.out.println("`-- " + node);
            }
        }
        List<String> children = nodeChildrenMap.get(order);
        if (children != null) {
            children.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            ++level;
            for (int i = 0; i < children.size(); i++) {
                if (i == children.size() - 1) {
                    process(children.get(i), true, level);
                } else {
                    process(children.get(i), false, level);
                }
            }
        }
    }
}
