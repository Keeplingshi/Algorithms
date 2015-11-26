package com.algorithm;

public class BinarySearchST <Key extends Comparable<Key>, Value> {

    private Value[] values;      // symbol table values
    private Key[] keys;      // symbol table keys
    private int N = 0;       // number of elements

    public BinarySearchST() {
    	
    }
	
    public BinarySearchST(int initCapacity) {
    	values = (Value[]) new Object[initCapacity];
        keys = (Key[]) new Comparable[initCapacity];
    }
	
    /**
     * ����BinarySearchST����
     * @return
     */
    public int size()
    {
    	return N;
    }
    
    /**
     * ����
     * @param key
     * @return
     */
    public Value get(Key key)
    {
    	if(isEmpty()){
    		return null;
    	}
    	int i=rank(key);
    	if(i<N&&keys[i].compareTo(key)==0){
    		return values[i];
    	}
    	return null;
    }
    
    /**
     * ���ֲ���
     * @param key
     * @return
     */
    public int rank(Key key)
    {
    	int lo=0;
    	int hi=N-1;
    	while(lo<=hi)
    	{
    		int mid=lo+(hi-lo)/2;
    		int cmp=key.compareTo(keys[mid]);
    		if(cmp<0){
    			hi=mid-1;
    		}else if(cmp>0){
    			lo=mid+1;
    		}else{
    			return mid;
    		}
    	}
    	return lo;
    }
    
    /**
     * ����
     * @param key
     * @param value
     */
    public void put(Key key,Value value)
    {
    	int i=rank(key);
    	if(i<N&&keys[i].compareTo(key)==0){
    		values[i]=value;
    		return;
    	}
    	
    	for(int j=N;j>i;j--)
    	{
    		keys[j]=keys[j-1];
    		values[j]=values[j-1];
    	}
    	keys[i]=key;
    	values[i]=value;
    	N++;
    }
    
    /**
     * ɾ��
     * @param key
     */
    public void delete(Key key)
    {
    	int i=rank(key);
    	
    	if(i<N&&keys[i].compareTo(key)==0){
        	for(int j=i+1;j<N;j++)
        	{
        		keys[j-1]=keys[j];
        		values[j-1]=values[j];
        	}
        	
        	keys[N-1]=null;
        	values[N-1]=null;
        	
        	N--;
    	}

    }
    
    /**
     * �Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty() 
    {
    	return N == 0; 
    }
    
    /**
     * ��ӡ�ַ�
     */
    @Override
    public String toString()
    {
    	String str="";
    	
    	for(Key key:keys){
    		if(key==null){
    			continue;
    		}
    		str+="[key="+key+" , value="+get(key)+"]\n";
    	}
    	
    	return str;
    }
}
