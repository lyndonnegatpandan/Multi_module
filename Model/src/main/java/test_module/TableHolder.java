package com.test.test_module;

import java.util.*;
import java.io.*;
import org.apache.commons.lang3.StringUtils;


public class TableHolder{
	
    static String[][] table = null;
    

	public String[][] getTable(){
		return table;
	}

	public Boolean setTable(String[][] table){
		this.table = table;
		return true;
	}

	
}