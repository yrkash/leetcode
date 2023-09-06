package ru.yrkash.task380;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomizedSet {
    private HashSet<Integer> set;

    public RandomizedSet() {
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(set.size());
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < randomIndex; i++) {
            iterator.next();
        }
        return iterator.next();
    }
}
