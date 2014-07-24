package t;

import java.util.ArrayList;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		int start = 0;
		while(start<words.length){
			int wordNum = getWordNum(start, words, L);
			StringBuilder sb = new StringBuilder();
			if(wordNum==1||(wordNum + start)==words.length){	
				for(int i = 0; i < wordNum; i++){
					sb.append(words[i+start]);
					if(i!=wordNum-1){
						sb.append(" ");
					}
				}
				int numSpaceAtEnd = L- sb.length();
				for(int i = 0; i< numSpaceAtEnd;i++){
					sb.append(" ");
				}
				start += wordNum;
			}
			else{
				int totalSpace = 0;
				int wordLength = 0;
				for(int i = start; i < start+wordNum; i++){
					wordLength += words[i].length();
				}
				sb.append(words[start++]);
				totalSpace = L - wordLength;
				for(int gapNeeded = wordNum - 1; gapNeeded > 0 ; gapNeeded--){
					int space = (int)Math.ceil(((double)totalSpace)/((double)gapNeeded));
					for(int spaceLeft = space; spaceLeft>0;spaceLeft--){
						sb.append(" ");
					}
					sb.append(words[start++]);
					totalSpace -= space;
				}
			}
			ret.add(sb.toString());
		}
		return ret;    
		}
	private int getWordNum(int i, String[] words, int L) {
		int wordNum = 1;
		int length = words[i++].length();
		if(i == words.length)
			return 1;
		while(i < words.length){
			if((length+words[i].length()+1)>L){
				break;
			}
			length += words[i++].length()+1;
			wordNum++;
		}
		return wordNum;
	}

}
