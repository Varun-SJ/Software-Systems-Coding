package ss.week4;

import java.lang.reflect.Array;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
    	
    	int negative = 0;
		for(int i: arr) {
			if(i < 0) {
				negative++;
			}
		}
		return negative;
    }

    public static void reverseArray(int[] ints) {
    	for (int i = 0; i < ints.length/2; i++) {
    		int temp = ints[i];
    		ints[i] = ints[ints.length-i-1];
    		ints[ints.length - i - 1] = temp;
    	}
    	// ints = [1,2,3,4]
    	// output = [4,3,2,1]
    
    }
    
    public static void main(String[] args) {
    	int[] i = {1, 2, 3, 4}; 
    	reverseArray(i);
    	// i = [4,3,2,1]
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
