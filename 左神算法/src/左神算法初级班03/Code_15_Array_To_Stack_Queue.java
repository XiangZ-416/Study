package �����㷨������03;

public class Code_15_Array_To_Stack_Queue {
    public static class ArrayStack {
        private Integer[] arr; // ����������
        private Integer index; // ��ǰλ��

        /**
         * ʵ��ջ�ṹ
         * @param initSize ���鳤��
         */
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            // ��ʼ��
            arr = new Integer[initSize];
            index = 0;
        }
        // ȡ������
        public Integer peek() {
            if (index == 0) {
                return null;
            }
            // indexֵ����
            return arr[index - 1];
        }
        // ջ�м���
        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The Stack is full");
            }
            arr[index++] = obj;
        }
        // ȡ��������
        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The Stack is empty");
            }
            // --index��index = index - 1
            return arr[--index];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr; // ����������
        private Integer size; // �Ѿ������˶��ٸ�Ԫ��
        private Integer start; // �û�Ҫ��ȡ����Ԫ�����ڵ�λ��
        private Integer end; // �ս�����Ԫ��Ӧ�÷����ĸ�λ��

        /**
         * ʵ�ֶ��нṹ
         * @param initSize ���鳤��
         */
        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            // ��ʼ��
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }
        // ȡ������
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }
        // ��
        public void push(int obj) {
            // size�������鳤�����ܼӶ���
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            // ������Լ�
            size++;
            arr[end] = obj;
            // ֻҪend���ף�end�ͻص�0λ�ã�end�����ף�end++
            end = end == arr.length - 1 ? 0 : end + 1;
        }
        // ȡ��������
        public Integer poll() {
            // �����Ѿ�Ϊ��
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
