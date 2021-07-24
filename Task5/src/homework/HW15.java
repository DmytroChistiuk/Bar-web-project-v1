package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HW15 {
    public static void main(String[] args) {
        List<ListNode> list =randomGenerate();
        List<ListNode> list1 = deleteDublicates(list);
        System.out.println(list);
        System.out.println(list1);
    }

    public static ListNode generate() {
        List<Integer> integers = Arrays.asList(2, 3, 4, 5, 5, 5, 2, 56, 123, 436, 67, 34, 2, 2, 234);
        ListNode head = new ListNode(-1);
        ListNode current = head;

        for (Integer integer : integers) {
            current.next = new ListNode(integer);
        }

        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }

        ListNode(int x) {
            val = x;
        }

    }
    public static List<ListNode> randomGenerate() {
        List<ListNode> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 15; i++) {
            ListNode listNode = new ListNode(random.nextInt(10));
            integers.add(listNode);
        }
        return integers;
    }

    public static List<ListNode> deleteDublicates(List<ListNode> listNodes) {
        List<ListNode> list =listNodes;
        List<Integer> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();;
        for (ListNode listNode : list) {
            list1.add(listNode.val);
        }
       List<Integer> list3 =  list1.stream().distinct().collect(Collectors.toList());
        for (Integer element : list3) {
          ListNode listNode = new ListNode(element);
          list2.add(listNode);
        }
        return list2;
    }

}