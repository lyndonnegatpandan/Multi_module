package com.test.test_module;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;


public class TableHolderTest{
	TableHolder table = new TableHolder();

	@Test
	public void setTableTest(){
		String[][] expected = {{"mBe=kib","wxi=%lV"},{"Gz~=X(p","U0X=cc&"}};
		Boolean bool = true;
		assertEquals(bool, table.setTable(expected));

	}

	@Test
	public void getTableTest(){
		String[][] expected = null;
		String[][] output = table.getTable();
		assertEquals(expected, output);
	}
}