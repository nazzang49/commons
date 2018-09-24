package me.saro.commons;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void test() throws Exception {

		assertEquals("123", Converter.asList("1", "2", "3").stream().collect(Collectors.joining()));
		
		assertEquals(5, Converter.splitCsvLine("aaa,bbb,ccc,\"ddd,eee\",fff").length);
		
		assertEquals("00ff", Converter.toHex(new byte[] {0, -1}));
		
		// Converter.HASH_ALGORITHM_SHA3* minimum java version is 10 
		assertEquals(
			"2ce5bebfa51bf5b222a5c8977d3c1d37875703d3",
			Converter.toHex(Converter.toHash(Converter.HASH_ALGORITHM_SHA1, "SARO"))
		);
	
		assertEquals(
			"a1b2c3",
			Converter.<String, Integer>toMap("a", 1, "b", 2, "c", 3).entrySet().stream()
			.map(e -> e.getKey() + e.getValue()).collect(Collectors.joining())
		);
	}
	
}
