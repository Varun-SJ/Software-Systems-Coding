package ss.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MergeSort <E extends Comparable <E>> {
	
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {
    	
    	int size = list.size();
    	if(size <= 1) { return;
    	}
    	int middle = (size+1)/2;
    	List<E> templist = sort(list);
    	list.clear();
    	list.addAll(templist);
    	System.out.println(templist.toString());
    }
    
    private static <E extends Comparable<E>> List<E> merge(List<E> first, List<E>second){
    	
    	List<E> mergedlist = new ArrayList<E>();
    	while(first.size() > 0 && second.size() > 0) {
    		if ((first.get(0).compareTo(second.get(0))<0)) {
    			mergedlist.add(first.get(0));
    			first.remove(0);
    		} else {
    			mergedlist.add(second.get(0));
    			second.remove(0);
    		}
    	}
    	if(first.size() == 0) {
    		while(second.size()>0) {
    			mergedlist.add(second.get(0));
    			second.remove(0);
    		}
    	} else {
    		while (first.size() > 0) {
    			mergedlist.add(first.get(0));
    			first.remove(0);
    		}
    	}
    	return mergedlist;
    	
    }
    
    private static <E extends Comparable<E>> List<E> sort(List<E> list){
    	int size = list.size();
    	if(size <= 1) {
    		return list;
    	}
    	int middle = (size+1)/2;
    	
    	List<E> splitlist1 = new ArrayList<E>(list.subList(0, middle));
    	List<E> splitlist2 = new ArrayList<E>(list.subList(middle, list.size()));
    	splitlist1 = sort(splitlist1);
    	splitlist2 = sort(splitlist2);
    	return merge(splitlist1,splitlist2);
    }
    
    public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(8, 2, 69, 3, 3, 5 ,3 ,5 ,7 ,9 ,77 ,65 ,32 ,4,5));
		mergesort(l);
	}
    
    
    

    
}
