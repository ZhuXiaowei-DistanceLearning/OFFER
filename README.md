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

   

## 4.栈和队列

1. 用两个栈实现队列：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

2. ```java
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

   

