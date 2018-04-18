package recursion;

import java.util.Stack;

public class TowerHanoi {
    public static void main(String[] args) {
        solve(3, "A", "C", "B");
    }
    
    public static void solve(int n, String fromTower, String toTower, String bufferTower) {
        if(n == 1) {
            System.out.println("move " + n + " from " + fromTower + " to " + toTower);
            return;
        }
        
        solve(n-1 , fromTower, bufferTower, toTower);
        
        System.out.println("move " + n + " from " + fromTower + " to " + toTower);
        
        solve(n-1, bufferTower, toTower, fromTower);
        
    }
}
