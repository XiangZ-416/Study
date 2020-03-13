package 左神算法初级班03;

import java.util.LinkedList;
import java.util.Queue;

public class Code_18_DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    /**
     * 宠物进
     */
    public static class PetEnter {
        private Pet pet; // 当前进的宠物是什么
        private long count; // 是第几个进来的

        // 初始化
        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    /**
     * 猫、狗队列
     */
    public static class DogCatQueue {
        private Queue<PetEnter> dogQ; // 队列里放着宠物进的实例
        private Queue<PetEnter> catQ;
        private long count; // 只要进来一个宠物，count

        // 初始化
        public DogCatQueue() {
            this.dogQ = new LinkedList<PetEnter>();
            this.catQ = new LinkedList<PetEnter>();
            this.count = 0;
        }


        public void add(Pet pet) {
            // 如果是狗
            if (pet.getPetType().equals("dog")) {
                // 狗队列中加入一个宠物进对象，count++
                this.dogQ.add(new PetEnter(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) { // 如果进来的是猫
                this.catQ.add(new PetEnter(pet, this.count++)); // 猫队列中加入一个宠物进对象，count++
            } else { // 不是猫也不是狗
                // 报错
                throw new RuntimeException("err, not dog or cat");
            }
        }

        // 都出
        public Pet pollAll() {
            // 猫不空&&狗也不空
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                // 比较时间戳谁小返回谁
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) { // 狗不空
                return this.dogQ.poll().getPet(); // 返回狗
            } else if (!this.catQ.isEmpty()) { // 猫不空
                return this.catQ.poll().getPet(); // 返回猫
            } else { // 都空
                throw new RuntimeException("err, queue is empty!");
            }
        }

        // 狗出
        public Dog pollDog() {
            if (!this.isDogQueueEmpty()) {
                return (Dog) this.dogQ.poll().getPet(); // 返回一个狗
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        // 猫出
        public Cat pollCat() {
            if (!this.isCatQueueEmpty()) {
                return (Cat) this.catQ.poll().getPet(); // 返回一个狗
            } else
                throw new RuntimeException("Cat queue is empty!");
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }

    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }

}
