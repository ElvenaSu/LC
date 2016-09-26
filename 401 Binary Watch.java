public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num >= 9) {
            return res;
        }
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        for (int i = 0; i <= Math.min(3,num); i++){
            List<String> hours = generateH(i);
            List<Integer> minutes = generateM(num - i);
            for (String hour : hours) {
                for (int tmp : minutes) {
                    String min = tmp < 10 ? "0"+tmp : ""+tmp;
                    res.add(hour.concat(min));
                }
            }
        }
        return res;
    }
    private List<String> generateH(int n) {
        String[] array;
        if (n == 0) {
            array = new String[]{"0:"};
        }else if (n == 1) {
            array = new String[]{"1:","2:","4:","8:"};
        }else if (n == 2) {
            array = new String[]{"3:","5:","6:","9:","10:"};
        }else {
            array = new String[]{"7:","11:"};
        }
        return new ArrayList<String>(Arrays.asList(array));
    }
    private List<Integer> generateM(int n) {
        int[] digits = new int[]{1,2,4,8,16,32};
        List<Integer> minutes = new ArrayList<>();
        if (n == 0) {
            minutes.add(0);
            return minutes;
        }
        helper(digits, minutes, 0, n, 0);
        return minutes;
    }
    private void helper(int[] digits, List<Integer> minutes, int sum, int n, int idx) {
        if (idx > digits.length || sum >= 60) {
            return;
        }
        if (n == 0 && !minutes.contains(sum)) {
            minutes.add(sum);
            return;
        }
        for (int i = idx; i < digits.length; i++) {
            helper(digits, minutes,sum+digits[i], n-1, i+1);//not idx+1 !!!!
        }
    }
}
