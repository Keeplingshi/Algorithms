package com.algorithm;

/**
 * ��������
 * ʵ���˲��ң����룬ɾ���ȹ���
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
	
	private Node first;	//��ͷ
	private int N;		//������
	
	/**
	 * ����
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
	 * ����
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
			//������ҵ��ü��������
			if(key.equals(x.key)){
				x.value=value;
				return;
			}
		}
		//δ���У���������ǰ�˼���
		first=new Node(key,value,first);
		N++;
	}
	
	/**
	 * ɾ��
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
	 * ����������
	 * @return
	 */
	public int size()
	{
		return N;
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	/**
	 * �����ֵ��
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
