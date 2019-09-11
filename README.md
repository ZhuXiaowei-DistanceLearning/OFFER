# 剑指offer

## 1.查找

1. 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

   ```java
   public class Solution {
       public boolean Find(int target, int [][] array) {
            for(int i=0;i<array.length;i++){
                int low = 0;
                int high = array[i].length -1;
                while(high>=low){
                     int mid = (low + high)/2;
                    if(target>array[i][mid]){
                        low = mid +1;
                    }else if(target<array[i][mid]){
                        high = mid -1;
                    }else{
                        return true;
                    }
                }
            }
           return false;
       }
   }
   ```

2. 旋转数组的最小数字：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
   输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0

   ```java
   for (int i = 0; i < array.length; i++) {
               for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                       int temp = array[j];
                       // 将大的数换到前面
                       array[j] = array[i];
                       array[i] = temp;
                   }
               }
           }
           return array[0];
   ```

   

## 2.字符串

1. 替换空格：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

   ```java
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
   ```

2. 

## 3.树

1. 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

   ```
   
   ```

2. 树的子结构：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

   ```
   
   ```

3. 从上到下打印二叉树

   ```java
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
           ArrayList<Integer> list = new ArrayList<>();
           if (root == null) {
               return list;
           }
           Queue<TreeNode> q = new LinkedList<>();
           q.add(root);
           while (!q.isEmpty()) {
               // 结点出队
               TreeNode poll = q.poll();
               // 处理当前结点
               list.add(poll.val);
               if (poll.left != null) {
                   q.add(poll.left);
               }
               if (poll.right != null) {
                   q.add(poll.right);
               }
           }
           return list;
       }
   ```

4. 二叉搜索树的后序遍历序列：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

   ```
   
   ```

5. 二叉树中和为某一值得路径：输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

   ```
   
   ```

   

## 4.栈和队列

1. 用两个栈实现队列：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

   ```java
   Stack<Integer> stack1 = new Stack<Integer>();
       Stack<Integer> stack2 = new Stack<Integer>();
   
       public void push(int node) {
           stack1.push(node); // 入栈：1/2/3/4/5。出栈：5/4/3/2/1
       }
   	// 利用后进先出的道里，将栈1的数据弹出到栈2，就变成了先进先出 
       public int pop() {
           if(stack2.size()==0){
               for (int i = 0; i < stack1.size();) {
                   stack2.push(stack1.pop());
               }
           }
           Integer pop = stack2.pop();
           return pop;
       }
   ```

2. 包含min函数的栈：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

   ```java
    Stack<Integer> stackTotal = new Stack<Integer>();
       Stack<Integer> stackLittle = new Stack<Integer>();
   
       public void push(int node) {
           stackTotal.push(node);
           if(stackLittle.empty()){
               stackLittle.push(node);
           }else{
               if(node <= stackLittle.peek()){
                   stackLittle.push(node);
               }else{
                   stackLittle.push(stackLittle.peek());
               }
           }
       }
   
       public void pop() {
           stackTotal.pop();
           stackLittle.pop();
       }
   
       public int top() {
           return stackTotal.peek();
       }
   
       public int min() {
           return stackLittle.peek();
       }
   
   ```

3. 栈的压入、弹出序列：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

   ```java
   	public boolean IsPopOrder(int[] pushA, int[] popA) {
           if (pushA.length == 1 && popA.length == 1) {
               if (popA[0] == pushA[0]) {
                   return true;
               }
               return false;
           }
           int length = 0;
           for (int i = 1; i < pushA.length - 1; i++) {
               if (popA[i] < popA[i + 1] && popA[i] < popA[i - 1]) {
                   return false;
               }
           }
           return true;
       }
   
   ```

   

## 5.链表

1. 从尾到头打印链表：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

   ```java
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
   
   ```

2. 链表中倒数第K个结点:输入一个链表，输出该链表中倒数第k个结点。

   ```java
    public ListNode FindKthToTail(ListNode head, int k) {
           ListNode node = head;
           int length = getLength(node);
           while (node != null) {
               if (length == k) {
                   return node;
               }else{
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
   
   ```

3. 反转链表：输入一个链表，反转链表后，输出新链表的表头。

   ```java
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
   
   ```

4. 合并两个排序的链表：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

   ```java
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
   
   ```

## 6.递归和循环

1. 斐波那契：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0。n<=39

   ```java
   // 递归效率跟不上 
   public int Fibonacci(int n) {
           int a = 0;
           int b = 1;
           int t = 0;
          if(n==1){return 1;};
           for(int i=2;i<=n;i++){
               t = a+b;
               a = b;
               b = t;
           }
           return t;
       }
   
   ```

2. 跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

   ```java
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
   
   ```

3. 变态跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

   ```java
    	/**
        * 变态跳青蛙
        *易知 f(n)=f(n-1)+f(n-2)+……f(1)
        * f(n-1)=f(n-2)+……f(1)
        * 两式相减得f(n)=2f(n-1)
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
   
   ```

4. 矩形覆盖：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

   ```java
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
   
   ```

## 7.位运算

1. 二进制中1的个数：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

   ```java
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
               if(array[i]=='1'){
                   count++;
               }
           }
           return count;
       }
   
   ```

## 8.数学运算

1. 数值的整数次方：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0

   ```java
    public double Power(double base, int exponent) {
           return Math.pow(base,exponent);
     }
   
   ```

## 9.数组

1. 调整数组顺序使奇数位于偶数前面：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

   ```java
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
   
   ```

2. 顺时针打印数组：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

   ```java
    public ArrayList<Integer> printMatrix(int[][] matrix) {
           int length = matrix.length;
        ArrayList list = new ArrayList();
           if (matrix == null || matrix.length == 0) {
               return list;
           }
           int up = 0;
           int down = matrix.length - 1;
           int left = 0;
           int right = matrix[0].length - 1;
           while (true) {
               for (int i = left; i <= right; i++) {
                   list.add(matrix[up][i]);
               }
               if (++up > down) {
                   break;
               }
               for (int i = up; i < down - 1; i++) {
                   list.add(matrix[i][right]);
               }
               if (--right < left) {
                   break;
               }
               for (int i = right - 1; i >= 0; i++) {
                   list.add(matrix[down][i]);
               }
               if (--down < up) {
                   break;
               }
               for (int i = down; i >= up; i--) {
                   list.add(matrix[i][left]);
               }
               if (++left > right) {
                   break;
               }
           }
           return list;
       }
   
   ```

   

