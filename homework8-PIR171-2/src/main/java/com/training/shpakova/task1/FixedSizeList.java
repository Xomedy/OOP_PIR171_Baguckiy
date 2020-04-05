package com.training.shpakova.task1;

import java.util.*;


public class FixedSizeList<T> implements List<T> {
    private int count;
    transient Object[] array;
    private static final Object[] EMPTY_CAPACITY = {};
    private static final int DEFAULT_CAPACITY = 1;
    private static final int MAX_ARRAY_SIZE = 4;
    protected transient int modCount = 0;

    public FixedSizeList() {
        this.array = EMPTY_CAPACITY;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator iterator() {
        return this.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        try {
            ensureCapacityInternal(count + 1);
        } catch (SizeExcessException e) {
            System.out.println(e.getMessage());
            return false;
        }
        array[count++] = o;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) throws SizeExcessException {
        ensureExplicitCapacity(calculateCapacity(array, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) throws SizeExcessException {
        modCount++;
        if (minCapacity - array.length > 0) {
            gain(minCapacity);
        }
    }

    private void gain(int minCapacity) throws SizeExcessException {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
            throw new SizeExcessException("Attempt to add elements to fulfilled list");
        }
        array = Arrays.copyOf(array, newCapacity);
    }

    private static int calculateCapacity(Object[] data, int minCapacity) {
        if (data == EMPTY_CAPACITY) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private static int hugeCapacity(int minCapacity) {
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < count; index++) {
                if (array[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < count; index++) {
                if (o.equals(array[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = count - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index,
                    numMoved);
        }
        array[--count] = null;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        try {
            ensureCapacityInternal(count + numNew);
        } catch (SizeExcessException e) {
            System.out.println(e.getMessage());
        }
        System.arraycopy(a, 0, array, count, numNew);
        count += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        rangeCheckForAdd(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        try {
            ensureCapacityInternal(count + numNew);
        } catch (SizeExcessException e) {
            System.out.println(e.getMessage());
        }
        int numMoved = count - index;
        if (numMoved > 0) {
            System.arraycopy(array, index, array, index + numNew,
                    numMoved);
        }
        System.arraycopy(a, 0, array, index, numNew);
        count += numNew;
        return numNew != 0;
    }

    private void rangeCheckForAdd(int index) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+count;
    }

    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < count; i++) {
            array[i] = null;
        }
        count = 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; i++) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.copyOf(a, a.length);
    }

}
