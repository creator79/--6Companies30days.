/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
            int n = arr.length;
            
            int ind = 1 , max = 0 , prev = arr[0];
            boolean isDec = false , isInc = false;
            
            while(ind < n ){
                int cnt = 0;
                //Count Number of Inceasing Index
                while(ind < n && arr[ind] > prev){
                    isInc = true;
                    prev = arr[ind++];
                    cnt++;
                }
                
                //Count number of dec Index
                while(ind < n && arr[ind] < prev){
                    isDec = true;
                    prev = arr[ind++];
                    cnt++;
                }
                
            
                while((ind < n-1 && arr[ind] == arr[ind+1]) || (ind < n && arr[ind] == prev)){
                    prev = arr[ind++];
                }
                
                //If it is Inc && Dec then only it is mountains => update max
                if(isDec && isInc)
                    max = Math.max(max , cnt + 1);
                isDec = false;
                isInc = false;
                
            }
            
            return max;
            
        }
    }
    