package arrayStrings;

public class RotateMatrix {
    public void rotate(int[][] images){
        
        if(images.length == 0 || images[0].length == 0) return;
        int num = images.length; 
        
        for(int i = 0; i < num / 2; i++) {
            for(int j = 0; j < num; j++) {
                int tmp = images[i][j];
                images[i][j] = images[num-i-1][j];
                images[num-1][j] = tmp;   
            }
        }
                
        for(int i = 0; i < num ; i++) {
            for(int j = i; j  < num; j++) {
                int tmp = images[i][j];
                images[i][j] = images[j][i];
                images[j][i] = tmp;   
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] images = {{1,2,3},{4,5,6},{7,8,9}};
        
        RotateMatrix rm = new RotateMatrix();
        
        rm.rotate(images);
        
        for(int i = 0; i < images.length; i++) {
            for(int j = 0; j < images.length; j++) {
                System.out.print(images[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
