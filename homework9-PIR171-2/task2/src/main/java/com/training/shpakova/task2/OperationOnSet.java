package com.training.shpakova.task2;

import java.util.HashSet;

public class OperationOnSet<T> {
    HashSet<T> result;

    public OperationOnSet() {
        result = new HashSet<>();
    }

    public HashSet<T> unite(HashSet<T> set, HashSet<T> anotherSet) {
        set.forEach(x -> result.add(x));
        anotherSet.forEach(x -> result.add(x));
        return result;
    }

    public HashSet<T> intersect(HashSet<T> set, HashSet<T> anotherSet) {
        for (T element : set) {
            if (anotherSet.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public HashSet<T> countDifference(HashSet<T> set, HashSet<T> anotherSet) {
        for (T element : set) {
            if (! anotherSet.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public HashSet<T> countSymmetricalDifference(HashSet<T> set, HashSet<T> anotherSet) {
        return unite(countDifference(set, anotherSet), countDifference(anotherSet, set));
    }

}
