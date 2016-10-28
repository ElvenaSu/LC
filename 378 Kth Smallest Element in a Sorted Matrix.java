public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
    		public int compare (int a, int b) {
    			return b-a;
    		}
    	});
    	int n = matrix.length;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0;  j < n; j++) {
    			if (pq.size() < k) {
    				pq.offer(matrix[i][j]);
    			}else if (pq.peek() > matrix[i][j]) {
    				pq.offer(matrix[i][j]);
    				pq.poll();
    			}
    		}
    	}
    	return pq.peek();
    }
}
//above solution error, idk y...
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e2 - e1;
			}
		};
    	PriorityQueue<Integer> pq = new PriorityQueue<>(k, cmp);
    	int n = matrix.length;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0;  j < n; j++) {
    			if (pq.size() < k) {
    				pq.offer(matrix[i][j]);
    			}else if (pq.peek() > matrix[i][j]) {
    				pq.offer(matrix[i][j]);
    				pq.poll();
    			}
    		}
    	}
    	return pq.peek();
    }
}

Given a n x n matrix where each of the rows and columns are sorted in ascending order,
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.