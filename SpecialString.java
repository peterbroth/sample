/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COSETest;

/**
 *
 * @author peter
 */
public class SpecialString {
    // These constants indicate the string's range of length.
    final private int minStringLength = 5;
    final private int maxStringLength = 12;

    // This holds the string to validate.
    public String Value;

    public SpecialString() {
        Value = "";
    }

    public SpecialString(String initialValue) {
        Value = initialValue;
    }

    /*
    This method runs a series of checks to determine if it is valid or not.
    */
    public boolean IsValid() {
        // Make sure that the string has 5 to 12 characters.
        int strLen = Value.length();
        if((strLen < minStringLength) || (strLen > maxStringLength)) return false;
        
        // Make sure that the string contains only alphanumeric characters,
        // with at least one letter and one digit (in any language).
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int position = 0; position < strLen; position++) {
            char character = Value.charAt(position);
            if (Character.isLetter(character)) hasLetter = true;
            else if (Character.isDigit(character)) hasDigit = true;
            else return false;
        }
        if(!hasLetter || !hasDigit) return false;
        
        // Make sure that the string does not contain any sequence
        // of characters immediately followed by the same sequence.
        String thisSub, lastSub;
        int halfLen = strLen / 2;
        for (int sequenceLen = 1; sequenceLen <= halfLen; sequenceLen++) {
            int maxPosition = strLen - sequenceLen;
            for (int position = sequenceLen; position <= maxPosition; position++) {
                thisSub = Value.substring(position, position + sequenceLen);
                lastSub = Value.substring(position - sequenceLen, position);
                if(thisSub.equals(lastSub)) return false;
            }
        }
        
        // If all checks have passed, return true.
        return true;
    }
}
