package hello.bit;

import WMH.hello.bit.BitApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BitApplicationTests {

	@Test
	void contextLoads() {
		BitApplication bit = new BitApplication();
		
		int test = bit.getI();
	}

}
