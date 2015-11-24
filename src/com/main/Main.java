package com.main;

import org.junit.Test;

import com.algorithm.SequentialSearchST;

public class Main {
	
	@Test
	public void SequentialSearchSTTest()
	{
		SequentialSearchST<String,Integer> st=new SequentialSearchST<String,Integer>();
		
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 2);
		st.put("R", 3);
		st.put("C", 4);
		st.put("H", 5);
		st.put("E", 6);
		st.put("X", 7);
		st.put("A", 8);
		st.put("M", 9);
		st.put("P", 10);
		st.put("L", 11);
		st.put("E", 12);
		
		System.out.println(st.toString());
		System.out.println("-----------------------");
		System.out.println("st的X的value："+st.get("X"));
		System.out.println("-----------------------");
		st.delete("A");
		System.out.println(st.toString());
		System.out.println("-----------------------");
		System.out.println("st长度："+st.size());
	}

}
