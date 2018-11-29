import static org.junit.Assert.*;

import org.junit.Test;

import main.Volume;

public class VolumeTeste {

	@Test
	public void test() {
		Volume volume_teste1 = new Volume(17000);
		assertEquals(16383, volume_teste1.getVolume());
		
		volume_teste1.setVolume(2000);
		assertEquals(2000, volume_teste1.getVolume());
		
		volume_teste1.multiplicaVolume((float) 2.0);
		assertEquals(2000*2, volume_teste1.getVolume());
		
		volume_teste1.multiplicaVolume((float) 5.0);
		assertEquals(16383, volume_teste1.getVolume());
		
		volume_teste1.divideVolume((float) 4.0);
		assertEquals(16383/4, volume_teste1.getVolume());
		
		volume_teste1.divideVolume((float) 8.0);
		assertEquals((16383/4)/8, volume_teste1.getVolume());
		
		volume_teste1.setVolume(20000);
		assertEquals(16383, volume_teste1.getVolume());
		
		volume_teste1.setVolume(-1);
		assertEquals(0, volume_teste1.getVolume());
		
		volume_teste1.setVolume(16383);
		volume_teste1.divideVolume((float) -4.0);
		assertEquals(16383, volume_teste1.getVolume());
		
		volume_teste1.setVolume(16383);
		volume_teste1.multiplicaVolume((float) -4.0);
		assertEquals(16383, volume_teste1.getVolume());
		
		Volume volume_teste2 = new Volume(-5);
		assertEquals(0, volume_teste2.getVolume());
		
	}

}
