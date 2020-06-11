/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COSETest;

public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test("", false);
        Test("abc2", false);
        Test("abcdefghijkl2", false);
        Test("abcd!", false);
        Test("abcde", false);
        Test("12345", false);
        Test("abcdefghijj2", false);
        Test("abcdefghihi2", false);
        Test("abcdefghfgh2", false);
        Test("abcdefgdefg2", false);
        Test("abcdefbcdef2", false);
        Test("abcde2abcde2", false);
        Test("abcc2", false);
        Test("2abab", false);
        Test("abcd2", true);
        Test("abcdefghijk2", true);
    }
    
    private static void Test(String testString, boolean expectedResult) {
        SpecialString specialString = new SpecialString(testString);
        boolean result = (expectedResult == specialString.IsValid());
        System.out.println(testString + ":  " + (result ? "PASSED" : "FAILED"));
    }
}
