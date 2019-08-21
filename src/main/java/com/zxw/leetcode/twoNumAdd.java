package com.zxw.leetcode;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class twoNumAdd {
    public static void main(String[] args) {
        twoNumAdd t = new twoNumAdd();
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode listNode = t.Merge(ll, l2);
        System.out.println(listNode);
//     t.minNumberInRotateArray();
    }

    /**
     * 顺时针打印矩阵
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        return null;
    }

    /**
     * 树的子结构
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return true;
    }

    /**
     * 合并两个排序的链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode listNode = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        List<Integer> list = new ArrayList<>();
        while (list1 != null && list2 != null) {
            int val = list1.val;
            int val1 = list2.val;
            list.add(val);
            list.add(val1);
            list1 = list1.next;
            list2 = list2.next;
        }
        Collections.sort(list);
        listNode = new ListNode(list.get(0));
        ListNode listNode1 = listNode;
        for (int i = 1; i < list.size(); i++) {
            listNode1.next = new ListNode(list.get(i));
            listNode1 = listNode1.next;
        }
        return listNode;
    }

    private ListNode getListNode(ListNode listNode, ListNode node) {
        if (listNode == null) {
            listNode = node;
        } else {
            ListNode node1 = listNode;
            while (node1.next != null) {
                node1 = node1.next;
            }
            node1.next = node;
        }
        return listNode;
    }

    /**
     * 反转链表
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode newNode = new ListNode(node.val);
        while (node != null) {
            // 获取原链表的下一个结点
            ListNode next = node.next;
            if (next != null) {
                // 如果使用next会改变原链表的值，造成死循环
                ListNode next2 = new ListNode(next.val);
                next2.next = newNode;
                newNode = next2;
            }
            node = node.next;
        }
        return newNode;
    }

    /**
     * 链表中的第K个结点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode node = head;
        int length = getLength(node);
        while (node != null) {
            if (length == k) {
                return node;
            } else {
                node = node.next;
                length--;
            }
        }
        return node;
    }

    public int getLength(ListNode node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 调整数组顺序使奇数位于偶数面前
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        List<Integer> two = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                two.add(array[i]);
            } else {
                one.add(array[i]);
            }
        }
        for (int i = 0; i < one.size(); i++) {
            array[i] = one.get(i);
        }
        int length = one.size() + 1;
        for (int i = 0; i < two.size(); i++) {
            array[length] = two.get(i);
            length++;
        }
    }

    /**
     * 数值的整数次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        long l1 = System.currentTimeMillis();
        double count = 1;
        if (base != 0 || exponent != 0) {
            while (exponent > 0) {
                count *= base;
                exponent--;
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println(count);
        System.out.println(Math.pow(base, exponent));
        return count;
    }

    /**
     * 二进制中1的个数
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        /*int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;*/
        String s = Integer.toBinaryString(n);
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 矩形覆盖
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        // 被覆盖的目标矩形的形状： 2*n
        // 每次新增加的一列，（1）如果竖着放对应的情况与 target为 n-1 时相同；
        // （2如果横着放，对应的情况与 target 为 n-2 时相同。
        if (target <= 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    /**
     * 变态跳青蛙
     * 易知 f(n)=f(n-1)+f(n-2)+……f(1)
     * f(n-1)=f(n-2)+……f(1)
     * 两式相减得f(n)=2f(n-1)
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int n = 1;
        for (int i = 2; i <= target; i++) {
            n = 2 * n;
        }
        return n;
    }

    /**
     * 跳青蛙
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1, pre2 = 2;
        for (int i = 3; i <= target; i++) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }

    /**
     * 斐波那契
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += feibo(n);
        }
        return sum;
    }

    public int feibo(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return feibo(num - 1) + feibo(num - 2);
        }
    }

    /**
     * 旋转数组,
     */
    public int minNumberInRotateArray(int[] array) {
        // 暴力法
        /*if (array.length == 0) return 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];*/
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    // 将大的数换到前面
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array[0];
    }

    public void changeArr(int[] array) {
        for (int i = 0; i < array.length; i++) {

        }
    }

    /**
     * 栈转队列
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node); // 入栈：1/2/3/4/5。出栈：5/4/3/2/1
    }

    public int pop() {
        if (stack2.size() == 0) {
            for (int i = 0; i < stack1.size(); ) {
                stack2.push(stack1.pop());
            }
        }
        Integer pop = stack2.pop();
        return pop;
    }

    /**
     * 重建二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, in, in.length - 1, in.length);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int start, int[] in, int end, int length) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[start]);
        if (length == 1) {
            return root;
        }
        int i = 0;
        for (; i < length; i++) {
            if (pre[start] == in[end - i]) {
                break;
            }
        }
        root.left = reConstructBinaryTree(pre, start + 1, in, end - i - 1, length - 1 - i);
        root.right = reConstructBinaryTree(pre, start + length - i, in, end, i);
        return root;
    }

    /**
     * 从尾到头的顺序返回一个ArrayList
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ListNode node = listNode;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            list2.add(list.get(i));
        }
        return list2;
    }

    /**
     * 替换空格
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        String string = str.toString();
        String all = string.replaceAll(" ", "%20");
        System.out.println();
        return all;
    }

    /**
     * 数组查找
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int i, j;
        for (i = rowCount - 1, j = 0; i >= 0 && j < colCount; ) {
            if (target == array[i][j]) {
                return true;
            }
            if (target < array[i][j]) {
                i--;
                continue;
            }
            if (target > array[i][j]) {
                j++;
                continue;
            }
        }
        return false;
    }
}
