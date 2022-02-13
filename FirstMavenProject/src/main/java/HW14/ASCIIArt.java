package HW14;

public class ASCIIArt {
    private static String[][] mainArray;
    private static final String FILLER = "@";
    private static final String ROW_SPACES = "     ";

    private static String[][] getArrayOfNumber(char aDigit) {
        switch (aDigit) {
            case '0':
                return new String[][]{{" ", FILLER, FILLER, " "}, {FILLER, " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, " "}};
            case '1':
                return new String[][]{{" ", " ", " ", FILLER}, {" ", FILLER, " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}};
            case '2':
                return new String[][]{{" ", FILLER, FILLER, " "}, {FILLER, " ", " ", FILLER}, {" ", " ", FILLER, " "}, {" ", FILLER, " ", " "}, {FILLER, " ", " ", " "}, {FILLER, FILLER, FILLER, FILLER}};
            case '3':
                return new String[][]{{" ", FILLER, FILLER, " "}, {FILLER, " ", " ", FILLER}, {" ", " ", FILLER, " "}, {" ", " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, " "}};
            case '4':
                return new String[][]{{FILLER, " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}};
            case '5':
                return new String[][]{{FILLER, FILLER, FILLER, FILLER}, {FILLER, " ", " ", " "}, {FILLER, FILLER, FILLER, " "}, {" ", " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, " "}};
            case '6':
                return new String[][]{{FILLER, FILLER, FILLER, " "}, {FILLER, " ", " ", " "}, {FILLER, FILLER, FILLER, " "}, {FILLER, " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, " "}};
            case '7':
                return new String[][]{{FILLER, FILLER, FILLER, FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}, {" ", " ", " ", FILLER}};
            case '8':
                return new String[][]{{" ", FILLER, FILLER, " "}, {FILLER, " ", " ", FILLER}, {" ", " ", FILLER, " "}, {FILLER, " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, " "}};
            case '9':
                return new String[][]{{" ", FILLER, FILLER, FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, FILLER}, {" ", " ", " ", FILLER}, {FILLER, " ", " ", FILLER}, {" ", FILLER, FILLER, " "}};
            default:
                return null;
        }
    }

    public static void printNumbers(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            joinArrays(getArrayOfNumber(arr[i]));
        }

        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                System.out.print(mainArray[i][j] + "");
                if ((j + 1) % 4 == 0) {
                    System.out.print(ROW_SPACES);
                }
            }
            System.out.println("");
        }

        mainArray = null;
    }

    private static void joinArrays(String[][] arrayToJoin) {
        if (mainArray == null) {
            mainArray = arrayToJoin;
        } else {
            for (int i = 0; i < mainArray.length; i++) {
                String[] cArr = new String[mainArray[i].length + arrayToJoin[i].length];
                System.arraycopy(mainArray[i], 0, cArr, 0, mainArray[i].length);
                System.arraycopy(arrayToJoin[i], 0, cArr, mainArray[i].length, arrayToJoin[i].length);
                mainArray[i] = cArr;
            }
        }
    }
}
