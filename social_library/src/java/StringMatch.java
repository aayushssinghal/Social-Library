/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.Math;

/**
 * This Library is used to detect the degree of similar-ness between two 
 * strings. It also suggests the possible key, that user may have mistyped.
 * This library will be used for implementing search engine for library.
 * 
 * Features to be covered:
 * exact match, permutation of multi-words words, edit-distance for suggestion,
 * match of subset of words. subwords, whitespace chars, special chars
 * 
 * @author aayush
 */
public class StringMatch {
    private String searchString;
    private String hostString;
/*
    public Interface List<Book> searchResults() {
        List<Book> l = new ArrayList<Book>();
        ResultSet rset = basicLibrary::getAllBooks();
        while (rset.next()) {
            if (exactMatch(searchString, rset.getString(2))) {
                list.add( // TODO
*/
    public boolean exactMatch(String a, String b) {
        if (a == null ? b == null : a.equals(b))
            return true;
        return false;
    }
    
    /**
     * Finds edit distance based on distance for each of 
     * 1. Insert a new character
     * 2. Delete a character
     * 3. Edit a character
     * 
     * @param a     String  one of 2 strings
     * @param b     String  other string
     * @return      int     Edit distance between strings a and b
     */
    public int editDistance(String a, String b) {
        int sizea, sizeb;
        sizea = a.length();
        sizeb = b.length();
        int[][] array = new int[sizea+1][sizeb+1];
        int i,j;
        
        for (i = 0; i <= sizea; i++) {
            array[i][0] = i;
        }
        for (i = 0; i <= sizeb; i++) {
            array[0][i] = i;
        }
        
        for (i = 1; i <= sizea; i++) {
            for (j = 1; j <= sizeb; j++) {
                array[i][j] = 1 + Math.max(array[i-1][j-1], 
                                           Math.max(array[i-1][j], 
                                                    array[i][j-1]));
                if (a.charAt(i) == b.charAt(j)) {
                    array[i][j] = Math.max(array[i][j], array[i-1][j-1]);
                }
            }
        }
        return array[sizea][sizeb];
    }
    
    /**
     * Checks if string key is subword in host string
     * 
     * @param key   String  string to be searched in host string
     * @param host  String  string which is check upon the possibility of 
     *                      containing key string
     * @return      Int     returns 0 based index in string host, if host 
     *                      contains key. otherwise it returns -1
     */
    public int subword(String key, String host) {
        int sizeK, sizeH;
        sizeK = key.length();
        sizeH = host.length();
        int ii, jj;
        boolean flag = false;
        
        for (ii = 0; ii <= sizeH - sizeK; ii++) {
            flag = true;
            for (jj = 0; jj < sizeK; jj++) {
                if (key.charAt(jj) != host.charAt(ii + jj)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }
        return -1;
    }
    
    public String RemoveWhiteSpaceChar(String s) {
        return "null";
    }
    
    public String RemoveSpecialChar(String s) {
        return "null";
    }
    
    public String IgnoreCharacters(String host, String ignore) {
        String s = "";
        int l = host.length();
        for (int i = 0; i<l; i++) {
        //    if (ignore.contains(host[i])) {
                
        //    }
        }
        return "null";
    }
}
