public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList<>();
    	HashMap<String, List<String>> map = new HashMap<>();
    	for (String str : strs) {
    		char[] tmp = str.toCharArray();
    		Arrays.sort(tmp);
    		//这行很简洁啊
    		String keyStr = String.valueOf(tmp);
    		if (!map.containsKey(keyStr)) {
    			map.put(keyStr, new ArrayList<String>());
    		}
    		map.get(keyStr).add(str);
    	}
    	//这行也很简洁啊，要对java的语法够熟悉才行啊
    	return new ArrayList<List<String>>(map.values());
    }
}

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]