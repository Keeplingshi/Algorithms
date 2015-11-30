package com.algorithm;

/**
 * 基于无序列表的顺序查找
 * @author chenbin
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key ,Value> {

	private class Node
	{
		Key key;
		Value value;
		Node next;
		
		public Node(Key key,Value value,Node next)
		{
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	private Node first;	//链表首结点
	private int N;		//链表长度
	
	/**
	 * 获取key键的值
	 * @param key
	 * @return
	 */
	public Value get(Key key)
	{
		for(Node x=first;x!=null;x=x.next)
		{
			if(key.equals(x.key))
			{
				return x.value;
			}
		}
		return null;
	}
	
	/**
	 * 插入
	 * @param key
	 * @param value
	 */
	public void put(Key key,Value value)
	{
        if (key == null) throw new NullPointerException("first argument to put() is null"); 
        if (value == null) {
            delete(key);
            return;
        }
		
		for(Node x=first;x!=null;x=x.next)
		{
			if(key.equals(x.key)){
				x.value=value;
				return;
			}
		}
		first=new Node(key,value,first);
		N++;
	}
	
	/**
	 * 删除
	 * @param key
	 */
	public void delete(Key key)
	{
		if (key == null) {
			throw new NullPointerException("argument to delete() is null"); 
		}
		first=delete(first,key);
	}
	
	private Node delete(Node x,Key key)
	{
		if(x==null){
			return null;
		} 
		
		if(key.equals(x.key)){
			N--;
			return x.next;
		}
		
		x.next=delete(x.next,key);
		return x;
	}
	
	/**
	 * 链表长度
	 * @return
	 */
	public int size()
	{
		return N;
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	/**
	 * 打印整个链表
	 */
	@Override
	public String toString()
	{
		String str="";
		for(Node x=first;x!=null;x=x.next)
		{
			str+="[key="+x.key+",value="+x.value+"]\r\n";
		}
		
		return str;
	}
}
