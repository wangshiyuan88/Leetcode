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
			}else{
				before = 0;
			}
		}	
		int needleIndex = 0;
		int haystackIndex = 0;
		while(needleIndex<needle.length()&&haystackIndex<haystack.length()){
			if(needle.length()-needleIndex > haystack.length()-haystackIndex)
				return null;
			if(needle.charAt(needleIndex)==haystack.charAt(haystackIndex)){
				needleIndex++;
				haystackIndex++;
			}else{
				if(needleIndex != 0)
					needleIndex = needleMap[needleIndex-1];
				else
					haystackIndex++;
			}
			
		}
		return needleIndex==needle.length()? haystack.substring(haystackIndex - needle.length()) : null;
	}
}
