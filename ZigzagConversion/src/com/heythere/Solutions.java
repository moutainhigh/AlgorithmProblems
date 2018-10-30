package com.heythere;

public class Solutions {
    public String convert(String s, int numRows) {
        int sLength = s.length();
        if (numRows < 1) {
            throw new IllegalArgumentException("行数为：" + numRows + "，此参数非法！");
        }
        if (s.equals("")) {
            return "";
        }

        char[][] zigzagMatrix = new char[numRows][sLength];//二维数组保存变换后的字符
        int charIndex_S = 0;//下一个从s中读出的字符下标
        int matrixRowIndex = 0;//将字符放入矩阵中的行号
        int matrixColumnIndex = 0;//将字符放入矩阵中的列号
        boolean isGoingDown = true;//当前过程实在沿Z字的直边向下或是沿斜边向上？true=向下，false=向上

        while (charIndex_S < sLength) {
            zigzagMatrix[matrixRowIndex][matrixColumnIndex] = s.charAt(charIndex_S);
            charIndex_S++;

            /**
             * 此处仍有bug，如何控制Z字拐弯？
             */
            if ((0 == matrixRowIndex) || (numRows - 1 == matrixRowIndex)) {
                isGoingDown = !isGoingDown;

                if (isGoingDown) {
                    matrixRowIndex++;
                } else {
                    matrixRowIndex--;
                    matrixColumnIndex++;
                }
            }
        }

        StringBuilder buildString = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < sLength; j++) {
                if (s.contains("" + zigzagMatrix[i][j])) {
                    buildString.append(zigzagMatrix[i][j]);
                    if (buildString.length() == sLength) {
                        return buildString.toString();
                    }
                }
            }
        }

        return buildString.toString();
    }
}
