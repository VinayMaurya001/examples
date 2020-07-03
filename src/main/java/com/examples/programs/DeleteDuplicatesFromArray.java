package com.examples.programs;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class DeleteDuplicatesFromArray {

	public static void main(String[] args) {
		Integer[] unSortedArray = new Integer[] { 1, 2, 4, 9, 7, 3, 4, 5, 8, 6, 1, 7, 8 };
		// [1, 2, 4, 9, 7, 3, 5, 8, 6]
		System.out.println(Arrays.toString(usingLinkedHashSet(unSortedArray)));
		// [1, 2, 4, 9, 7, 3, 5, 8, 6]
		System.out.println(Arrays.toString(usingJava8StreamApi(unSortedArray)));
		// [1, 2, 4, 9, 7, 3, null, 5, 8, 6, null, null, null]
		System.out.println(Arrays.toString(using2Loops(unSortedArray)));

		Integer[] sortedArray = new Integer[] { 1, 2, 2, 4, 5, 6, 6, 7, 8, 9, 9 };
		// [1, 2, 4, 5, 6, 7, 8, 9, null, null, null]
		System.out.println(Arrays.toString(usingTemporaryArray(sortedArray)));

		//Last index of array 7
		//[1, 2, 4, 5, 6, 7, 8, 9, 8, 9, 9]
		System.out.println("Last index of array "+(usingConstantExtraSpace(sortedArray)-1));
		System.out.println(Arrays.toString(sortedArray));
	}

	private static Integer usingConstantExtraSpace(Integer[] sortedArray) {
		if (sortedArray.length == 0 || sortedArray.length == 1)
			return sortedArray.length;
		int lastIndex = 0;
		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] != sortedArray[i + 1])
				sortedArray[lastIndex++] = sortedArray[i];
		}
		sortedArray[lastIndex++] = sortedArray[sortedArray.length - 1];
		return lastIndex;
	}

	private static Integer[] usingTemporaryArray(Integer[] sortedArray) {
		Integer[] tempArray = new Integer[sortedArray.length];
		int indexJ = 0;
		for (int indexI = 0; indexI < sortedArray.length - 1; indexI++) {
			Integer currentElement = sortedArray[indexI];
			if (currentElement != sortedArray[indexI + 1]) {
				tempArray[indexJ++] = currentElement;
			}
		}
		tempArray[indexJ++] = sortedArray[sortedArray.length - 1];
		return tempArray;
	}

	private static Integer[] usingLinkedHashSet(Integer[] unSortedArray) {
		return new LinkedHashSet<>(Arrays.asList(unSortedArray)).toArray(new Integer[] {});
	}

	private static Integer[] usingJava8StreamApi(Integer[] array) {
		return Arrays.asList(array).stream().distinct().toArray(Integer[]::new);
	}

	private static Integer[] using2Loops(Integer[] array) {
		for (int j = 0; j < array.length - 1; j++) {
			for (int i = j + 1; i < array.length - 1; i++) {
				if (array[j] == array[i]) {
					array[i] = null;
				}
			}
		}
		array[array.length - 1] = null;
		return array;
	}

}
