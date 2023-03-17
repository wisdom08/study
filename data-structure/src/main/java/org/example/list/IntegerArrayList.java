package org.example.list;

public class IntegerArrayList implements IntegerListInterface {

    private Integer[] item;
    private int numItems;
    private static final int DEFULT_CAPACITY = 64;

    public IntegerArrayList() {
        item = new Integer[DEFULT_CAPACITY];
        numItems = 0;
    }

    public IntegerArrayList(int n) {
        item = new Integer[n];
        numItems = 0;
    }

    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            throw new RuntimeException();
        }

        for (int i = numItems - 1; i >= index; i--) {
            item[i + 1] = item[i];
        }
        numItems++;
        item[index] = x;

    }

    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            throw new RuntimeException();
        }
        item[numItems++] = x;
    }


    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        }

        Integer temp = item[index];
        for (int i = index; i <= numItems; i++) {
            item[i] = item[i + 1];
        }
        numItems--;

        return temp;
    }

    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0) {
            k++;
        }
        if (k == numItems) {
            return false;
        } else {
            for (int i = k; i <= numItems - 2; i++) {
                item[i] = item[i + 1];
            }
            numItems--;
            return true;
        }
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return item[index];
        }
        return null;
    }

    @Override
    public void set(int index, Integer x) {
        if (index >= 0 && index <= numItems - 1) {
            item[index] = x;
        } else {
            throw new RuntimeException();
        }
    }

    private final int NOT_FOUND = -12345;

    @Override
    public int indexOf(Integer x) {
        for (int i = 0; i < numItems; i++) {
            if (item[i].compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        item = new Integer[item.length];
        numItems = 0;
    }

    public int getNumItems() {
        return numItems;
    }

    public Integer[] getItem() {
        return item;
    }
}
