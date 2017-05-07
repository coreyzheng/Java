import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* git check out and branch testing 2017-05-06 */
public class BFSSearch 
{

	public static void main(String[] args) 
	{
		String l_beg = "hit";
		String l_end = "cog";
		
		Set<String> l_set = new HashSet<>();
		
		l_set.add("hot");
		l_set.add("dot");
		l_set.add("dog");
		l_set.add("lot");
		l_set.add("log");
		
		int l_ret = LadderLength(l_beg,l_end,l_set);
		
		System.out.println("LadderLength = " + l_ret);

	}
	
    public static int LadderLength(String beginWord, String endWord, Set<String> wordDict) 
    {
    	
        LinkedList<BFSWordNode> queue = new LinkedList<BFSWordNode>();
        
        BFSWordNode l_beg_w = new BFSWordNode(beginWord,1);
        queue.add(l_beg_w);
 
        wordDict.add(endWord);
        
        while(!queue.isEmpty())
        {
        	BFSWordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord))
            {
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++)
            {
                for(char c='a'; c<='z'; c++)
                {
                    char temp = arr[i];
                    if(arr[i]!=c)
                    {
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord))
                    {
                        queue.add(new BFSWordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
        
        return 0;
        
    }
}

