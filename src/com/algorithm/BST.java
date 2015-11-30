package com.algorithm;

/**
 * 基于二叉查找树的符号表
 * @author Administrator
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node{
		
		private Key key;
		private Value value;
		private Node left,right;
		private int N;
		
		public Node(Key key,Value value,int N)
		{
			this.key=key;
			this.value=value;
			this.N=N;
		}
	}
	
	/**
	 * 二叉树长度
	 * @return
	 */
	public int size(){
		return size(root);
	}
	
	private int size(Node x)
	{
		if(x==null){
			return 0;
		}else{
			return x.N;
		}
	}
	
	/**
	 * 查找
	 * @param key
	 * @return
	 */
	public Value get(Key key)
	{
		return get(root,key);
	}
	
	private Value get(Node x,Key key)
	{
		if(x==null){
			return null;
		}
		
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			return get(x.left,key);
		}else if(cmp>0){
			return get(x.right,key);
		}else{
			return x.value;
		}
	}
	
	/**
	 * 插入
	 * @param key
	 * @param value
	 */
	public void put(Key key,Value value)
	{
		root=put(root,key,value);
	}
	
	private Node put(Node x,Key key,Value value)
	{
		//如果节点x不存在，则创建
		if(x==null){
			return new Node(key,value,1);
		}
		
		//如果存在，则向下插入
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			x.left=put(x.left,key,value);
		}else if(cmp>0){
			x.right=put(x.right,key,value);
		}else{
			x.value=value;
		}
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	/**
	 * 返回最小键
	 * @return
	 */
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		if(x.left==null){
			return x;
		}else{
			return min(x.left);
		}
	}
	
	/**
	 * 返回最大键
	 * @return
	 */
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node x)
	{
		if(x.right==null){
			return x;
		}else{
			return max(x.right);
		}
	}
	
	/**
	 * 查找排名为k的键
	 * @param k
	 * @return
	 */
	public Key select(int k)
	{
		return select(root,k).key;
	}
	
	//返回排名为k的节点
	private Node select(Node x,int k)
	{
		if(x==null){
			return null;
		}
		
		int t=size(x.left);
		if(t<k){
			return select(x.right,k-t-1);
		}else if(t>k){
			return select(x.left,k);
		}else{
			return x;
		}
	}
	
	/**
	 * 查找key键的排名
	 * @param key
	 * @return
	 */
	public int rank(Key key)
	{
		return rank(root,key);
	}
	
	private int rank(Node x,Key key)
	{
		if(x==null) {
			return 0;
		}
		
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			return rank(x.left,key);
		}else if(cmp>0){
			return 1+size(x.left)+rank(x.right,key);
		}else{
			return size(x.left);
		}
	}
	
	/**
	 * 删除
	 * @param key
	 */
	public void delete(Key key)
	{
		root=delete(root,key);
	}
	
	private Node delete(Node x,Key key)
	{
		if(x==null) {
			return null;
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			x.left=delete(x.left,key);
		}else if(cmp>0){
			x.right=delete(x.right,key);
		}else{
			if(x.right==null){
				return x.right;
			}
			if(x.left==null){
				return x.left;
			}
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	/**
	 * 删除最左节点
	 * @param x
	 * @return
	 */
	private Node deleteMin(Node x)
	{
		if(x.left==null){
			return x.right;
		}
		x.left=deleteMin(x.left);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
//	@Override
//	public String toString()
//	{
//		
//	}
	
	/**
	 * 打印整个链表
	 */
	public void print()
	{
		print(root);
	}
	
	private void print(Node x)
	{
		if(x==null){
			return;
		}
		
		print(x.left);
		System.out.println("[key='"+x.key+"',value='"+x.value+"']");
		print(x.right);
	}
}
