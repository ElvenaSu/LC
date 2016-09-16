
public class solution {
	public static void main(String[] args){
	       Scanner sc = new Scanner(System.in);
           for (int i = 0; i < m; i++) {
               String input = sc.nextLine();
               String output = findthisLine(input);

               System.out.println(output);
           }
	}
    public String findthisLine(String input) {
        if (input == null || input.length == 0) {
            return "";
        }
        String[] strArray = input.spilt("\\s+");
        for (String str : strArray) {
            int size = str.length();
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (hs.add(str.charAt(i))) {
                    asc[(int)str.charAt(i)]++;
                }
            }
        }
        int linesize = strArray.length;
        StringBuider output = new StringBuider();
        for (int i = 0; i < 128; i++) {
            if (asc[i] == linesize) {
                output.append((char)i);
            }
        }
        return output.toString();
    }
}
