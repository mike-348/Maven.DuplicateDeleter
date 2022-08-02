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
        Integer[] visited = new Integer[array.length];
        Integer[] numbers = new Integer[array.length];
        Integer[] counts = new Integer[array.length];
        int result_size = array.length;
        int num_unique_elements = 0;

        for (int i = 0; i < array.length; i++){
            visited[i] = 0;
            numbers[i] = 0;
            counts[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (visited[i] == 1){
                continue;
            }
            int value = array[i];
            visited[i] = 1;
            numbers[num_unique_elements] = value;
            counts[num_unique_elements] = 1;
            for (int j = i + 1; j < array.length; j++) {
                int new_value = array[j];
                if (visited[j] == 1){
                    continue;
                }
                if (new_value == value){
                    visited[j] = 1;
                    counts[num_unique_elements] += 1;
                }
            }
            if (maxNumberOfDuplications <= counts[num_unique_elements]){
                result_size -= counts[num_unique_elements];
            }
            num_unique_elements += 1;



        }
        Integer[] result = new Integer[result_size];
        int index = 0;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] < maxNumberOfDuplications){
                for (int j = 0; j < counts[i]; j++){
                    result[index] = numbers[i];
                    index++;
                }
            }
        }


        return result;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] visited = new Integer[array.length];
        Integer[] numbers = new Integer[array.length];
        Integer[] counts = new Integer[array.length];
        int result_size = array.length;
        int num_unique_elements = 0;

        for (int i = 0; i < array.length; i++){
            visited[i] = 0;
            numbers[i] = 0;
            counts[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (visited[i] == 1){
                continue;
            }
            int value = array[i];
            visited[i] = 1;
            numbers[num_unique_elements] = value;
            counts[num_unique_elements] = 1;
            for (int j = i +1; j < array.length; j++) {
                int new_value = array[j];
                if (visited[j] == 1){
                    continue;
                }
                if (new_value == value){
                    visited[j] = 1;
                    counts[num_unique_elements] += 1;
                }
            }
            if (exactNumberOfDuplications == counts[num_unique_elements]){
                result_size -= exactNumberOfDuplications;
            }
            num_unique_elements += 1;


            // now we have a frequency array;
        }
        Integer[] result = new Integer[result_size];
        int index = 0;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] != exactNumberOfDuplications){
                for (int j = 0; j < counts[i]; j++){
                    result[index] = numbers[i];
                    index++;
                }
            }
        }


        return result;
    }
}
