package com.example.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Input;
import com.example.Product;

//Junit Test
class InputTest {
	private List<Product> list;
	
	@Test
	void testFileInput() {
		List<Product> list = new ArrayList<Product>();
		Input input = new Input(list);
		input.fileInput();
		assertNotNull(list); // 이거 초록 창 뜨는지 확인하고,
		assertEquals("DISKETTE", list.get(5).getName()); // 기대값과 list의 5번째 이름의 이름이 같은가??
	}

}
