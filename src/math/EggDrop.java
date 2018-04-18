package math;


//A Dynamic Programming based Python Program for the Egg Dropping Puzzle
class EggDrop
{
  // A utility function to get maximum of two integers
  static int max(int a, int b) { return (a > b)? a: b; }
  
  /* Function to get minimum number of trials needed in worst
  case with n eggs and k floors */
  static int eggDrop(int n, int k) {
            
          int[][] eggs = new int[n+1][k+1];
          
          for(int i = 1; i <= n; i++){
              eggs[i][0] = 0;
              eggs[i][1] = 1;
              
          }
          
          for(int i = 1; i <= k; i++){
              eggs[1][i] = i;
          } 
          
          for(int i = 2; i <= n; i++){
              
              for(int j = 2; j <= k; j++){
                  
                  eggs[i][j] = Integer.MAX_VALUE;
                  
                  for(int x = 1; x < j; x++){
                      
                      eggs[i][j] = Math.min(eggs[i][j], 1 + Math.max(eggs[i-1][x-1], eggs[i][j-x]));
                      
                  }
                  
                  
              }
          }
          return eggs[n][k];  
      

  }
      
  /* Driver program to test to pront printDups*/
  public static void main(String args[] )
  {
      
      
      int test = Integer.parseInt(args[0]);
      
      for(int a = 1; a <= test; a++){
          
          String[] strs = args[a].split(" ");
          
          System.out.println(strs.length + "  " + strs[0]);
          int n = Integer.parseInt(args[1].trim());
          int k = Integer.parseInt(args[2].trim());
          
          System.out.println("Minimum number of trials in worst case with "+n+" eggs and "+k+ " floors is "+eggDrop(n, k)); 
      
      }
  }
}