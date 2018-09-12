public class ReplaceEmptyWithString {
    public void replaceEmptyWithStringUsingTwoPointer(char[] wholeCharacter,int len) {
        int i = len - 1;
        int numberOfSpace = 0;
        for (int k = 0; k < len; k++) {
            if (wholeCharacter[k] == ' ') numberOfSpace++;
        }
        int emptyIndex = i + numberOfSpace * 2;
        while (numberOfSpace > 0) {
            while (wholeCharacter[i] != ' ') {
                wholeCharacter[emptyIndex--] = wholeCharacter[i--];
            }
            if (wholeCharacter[i] == ' ') {
                wholeCharacter[emptyIndex--] = '0';
                wholeCharacter[emptyIndex--] = '2';
                wholeCharacter[emptyIndex--] = '%';
                numberOfSpace--;
                i--;
            }
        }
    }


}
