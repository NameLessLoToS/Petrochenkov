package Map;

import org.junit.Assert;
import org.junit.Test;
import java.util.Random;
import java.util.HashSet;

public class TestHashMap {	
	
	@Test
	public void testGetAndSize1() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 200; i++) {
			int key = random.nextInt(100);
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}
	
	@Test
	public void testGetAndSize2() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 200; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}
	
	@Test
	public void testGetAndSize3() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 20000000; i++) {
			int key = random.nextInt(100);
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}

	@Test
	public void testGetAndSize4() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 2000; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}

	@Test
	public void testGetAndSize5() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 20000; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}
	
	@Test
	public void testGetAndSize6() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 200000; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}

	@Test
	public void testGetAndSize7() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 2000000; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}

	@Test
	public void testGetAndSize8() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 10000000; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			set.add(key);
			Assert.assertEquals(value, hm.get(key));			
			Assert.assertEquals(set.size(), hm.size());			
		}
	}

	class KeyValue {
		int key;
		long value;
		public KeyValue(int key, long value) {
			this.key = key;
			this.value = value;
		}
	}
	
	@Test
	public void testGetAndSize9() throws Exception {
		HashMap hm = new HashMap();
		Random random = new Random();
		KeyValue testarray[] = new KeyValue[100000];
		int size = 0;
		for (int i = 0; i < 100000; i++) {
			int key = random.nextInt();
			long value = random.nextLong();
			hm.put(key, value);
			int j = 0;
			while (j < size && testarray[j].key != key) j++;
			if (j < size) {
				testarray[j].value = value;
			}
			else {
				testarray[j] = new KeyValue(key, value);
				size++;
			}
			Assert.assertEquals(value, hm.get(key));	
			Assert.assertEquals(size, hm.size());						
		}
	}

}
