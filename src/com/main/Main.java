package com.main;

import org.junit.Test;

import com.algorithm.BST;
import com.algorithm.BinarySearchST;
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
		System.out.println("st中X的value值"+st.get("X"));
		System.out.println("-----------------------");
		st.delete("A");
		System.out.println(st.toString());
		System.out.println("-----------------------");
		System.out.println("st的长度"+st.size());
	}

	@Test
	public void BinarySearchSTTest()
	{
		BinarySearchST<String,String> st=new BinarySearchST<String,String>(9000);
		
		System.out.println(st.size());
		
        // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");

        // search for IP addresses given URL
        System.out.println("size = " + st.size());
        System.out.println(st.get("www.cs.princeton.edu"));
        System.out.println(st.get("www.amazon.com"));
        System.out.println(st.get("www.amazon.edu"));
        System.out.println(st.get("www.yale.edu"));
        System.out.println(st.toString());
        System.out.println();
        
        st.delete("www.espn.com");
        st.delete("www.amazon.com");
        st.delete("www.aaaaaaaaa.com");
        
        System.out.println("size = " + st.size());
        System.out.println(st.get("www.cs.princeton.edu"));
        System.out.println(st.get("www.amazon.com"));
        System.out.println(st.get("www.amazon.edu"));
        System.out.println(st.get("www.yale.edu"));
        System.out.println(st.toString());
        System.out.println();
        
	}
	
	@Test
	public void BSTTest()
	{
		BST<String,Integer> bst=new BST<String, Integer>();
		
		bst.put("S", 5);
		bst.put("B", 1);
		bst.put("D", 2);
		bst.put("A", 3);
		bst.put("W", 6);
		bst.put("X", 4);
		
		bst.print();
		System.out.println(bst.get("D"));
		bst.delete("D");
		bst.print();
		System.out.println("二叉树长度:"+bst.size());
		
	}
}
