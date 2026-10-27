/*
* 1. PROBLEM STATEMENT
*
* You are given a list of N integers. Mr. String understands
* only strings and vowels.
*
* Step 1:
* Convert every number into its English textual representation.
*
* Step 2:
* Count the vowels (a, e, i, o, u) in all the words.
* The total number of vowels is called D.
*
* Note: The number 100 must be represented as "hundred",
* not "one hundred".
*
* Step 3:
* Find the number of unordered pairs in the original array
* whose sum equals D.
*
* Step 4:
* Print the number of valid pairs in lowercase English words.
* If the number of pairs exceeds 100, print "greater 100".
*
* CONSTRAINTS:
* 1 <= N <= 100
* 1 <= nums[i] <= 100
*
* EXAMPLE 1:
* Input:
* 5
* 1 2 3 4 5
*
* Output:
* one
*
* EXPLANATION:
* one   -> 2 vowels
* two   -> 1 vowel
* three -> 2 vowels
* four  -> 2 vowels
* five  -> 2 vowels
*
* D = 2 + 1 + 2 + 2 + 2 = 9
*
* The pair (4, 5) has a sum of 9.
* Total valid pairs = 1
* Output = one
*
* EXAMPLE 2:
* Input:
* 3
* 7 4 2
*
* Output:
* zero
*
* EXPLANATION:
* seven -> 2 vowels
* four  -> 2 vowels
* two   -> 1 vowel
*
* D = 2 + 2 + 1 = 5
*
* No pair sums to 5.
* Total valid pairs = 0
* Output = zero
*
* ============================================================
* 2. APPROACH
*
* 1. Read N and store the input numbers in an integer array.
*
* 2. Convert each number into its English word using the
* numberToWords() method.
*
* 3. Traverse each word character by character using charAt()
* and count the vowels.
*
* 4. Add the vowel counts of all words to calculate D.
*
* 5. Use nested loops to examine every unordered pair.
* Start the inner loop at m + 1 to avoid duplicate pairs.
*
* 6. Count the pairs whose sum equals D.
*
* 7. If the pair count exceeds 100, return "greater 100".
* Otherwise, convert the pair count into words and return it.
*
* ============================================================
* 3. JAVA SOLUTION
* ============================================================
  */

import java.util.Scanner;

public class VowelPairCount {

```
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    System.out.println(stringPair(arr));

    sc.close();
}

// Convert numbers from 0 to 100 into English words
static String numberToWords(int n) {

    String[] words = {
        "zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight",
        "twenty nine", "thirty", "thirty one", "thirty two",
        "thirty three", "thirty four", "thirty five", "thirty six",
        "thirty seven", "thirty eight", "thirty nine", "forty",
        "forty one", "forty two", "forty three", "forty four",
        "forty five", "forty six", "forty seven", "forty eight",
        "forty nine", "fifty", "fifty one", "fifty two",
        "fifty three", "fifty four", "fifty five", "fifty six",
        "fifty seven", "fifty eight", "fifty nine", "sixty",
        "sixty one", "sixty two", "sixty three", "sixty four",
        "sixty five", "sixty six", "sixty seven", "sixty eight",
        "sixty nine", "seventy", "seventy one", "seventy two",
        "seventy three", "seventy four", "seventy five", "seventy six",
        "seventy seven", "seventy eight", "seventy nine", "eighty",
        "eighty one", "eighty two", "eighty three", "eighty four",
        "eighty five", "eighty six", "eighty seven", "eighty eight",
        "eighty nine", "ninety", "ninety one", "ninety two",
        "ninety three", "ninety four", "ninety five", "ninety six",
        "ninety seven", "ninety eight", "ninety nine", "hundred"
    };

    return words[n];
}

// Calculate D and count valid unordered pairs
public static String stringPair(int[] nums) {

    int finalCount = 0;

    // Step 1: Calculate the total number of vowels
    for (int k = 0; k < nums.length; k++) {

        String word = numberToWords(nums[k]);
        int count = 0;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        finalCount += count;
    }

    // Step 2: Count unordered pairs whose sum equals D
    int pairs = 0;

    for (int m = 0; m < nums.length; m++) {

        for (int j = m + 1; j < nums.length; j++) {

            if (nums[m] + nums[j] == finalCount) {
                pairs++;
            }
        }
    }

    // Step 3: Convert the pair count into the required output
    if (pairs > 100) {
        return "greater 100";
    }

    return numberToWords(pairs);
}
```

}
