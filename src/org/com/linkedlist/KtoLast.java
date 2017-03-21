package org.com.linkedlist;
import org.com.linkedlist.RemoveDuplicates;
class IntWrapper{
	public  int value=0;
}
public class KtoLast {
	//private static final IntWrapper IntWrapper = null;
	static int i=0;
	public static Node find(int k){
		int count=1;
		int size=RemoveDuplicates.size();
		Node after=RemoveDuplicates.head;
		while(after.getNext()!=null && count<size-k+1){
			//System.out.println(count);
			after=after.getNext();
			count++;
		}
		if(after.getNext()==null){
			System.out.println("Eles not found");
			return null;
		}
		if(count==size-k+1){
			System.out.print(after.getData()+" ");
			return after;
				//
				
		}
		return null;
	}
	//recurrsive method
	public static Node nthToLast(Node head, int k, IntWrapper i){
		if(head==null){
			return null;
		}
		Node required=nthToLast(head.getNext(), k,i);
		i.value=i.value+1;
		if(i.value==k){
			return head;
		}
		return required;
	}
	//declaring counter as static variable 
	public static Node nthToLast1(Node head, int k){
		if(head==null){
			return null;
		}
		Node required=nthToLast1(head.getNext(), k);
		i=i+1;
		if(i==k){
			return head;
		}
		return required;
	}
	//Iterative method
	public static Node iterativenthToLast(int k){
		int size=RemoveDuplicates.size();
		Node temp1=RemoveDuplicates.head;
		Node temp2=RemoveDuplicates.head;
		for(int i=1;i<k;i++){
			if(temp1==null){
				return null;
			}
			temp1=temp1.getNext();
		}
		while(temp1.getNext()!=null){
			if(temp1==null) return null;
			temp2=temp2.getNext();
			temp1=temp1.getNext();
		}
		return temp2;
	}
	public static void main(String[] args) {
		//int temp=IntWrapper.value;
		IntWrapper w=new IntWrapper();
		RemoveDuplicates.insert('F');
		RemoveDuplicates.insert('O');
		RemoveDuplicates.insert('L');
		RemoveDuplicates.insert('L');
		RemoveDuplicates.insert('O');
		RemoveDuplicates.insert('W');
		RemoveDuplicates.insert('U');
		RemoveDuplicates.insert('P');
		//RemoveDuplicates.remove2();
		//RemoveDuplicates.display();
		System.out.println(KtoLast.nthToLast(RemoveDuplicates.head, 3, w));
		System.out.println(KtoLast.nthToLast1(RemoveDuplicates.head, 3));
		System.out.println(KtoLast.iterativenthToLast(3));
		
	}
}
