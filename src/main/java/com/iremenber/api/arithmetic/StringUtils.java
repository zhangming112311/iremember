package com.iremenber.api.arithmetic;



import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class StringUtils {
	/**
	 * 判断字符串中是否有重复字符
	 * @param str
	 * @return
	 */
	public static boolean checkDuplicationString(String str) {
		byte[] bs = new byte[100000];
		char[] ch = str.toCharArray();
		for(char c:ch) {
			if(bs[c] == 1) {
				return true;
			};
			bs[c] = 1;
		}
		return false;
	}
/**
 * 判断是否是变位词（要确定是否区分大小写，空格算不算，字符集大小）
 * 1，排序，然后比较
 * 2，使用数组计数然后比较数量
 */
	public static  boolean checkAnagram(String str1,String str2){
		if (str1.length() != str2.length()){
			return false;
		}
		Map<Character,Integer> map1 = getCharCount(str1);
		Map<Character,Integer> map2 = getCharCount(str2);

		Iterator<Map.Entry<Character, Integer>> it1 = map1.entrySet().iterator();
		Iterator<Map.Entry<Character, Integer>> it2 = map2.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry<Character, Integer> e1 = it1.next();
			if (!it2.hasNext()){
				return false;
			}
			Map.Entry<Character, Integer> e2 = it2.next();
			if(!e1.getKey().equals(e2.getKey()) || !e1.getValue().equals(e2.getValue())){
				return false;
			}
		}
		return true;
	}
	public static Map<Character,Integer> getCharCount(String str){
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		char[] ch = str.toCharArray();
		for(char c:ch) {
			if (map.containsKey(c)){
				map.put(c,map.get(c) + 1);
			}else{
				map.put(c,1);
			}
		}
		return map;
	}
	public static String reverse(String str){
		char[] s = str.toCharArray();
		char tmp = 0;
		int end = s.length - 1;
		int start = 0;
		while (end > start){
			tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			end --;
			start ++;
		}
		return new String(s);
	}
	public static String replaceSpaces(char[] cs){
//		%20
		int length = cs.length;
		int newlength = cs.length;
		for(char c:cs){
			if(c == ' '){
				newlength =+ 2;
			}
		}
		cs[newlength] = '\0';
		for (int i = length-1;i >= 0; i--){
			if (cs[i] == ' '){
				cs[newlength - 1] = '0';
				cs[newlength - 1] = '2';
				cs[newlength - 1] = '%';
				newlength =- 3;
			}else{
				cs[newlength - 1] = cs[i];
				newlength --;
			}
		}
		return new String(cs);
	}

	/**
	 * 原始字符串压缩功能 aaabbbcccc   a3b3c4
	 * @param str
	 * @return
	 */
	public static String compressString(String str){
		char[] cs = str.toCharArray();
		String res = String.valueOf(cs[0]);
		char last = cs[0];
		int count = 0;
		for(char c:cs){
			if (c == last){
				count ++;
			}else{
				res += count + "" + c;
				count = 1;
				last = c;
			}
		}
		res += count;
		return res;
	}

	/**
	 * 使用stringBuffer优化版本
	 * @return
	 */
	public static  String bufferCompressString(String str){
		char[] cs = str.toCharArray();
		StringBuffer sb =  new  StringBuffer(cs[0]);
		char last = cs[0];
		int count = 0;
		for(char c:cs){
			if (c == last){
				count ++;
			}else{
				sb.append(count).append(c);
				count = 1;
				last = c;
			}
		}
		sb.append(count);
		return sb.toString();
	}
	public static int[][] transposition(int[][] p){
		int[][] r = new int[p.length][p.length];
		for (int i = 0;i < p.length; i++){
			for (int j = 0;j< p[i].length; j ++){
//				r.
			}
		}
		return null;
	}
	/**
	 * 使用字符数组压缩字符串
	 * @return
	 */
	public static String arrayCompressString(){
		return null;
	}

}
