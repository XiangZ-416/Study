package 左神算法初级班03;

public class Code_15_Array_To_Stack_Queue {
    public static class ArrayStack {
        private Integer[] arr; // 所给的数组
        private Integer index; // 当前位置

        /**
         * 实现栈结构
         * @param initSize 数组长度
         */
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            // 初始化
            arr = new Integer[initSize];
            index = 0;
        }
        // 取（留）
        public Integer peek() {
            if (index == 0) {
                return null;
            }
            // index值不变
            return arr[index - 1];
        }
        // 栈中加数
        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The Stack is full");
            }
            arr[index++] = obj;
        }
        // 取（不留）
        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The Stack is empty");
            }
            // --index：index = index - 1
            return arr[--index];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr; // 所给的数组
        private Integer size; // 已经进来了多少个元素
        private Integer start; // 用户要求取出的元素所在的位置
        private Integer end; // 刚进来的元素应该放在哪个位置

        /**
         * 实现队列结构
         * @param initSize 数组长度
         */
        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            // 初始化
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }
        // 取（留）
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }
        // 存
        public void push(int obj) {
            // size等于数组长度则不能加东西
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            // 否则可以加
            size++;
            arr[end] = obj;
            // 只要end到底，end就回到0位置，end不到底，end++
            end = end == arr.length - 1 ? 0 : end + 1;
        }
        // 取（不留）
        public Integer poll() {
            // 队列已经为空
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {

    }
}
