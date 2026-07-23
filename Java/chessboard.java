class Solution {
    public boolean squareIsWhite(String coordinates) {
        char file = coordinates.charAt(0); // 'a' through 'h'
        char rank = coordinates.charAt(1); // '1' through '8'
        
        // If the sum of the ASCII values of the file and rank is even, it's black. 
        // If it's odd, it's white.
        return (file + rank) % 2 != 0;
    }
}