Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

public class Solution {
    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<>();
    	String[] paths = path.split("/");
    	for (String str : paths) {
    		if (str.equals("..")) {
    			if(!stack.empty()){
    			    stack.pop();
    			}
    			continue;
    		}
    		if (str.equals(".") || str.equals("")) {
    			continue;
    		}
    		stack.push(str);
    	}
    	String res = "";
    	while (!stack.empty()) {
    		res = "/" + stack.pop()+res;
    	}
    	return res.length() == 0 ? "/" : res;
    }
}