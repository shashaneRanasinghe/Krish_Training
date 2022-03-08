import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("Please enter a sequence of integers with a space in between the numbers");
        Scanner sc = new Scanner(System.in);
        String sequence = sc.nextLine();
        System.out.println(findMissingNumber(sequence));
    }

    // Returns the missing number of the Sequence
    // If more than one number is missing the first missing number is returned
    public static String findMissingNumber(String sequence) {
        String[] sequenceList = sequence.split(" ");
        List<Integer> intSeqList = new ArrayList<>();
        for (String s : sequenceList) {
            try {
                intSeqList.add(Integer.parseInt(s));
            } catch (NumberFormatException n) {
                return "Please enter valid number series";
            }
        }
        sortList(intSeqList, 0, intSeqList.size() - 1);

        //Checking for a missing number in the middle of the sequence
        for (int i = 0; i < intSeqList.size(); i++) {
            if ((i + 1 < intSeqList.size()) && ((Math.abs(intSeqList.get(i + 1) - intSeqList.get(i))) > 1)) {
                return String.format("The missing number is %d",intSeqList.get(i) + 1);
            }
        }
        //Could be first or last number. The Last number is returned
        return String.format("The missing number is %d",intSeqList.get(intSeqList.size() - 1) + 1);
    }

    public static void sortList(List<Integer> list, int initIndex, int finalIndex) {

        if (initIndex < finalIndex) {
            int midIndex = initIndex + (finalIndex - initIndex) / 2;

            sortList(list, initIndex, midIndex);
            sortList(list, midIndex + 1, finalIndex);

            merge(list, initIndex, midIndex, finalIndex);

        }
    }

    public static void merge(List<Integer> list, int initIndex, int middleIndex, int finalIndex) {
        int sizeOfLeftArray = middleIndex - initIndex + 1;
        int sizeOfRightArray = finalIndex - middleIndex;

        int[] tempLeftArray = new int[sizeOfLeftArray];
        int[] tempRightArray = new int[sizeOfRightArray];

        for (int i = 0; i < sizeOfLeftArray; i++) {
            tempLeftArray[i] = list.get(initIndex + i);
        }
        for (int j = 0; j < sizeOfRightArray; j++) {
            tempRightArray[j] = list.get(middleIndex + 1 + j);
        }

        int i = 0;
        int j = 0;
        int k = initIndex;

        while (i < sizeOfLeftArray && j < sizeOfRightArray) {
            if (tempLeftArray[i] <= tempRightArray[j]) {
                list.set(k, tempLeftArray[i]);
                i++;
            } else {
                list.set(k, tempRightArray[j]);
                j++;
            }
            k++;
        }

        while (i < sizeOfLeftArray) {
            list.set(k, tempLeftArray[i]);
            i++;
            k++;
        }
        while (j < sizeOfRightArray) {
            list.set(k, tempRightArray[j]);
            j++;
            k++;
        }
    }
}

