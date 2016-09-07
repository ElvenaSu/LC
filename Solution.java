/*

*/

public class Solution {
    public int getSum(int a, int b) {
        int m = 1;
        int remain = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
             m = m >> i;
             int tmp = a & m + b & m + remain;
             res |= tmp%2;
             remain = tmp/2;
        }
        return res;
    }
}
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int m1 = 0x55555555;
        int m2 = 0x33333333;
        int m4 = 0x0f0f0f0f;
        int m8 = 0x00ff00ff;
        int m16 = 0x0000ffff;
        x = (x & m1) + ((x >> 1) & m1);
        x = (x & m2) + ((x >> 2) & m2);
        x = (x & m4) + ((x >> 2) & m4);
        x = (x & m8) + ((x >> 2) & m8);
        x = (x & m16) + ((x >> 2) & m16);
        return x;
    }
}


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums1) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        for (int num : nums2 ) {
            if (!hm.containsKey(num)) {
                continue;
            }
            hm.put(num, hm.get(num) - 1);
            if (hm.get(num) == 0) {
                hm.remove(Object num);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : hm) {
            for (int i = 0; i < hm.get(num); i++) {
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }
}


public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                    return true;
                }
            }
        }
        return false;
    }
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            if (depth(root.left) == depth(root.right) || Math.abs(depth(root.left) - depth(root.right)) == 1) {
                return true;
            }
        }
        return false;
    }
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right != null && root.left != null) {
            return Math.max(1 + depth(root.left), 1 + depth(root.right));
        }
        if (root.right != null) {
            return 1 + depth(root.right);
        }
        if (root.left != null) {
            return 1 + depth(root.left);
        }
        return 1;
    }  
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (depth(root.left) == depth(root.right) || Math.abs(depth(root.left) - depth(root.right)) == 1) {
            return true;
        }
        return false;
    }
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right != null && root.left != null) {
            return Math.max(1 + depth(root.left), 1 + depth(root.right));
        }
        if (root.right != null) {
            return 1 + depth(root.right);
        }
        if (root.left != null) {
            return 1 + depth(root.left);
        }
        return 1;
    }  
}
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum > 0) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val)||
        hasPathSum(root.right, sum - root.val);
    }
}
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, root, "");
        return res;
    }
    private void helper(List<String> res, TreeNode root, String str){
        if(root == null){
            res.add(str);
            return;
        }
        if (root.left != null) {
            helper(res, root.left, str+"->"+root.left.val);           
        }
        if (root.right != null) {
            helper(res, root.right, str+"->"+root.right.val);
        }
    } 
}


public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    private void helper(char[][] board, int row, int col){
        if(col == board[0].length){
            col = 0;
            row ++;
        }
        if(row == board.length){
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                helper(board, row, col + 1);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col, int number){
        for (int i = 0; i < 9; i++) {
            if(board[row][i] - '0' == number || board[i][col] - '0' == number){
                return false;
            }
        }
        int rowcube = row/3*3, colcube = col/3*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[rowcube + i][colcube + j] - '0' == number){
                    return false;
                }
            }
        }
        return true;
    }
}
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        help(board);
    }
    public boolean help(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board,i, j, c)) {
                            board[i][j] = c;
                            if (help(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int x, int y, char c) {
        
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == c) return false;
            if (board[i][y] == c) return false;
        }
        for (int i = x/3*3; i < x/3*3+3; i++) {
            for (int j = y/3*3; j < y/3*3+3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }
}

public class Solution {
    int res;
    public int totalNQueens(int n) {
        this.res = 0;
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            helper(0, i, n, queens);
        }
        return res;
    }
    private void helper(int layer, int idx, int n, int[] queens){
        queens[layer] = idx;
        if(layer == n - 1){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(layer+1, i, queens))
                helper(layer+1, i, n, queens);
        }

    }
    private boolean isValid(int layer, int idx, int[] queens){
        for (int i = 0; i < layer; i++) {
            if (idx == queens[i] ||
                    Math.abs(layer-i) == Math.abs(queens[i]-idx)) {
                    return false;
            }
        }
        return true;
    }
}

public class Solution {
    public int totalNQueens(int n) {
        int res = 0;
        int[] queen = new int[n];
        for (int i = 0 ; i < n; i++) {
            helper(res, queen, n, 0, i);
        }
        return res;
    }
    private void helper(int res, int[] queen, int n, int layer, int idx){
        queen[layer] = idx;
        if (layer == n-1) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(layer+1, i, queen)){
                helper(res, queen, n, layer+1, i);
            }
        }
    }
    private boolean isValid(int layer, int idx, int[] queen){
        for (int i = 0; i < layer; i++) {
            if(Math.abs(layer - i) == Math.abs(idx - queen[i] || idx == queen[i]){
                return false;
            }
        }
        return true;
    }
}
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queen = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0 ; i < n; i++) {
            helper(res, queen, sb, n, 0, i);
        }
        return res;
    }
    private void helper(List<List<String>> res, int[] queen, StringBuilder sb, int n, int layer, int idx){
        queen[layer] = idx;
        if (layer == n-1) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sb.setCharAt(queen[i], 'Q');
                list.add(sb.toString());
                sb.setCharAt(queen[i], '.');
            }
            res.add(list);
        }
        for (int i = 0; i < n; i++) {
            if(isValid(layer+1, i, queen)){
                helper(res, queen, sb, n, layer+1, i);
            }
        }
    }
    private boolean isValid(int layer, int idx, int[] queen){
        for (int i = 0; i < layer; i++) {
            if((layer - i) == (idx - queen[i]){
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) continue;
                if(helper(i,j, board, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean helper(int i, int j, char[][] board, String word, int idx) {
        if(idx == word.length){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0){
            return false;
        }
        if (word.charAt(idx) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean isExist = helper(i+1, j, board, word, idx+1) ||
                        helper(i-1, j, board, word, idx+1) ||
                        helper(i, j+1, board, word, idx+1) ||
                        helper(i, j-1, board, word, idx+1);
        board[i][j] = temp;
        return isExist;
    }
}


public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = i*fact[i-1];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k--;
        int i = n-1;
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            int idx = k/fact[i];
            sb.append(list.get(idx));
            list.remove(idx);
            i--;
        }
        return sb.toString();
    }
}

Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, "", 0, 0);
        return res;
    }
    private void helper(List<String> res, String s, String cur, int idx, int count){
        if (count == 4 && idx == s.length()) {
            res.add(cur);
        }
        for (int i = 1; i <= 3; i++) {
            if(idx+i <= s.length()){
                String str = s.substring(idx,idx+i);
                if (isValid(str)) {
                    helper(res, s, cur+"."+str, idx+i, count++);
                }
            }    
        }
    }
    private boolean isValid(String str) {
        int result = Integer.parseInt(number);
        if (result > 255) {
            return false;
        }
        return true;
    }
}

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, s, 0, new ArrayList<String>());
        return res;
    }
    private void helper(List<List<String>> res, String s, int idx, ArrayList<String> list) {
        if (idx == s.length()) {
            res.add(list);
            return;
        }
        for (int i = idx+1; i < s.length(); i++) {
            String sub = s.subString(idx, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                helper(res, s, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
/*

*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] mapping = new String[]{"","", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(res, mapping, digits, new StringBuilder(), 0);
        return res;
    }
    private void helper(List<String> res, String[] mapping, String digits, StringBuilder sb, int idx){
        if(idx == digits.length){
            res.add(sb.toString());
            return;
        }
        curString = mapping[(digits.charAt(idx) - '0')].toCharArray();
        for (int i = 0; i < curString.length; i++) {
            helper(res, mapping, digits, str.append(curString[i]), idx+1);
        }
    }
}

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> find = new HashMap<>();
        for (char a : t.toCharArray()) {
            target.put(a, target.getOrDefault(a, 0)+1);
        }
        int i = 0, j = 0, findN = 0, wstart = -1, wend = s.length()-1;
        while (j < s.length()){
            if (target.containsKey(s.charAt(j))) {
                find.put(s.charAt(j), find.getOrDefault(s.charAt(j), 0) + 1);
                if (find.get(s.charAt(j)) == target.get(s.charAt(j)) ) {
                    findN++;
                }
            }
            while(findN == target.size()){
                if (j - i <= wend - wstart){
                    wend = j;
                    wstart = i;
                }
                if(find.containsKey(s.charAt(i))){
                    find.put(s.charAt(i), find.get(s.charAt(i) - 1));
                    if(find.get(s.charAt(i)) < target.get(s.charAt(i))){
                        findN--;
                    }
                }
                i++;
            }
            j++;
        } 
        return wstart == -1? 0 : s.subString(wstart, wend);
    }
}


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= s) {
                return nums.length - i;
            }
        }
        return 0;
    }
}

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j++];
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min;
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, ArrayList<Integer> sub, int[] nums, int idx){
        res.add(new ArrayList<>(sub));
        
        for (int i = idx; i < nums.length; i++) {
            sub.add(nums[i]);
            helper(res, sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        helper(res, new ArrayList<>(), nums, isUsed, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, ArrayList<Integer> sub, int[] nums, boolean[] isUsed, int idx) {
        if (!res.contains(sub)) {
            
        }
          
        for (int i = idx; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !isUsed[i-1]){
                continue;
            }
            sub.add(nums[i]);
            helper(res, sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target,0,0)
    }
    private void helper(List<List<Integer>> res, ArrayList<Integer> comb, int[] candidates, int target, int sum, int idx){
        if(sum == target){
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            comb.add(candidates[i]);
            helper(res, comb, candidates, target, sum+candidates[i], i);
            comb.remove(comb.size()-1);
        }
    }
}

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] isUsed = new boolean[candidates.length];
        helper(res, new ArrayList<>(), candidates, target, 0, 0, isUsed);
        return res;
    }
    private void helper(List<List<Integer>> res, ArrayList<Integer> comb, int[] candidates, int target, int sum, int idx, boolean[] isUsed){
        if (sum == target) {
            res.add(new ArrayList<Integer)(comb));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i-1] && !isUsed[i-1])
                continue;
            comb.add(candidates[i]);
            isUsed[i] = true;
            helper(res, comb, candidates, target, sum+candidates[i],i+1, isUsed);
            comb.remove(comb.size()-1);
            isUsed[i] = false;
        }
    }
}

