package com.algorithm;

/**
 * 无序链表
 * 实现了查找，插入，删除等功能
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
	
	private Node first;	//表头
	private int N;		//链表长度
	
	/**
	 * 查找
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
			//如果查找到该键，则更新
			if(key.equals(x.key)){
				x.value=value;
				return;
			}
		}
		//未命中，则在链表前端加入
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
	 * 返回链表长度
	 * @return
	 */
	public int size()
	{
		return N;
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	/**
	 * 输出键值对
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
