package Rough;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class PQ{
	ArrayList<Integer> list;
	int size;
	
	public PQ() {
		list = new ArrayList<Integer>();
		size = 0;
	}
	
	void offer(int x) {
		list.add(x);
		size++;
		upHeapify();
	}
	
	void upHeapify() {
		int c = this.size() - 1;
		int p = (c-1)/2;
		
		while(p > 0 && list.get(p) > list.get(c)) {	
			int temp = list.get(c);
			list.set(c, list.get(p));
			list.set(c, temp);
			c = p;
			p = (c-1)/2;
		}
	}
	
	void downHeapify() {
		int p = 0; int cl = 1; int cr = 2;
		while(list.get(p) > list.get(cl) || list.get(p) > list.get(cr)) {
			if(list.get(cl) < list.get(cr)) {
				int temp = list.get(p);
				list.set(p, list.get(cl));
				list.set(cl, temp);
			} else {
				int temp = list.get(p);
				list.set(p, list.get(cr));
				list.set(cr, temp);
			}
		}
	}
	
	int poll() {
		if(size == 0)
			return -1;
		int rem = list.get(0);
		list.add(0, list.remove(list.size() - 1));
		size--;
		downHeapify();
		return rem;
	}
	
	void print() {
		for(int x : list) System.out.print(x + " ");
		System.out.println();
	}
	
	int size() {
		return size;
	}
	
}

public class Inp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PQ minHeap = new PQ();
		int x = 0;
		while(true) {
			System.out.println("what to do");
			x = Integer.parseInt(br.readLine());
			if(x == -1) {
				return;
			} else if(x == -2) {
				minHeap.print();
			} else if(x == -3) {
				minHeap.poll();
				minHeap.print();
			} else {
				System.out.println("enter array size");
				int n = Integer.parseInt(br.readLine());
				System.out.println("enter " + n + " elements");
				String[] s = br.readLine().split(" ");
				for(int i = 0; i < n; i++) 
					minHeap.offer(Integer.parseInt(s[i]));
				minHeap.print();
				System.out.println();
			}
		}

	}

}
