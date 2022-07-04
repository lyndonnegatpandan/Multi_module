package com.test.test_module;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.*;
import java.util.*;

public class ServiceClassTest{
	ServicesClass service = new ServicesClass();
	

	@Test 
	public void randomGeneratorTest(){
		int size = 3;
		assertEquals(size, service.randomGenerator().length());
	}

	@Test
	public void dataEncoderTest(){
		Map<String, String> map= new HashMap<>();
		Object[][] cell = null;
		cell = new Object[2][2];
		Boolean bool = true;
		assertEquals(bool, service.dataEncoder(map, cell, 2, 2));

	}

	@Test
	public void ObjectToArrayTest(){
		Object[][] test = {{"dsa=fdf","fdd=gff"},{"23f=fdd","fds=fdfd"}};
		String[][] value = {{"dsa=fdf","fdd=gff"},{"23f=fdd","fds=fdfd"}};
		assertEquals(value, service.ObjectToArray(test, 2, 2));
	}

	@Test
	public void editDataTest(){
		String[][] compareKey = {{"111=fdf","fdd=gff"},{"23f=fdd","fds=fdfd"}};
		String[][] compareValue = {{"dsa=000","fdd=gff"},{"23f=fdd","fds=fdfd"}};
		String[][] value = {{"dsa=fdf","fdd=gff"},{"23f=fdd","fds=fdfd"}};
		assertEquals(compareKey, service.editData(value, 0, 0, "Key", "111"));
		assertEquals(compareValue, service.editData(value, 0, 0, "Value", "000"));
		
	}

	@Test
	public void sortTableTest(){
		String[][] valueAscending = {{"Ay@=rZb","a99=f7n"},{"BE1=bo%","b@8=D_q"}};
		String[][] valueDescending = {{"a99=f7n","Ay@=rZb"},{"b@8=D_q","BE1=bo%"}};
		String[][] compare = {{"a99=f7n","Ay@=rZb"},{"BE1=bo%","b@8=D_q"}};
		assertEquals(valueAscending, service.sortTable(compare, "Ascending"));
		assertEquals(valueDescending, service.sortTable(compare, "Descending"));

	}

	@Test
	public void searchTest(){
		String[][] compare = {{"a99=f7n","Ay@=rZb"},{"BE1=bo%","b@8=D_q"}};
		

		assertEquals("[0,0]-1 From key field\n", service.search(compare, "a99"));
		assertEquals("[0,0]-1 From value field\n", service.search(compare, "f7n"));
		assertEquals("There is no such key or value.\n", service.search(compare, "111"));
	}

	@Test
	public void addColumnTest(){
		String[][] compare =  {{"mBe=kib","wxi=%lV","null=null"},{"Gz~=X(p","U0X=cc&","111=222"}};
		String[][] compareTo = {{"mBe=kib","wxi=%lV"},{"Gz~=X(p","U0X=cc&"}};
		assertEquals(compare, service.addColumn(compareTo,1,"111","222"));
	}

	@Test
	public void printArrayTest(){
		ByteArrayOutputStream content = new ByteArrayOutputStream();
		System.setOut(new PrintStream(content));
		String[][] compare = {{"12a=123","123=asa"},{"345=322","ddf=ffg"}};
		String expected = "12a,123\t123,asa\t\n345,322\tddf,ffg\t\n";
		service.printArray(compare);
		assertEquals(expected, content.toString());
	}

	@Test
	public void saveFileTest(){
		Boolean bool = true;
		String path = "C:/Users/MARVIN/Desktop/codes/Output.txt";
		String[][] compare = {{"mBe=kib","wxi=%lV"},{"Gz~=X(p","U0X=cc&"}};
		assertEquals(bool, service.saveFile(compare, path));
	}

	@Test
	public void readFileTest() throws IOException{
		String path = "C:/Users/MARVIN/Desktop/codes/Output.txt";
		String[][] compare = {{"mBe=kib","wxi=%lV"},{"Gz~=X(p","U0X=cc&"}};
		String[][] output = service.readFile(path);
		assertEquals(output, compare);

		
	}

}