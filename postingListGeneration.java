import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;

public class postingListGeneration {

	public static void main(String[] args) {

		BufferedReader br = null;
		String[] words1 =null;
		String[] words2 = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("N:\\hi.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				words1 = sCurrentLine.split(" ");
			}
			List<String> wordList1 = Arrays.asList(words1);
			String sCurrentLine2;
			br = new BufferedReader(new FileReader("N:\\hello.txt"));
			while ((sCurrentLine2 = br.readLine()) != null) {
				 words2 = sCurrentLine2.split(" ");
			}
			List<String> wordList2 = Arrays.asList(words2);
			List<String> i1=Intersect(wordList1,wordList2);
			List<String> u1=Union(wordList1,wordList2);
			List<String> r1=Remaining(wordList1,i1);
			List<String> r2=Remaining(wordList2,i1);
		//	System.out.println(i1);
		//	System.out.println(u1);
		//	System.out.println(r1);
		//	System.out.println(r2);
			System.out.print("GENERATING POSTING LIST.");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(500);
			System.out.println(".");
			Thread.sleep(500);
			Map<String,List<String>> postlist = new HashMap<String,List<String>>();
			for(int k=0;k<u1.size();k++){
				postlist.put(u1.get(k), new ArrayList<String>());
			}
			
			for(int l=0;l<postlist.size();l++){
			for(int m=0;m<i1.size();m++){
				if((u1.get(l)).equals(i1.get(m))){
  					postlist.get(u1.get(l)).add("1");    
  					postlist.get(u1.get(l)).add("2");
				}
				continue;
			} 
				
			for(int n=0;n<r1.size();n++){
				if(u1.get(l).equals(r1.get(n))){
			        postlist.get(u1.get(l)).add("1");    
				}
				continue;
			}
			for(int o=0;o<r2.size();o++){
				if(u1.get(l).equals(r2.get(o))){
			        postlist.get(u1.get(l)).add("2");    
				}
				continue;
			}
			}
			System.out.println(postlist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public static List<String> Intersect(List<String> L1,List<String> L2){
		List<String> answer= new ArrayList<String>();
		for(int i=0;i<L1.size();i++){
		for(int j=0;j<L2.size();j++){
			if(L1.get(i).equals(L2.get(j))){
				answer.add(L1.get(i));
				}
		}
	}
	return answer;
	}
	
	public static List<String> Union(List<String> L1,List<String> L2){
		List<String> answer= new ArrayList<String>();
		for(int i=0;i<L1.size();i++){
		for(int j=0;j<L2.size();j++){
			if(L1.get(i).equals(L2)){
				answer.add(L1.get(i));
				}
			else if(!(answer.contains(L1.get(i)) )  ){
				answer.add(L1.get(i));
				}
			else if(!(answer.contains(L2.get(j)))){
				answer.add(L2.get(j));
				}
			}
		}
		return answer; 
	}

	public static List<String> Remaining(List<String> U,List<String> I) {
		List<String> answer = new ArrayList<String>();
		answer.addAll(U);
		for(int i=0; i<answer.size(); i++){
			for(int j=0; j<I.size(); j++){
				if((answer.get(i)).equals(I.get(j))){
					//System.out.println(answer.get(i));
					answer.remove(i);
					
				}
			}
		}
		return answer;
		}
	}