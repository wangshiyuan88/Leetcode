package freq5;

public class Implement_strStr {
	
//	Implement strStr().
//	Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
	 
	public String strStr(String haystack, String needle) {
		if(haystack==null||needle==null||haystack.length()<needle.length())
			return null;
		int[] needleMap = new int[needle.length()];
		
		for(int before = 0, after = 0; after < needleMap.length; after++){
			if(after!=0){
				if(needle.charAt(before)==needle.charAt(after)){
					needleMap[after] = needleMap[after-1]+1;
				}
			}
		}
		return null;
	}
}
