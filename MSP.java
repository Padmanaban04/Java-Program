// { Driver Code Starts
import java.util.*;
public class MSP{	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-- != 0)
		{
			int n=sc.nextInt();
			ArrayList<String> s = new ArrayList<String>(n);
			for (int i=0;i<n;i++)
			{
			s.add(sc.next());
			}

			String tt;
			tt=sc.next();
			GfG g=new GfG();
			ArrayList<String> res =g.findMatchedWords(s, tt);
					Collections.sort(res);
			for (int i = 0;i < res.size();i++)
			{
			System.out.print(res.get(i)+" ");
			}
			System.out.println();

		}
	}
}// } Driver Code Ends


/*Complete the provided function*/
class GfG{
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    //add code here.
	   ArrayList<String> list = new ArrayList<String>();
	   ArrayList<Integer> index = new ArrayList<Integer>();
	   ArrayList<Integer> index1 = new ArrayList<Integer>();
	    int flag = 0, count, i;
	    for(i = 0; i < pattern.length() - 1; i++){
	        for(int j = i + 1; j < pattern.length(); j++){
	            if(pattern.charAt(i) == pattern.charAt(j)){
	                if(flag == 0){
	                    index.clear();
                        index.add(i);
                        index.add(j);
                        flag = 1;
                        break;
	                }
	                else{
	                    index.add(i);
	                    break;
	                }
	            }
	       }
	       if(flag == 0){
	        if(i == pattern.length() - 2){
	            index.add(i);
	            index.add(i+1);
	        }
	        else
	            index.add(i);
	        }
	  }
	  for(int  k = 0; k < dict.size(); k++){
	    flag = 0;
	    index1.clear();
	    for(i = 0; i < dict.get(k).length() - 1; i++){
	        for(int j = i + 1; j < dict.get(k).length(); j++){
	            if(dict.get(k).charAt(i) == dict.get(k).charAt(j)){
	                if(flag == 0){
	                    index1.clear();
                        index1.add(i);
                        index1.add(j);
                        flag = 1;
                        break;
	                }
	                else{
	                    index1.add(j);
	                    break;
	                }
	            }
	       }
	       if(flag == 0){
	        if(i == dict.get(k).length() - 2){
	            index1.add(i);
	            index1.add(i+1);
	        }
	        else
	            index1.add(i);
	        }
	    }
	    if(index.size() == index1.size()){
	        count = 0;
	        for(int l = 0; l < index.size(); l++){
	            if(index.get(l) == index1.get(l))
	                count += 1;
	        }
            if((count == index.size()) && (dict.get(k).length() == pattern.length()))	 
                list.add(dict.get(k));
	    }
	  }
	  return list;
	}
}
