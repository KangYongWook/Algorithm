package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator.HeapNode;

import sun.reflect.generics.tree.Tree;

public class bj11724_연결요소의개수 {
	static int visit[] ;
	static int M;
	static ArrayList<Node> arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//노드 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		
		arr = new ArrayList<Node>();
		visit = new int[N+1];
		int result = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Node( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ));
		}
		
		for (int i = 0; i < M; i++) {
			if(visit[arr.get(i).x] != 1) {
				_dfs(arr.get(i));
				result++;
			}
			
		}
		
		
		
		System.out.println(result);
		
		
	}
	
	static void _dfs(Node node) {
		visit[node.x] = 1;
		
		ArrayList<Node> temp = new ArrayList<Node>();
		for (int i = 0; i < M; i++) {
			Node getNode = arr.get(i);
			if(visit[getNode.x] != 1 && getNode.x == node.y) {
				
				temp.add(getNode);
				_dfs(getNode);
			}
		}
		
		
	}
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
