package bit;



//Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
//pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will
//be split across rows). The height of the screen, of course, can be derived from the length of the array
//and the width. Implement a function that draws a horizontal line from (xl, y) to (x2 J y) .
//The method signature should look something like:
//drawLine(byte[] screen, int width, int xl, int x2, int y)
//Hints: #366, #381, #384, #391
//Additional

public class DrawLine {
    
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
        
        int start = x1 / 8 ;
        int off_s = x1 % 8 ;
        
        int end = x2 / 8;
        int off_e = x2 % 8;
        
        if(start == end) {
            drawOne(screen, width, start, off_s, off_e, y);
            return;
        }
        
        drawOne(screen, width, start, off_s, 7, y);
        
        for(int i = start+1; i <= end-1; i++) {
            drawOne(screen, width, i, 0, 7, y);
        }
        
        drawOne(screen, width, end, 0, off_e, y);
    }

    private static void drawOne(byte[] screen, int width, int start, int off_s, int off_e, int y) {
        // TODO Auto-generated method stub
        
    }
}
