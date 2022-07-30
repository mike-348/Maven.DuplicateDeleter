package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] freq = new Integer[array.length];
        int visited = -1;

        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i +1; i< array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    freq[j] = visited;
                }
            }
            if (freq[i] != visited) {
                freq[i] = count;
            }
            // now we have a frequency array;
        }

        return new Integer[0];
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return new Integer[0];
    }
}
