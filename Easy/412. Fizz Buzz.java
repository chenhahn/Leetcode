// Solution 1
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if(i % 5 == 0) {
                    ans.add("FizzBuzz");
                } else {
                    ans.add("Fizz");
                }
            } else if(i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}

// Solution 2
class Solution {
  public List<String> fizzBuzz(int n) {
    // ans list
    List<String> ans = new ArrayList<String>();

    for (int num = 1; num <= n; num++) {

      boolean divisibleBy3 = (num % 3 == 0);
      boolean divisibleBy5 = (num % 5 == 0);

      String numAnsStr = "";

      if (divisibleBy3) {
        // Divides by 3, add Fizz
        numAnsStr += "Fizz";
      }

      if (divisibleBy5) {
        // Divides by 5, add Buzz
        numAnsStr += "Buzz";
      }

      if (numAnsStr.equals("")) {
        // Not divisible by 3 or 5, add the number
        numAnsStr += Integer.toString(num);
      }

      // Append the current answer str to the ans list
      ans.add(numAnsStr);
    }

    return ans;
  }
}

// Time complexity: O(N)
// Space complexity: O(1)