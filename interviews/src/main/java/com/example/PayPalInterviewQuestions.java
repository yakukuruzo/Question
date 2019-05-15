package com.example;

public class PayPalInterviewQuestions {

    // 24.04.2019 Phone Interview
    // Questions:
    // 1. Reverse letters in words: ABC DEF -> CBA FED
    // 2. Android questions. Activity, Fragment, Broadcast Receiver, Content Provider

    //Fraction to Recurring Decimal
    // Given numerator  = 1, denominator = 3 return 0.(3)
    // Given numerator = 1, denominator = 13 return 0.(076923)
    // Given numerator = 10, denominator = 20 return 0.5

    /*
    def fractionToDecimal(self, numerator, denominator):
    n, remainder = divmod(abs(numerator), abs(denominator))
    sign = '-' if numerator*denominator &lt; 0 else ''
    result = [sign+str(n), '.']
    stack = []
    while remainder not in stack:
        stack.append(remainder)
        n, remainder = divmod(remainder*10, abs(denominator))
        result.append(str(n))

    idx = stack.index(remainder)
    result.insert(idx+2, '(')
    result.append(')')
    return ''.join(result).replace('(0)', '').rstrip('.')
    */

    // Print a given matrix in spiral form
    public static void spiralPrint(int m, int n, int a[][]) {
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }
}
