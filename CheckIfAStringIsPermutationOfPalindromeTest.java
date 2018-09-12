import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfAStringIsPermutationOfPalindromeTest {
    @Test
    void testPermationOfPalindrome() {
        CheckIfAStringIsPermutationOfPalindrome palindrome = new CheckIfAStringIsPermutationOfPalindrome();
        assertTrue(palindrome.isThisStringAPermutationOfAPanlindrome("Tact coa"));
        assertTrue(palindrome.isThisStringAPermutationOfAPanlindrome("adfsjasdffdsajsfda"));
        assertTrue(palindrome.isThisStringAPermutationOfAPanlindrome("A man, a plan, a canal: Panama"));
        assertTrue(palindrome.isThisStringAPermutationOfAPanlindrome("tactcoapapa "));
        assertFalse(palindrome.isThisStringAPermutationOfAPanlindrome("ab"));
    }
    @Test
    void testIsPalindrome()
    {
        CheckIfAStringIsPermutationOfPalindrome palindrome = new CheckIfAStringIsPermutationOfPalindrome();
        assertFalse(palindrome.isPalindrome("race a car"));
    }
}