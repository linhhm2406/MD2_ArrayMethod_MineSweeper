public class MineSweeper {
    public static void main(String[] args) {

        String[][] array = {
                {".", "*", ".", "."},
                {".", ".", "*", "."},
                {".", "*", ".", "."},
                {".", ".", ".", "."}
        };

        final int ARRAY_WIDTH = array[0].length;
        final int ARRAY_HEIGHT = array.length;

        for (int i = 0; i < ARRAY_HEIGHT; i++) {
            for (int j = 0; j < ARRAY_WIDTH; j++) {
                if (array[i][j].equals("*")) {
                    array[i][j] = "*";
                } else {
                    int count = 0;
                    if (j > 0 && j < ARRAY_WIDTH - 1 && i > 0 && i < ARRAY_HEIGHT - 1) {
                        String[] arrayToCheck = {
                                array[i - 1][j - 1], array[i - 1][j], array[i - 1][j + 1],
                                array[i][j - 1], array[i][j + 1],
                                array[i + 1][j - 1], array[i + 1][j], array[i + 1][j + 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (i == 0 && j == 0) {
                        String[] arrayToCheck = {array[i][j + 1], array[i + 1][j], array[i + 1][j + 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (i==0 && j>0 && j< ARRAY_WIDTH-1){
                        String[] arrayToCheck = {array[i][j - 1], array[i][j + 1], array[i + 1][j - 1], array[i + 1][j], array[i + 1][j + 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (j == ARRAY_WIDTH-1 && i ==0){
                        String[] arrayToCheck = {array[i][j - 1], array[i + 1][j - 1], array[i + 1][j]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (j == ARRAY_WIDTH-1 && i>0 && i< ARRAY_HEIGHT-1){
                        String[] arrayToCheck = {array[i - 1][j - 1], array[i - 1][j], array[i][j - 1],array[i + 1][j - 1], array[i + 1][j]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (j == ARRAY_WIDTH-1 && i == ARRAY_HEIGHT-1){
                        String[] arrayToCheck = {array[i - 1][j - 1], array[i - 1][j], array[i][j - 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (i == ARRAY_HEIGHT-1 && j>0 && j < ARRAY_WIDTH-1) {
                        String[] arrayToCheck = {array[i - 1][j - 1], array[i - 1][j], array[i - 1][j + 1], array[i][j - 1], array[i][j + 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (i == ARRAY_HEIGHT-1 && j==0) {
                        String[] arrayToCheck = {array[i - 1][j], array[i - 1][j + 1], array[i][j + 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    if (i>0 && i< ARRAY_HEIGHT-1 && j==0) {
                        String[] arrayToCheck = {array[i - 1][j], array[i - 1][j + 1], array[i][j + 1], array[i + 1][j], array[i + 1][j + 1]};
                        count = count + showArrayAfterCheck(arrayToCheck);
                    }

                    array[i][j] = String.valueOf(count);
                }
            }
        }
        displayArray(array);
    }

    public static void displayArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }

    public static int showArrayAfterCheck(String[] array) {
        int count = 0;
        for (int k = 0; k < array.length; k++) {
            if (array[k].equals("*")) {
                count++;
            }
        }
        return count;
    }
}
