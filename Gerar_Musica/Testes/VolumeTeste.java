import static org.junit.Assert.*;

import org.junit.Test;

import main.Volume;

public class VolumeTeste {

	@Test
	public void test() {
		Volume volume = new Volume(17000);
		assertEquals(16383, volume.getVolume());
		
		volume.setVolume(2000);
		assertEquals(2000, volume.getVolume());
		
		volume.multiplicaVolume((float) 2.0);
		assertEquals(2000*2, volume.getVolume());
		
		volume.multiplicaVolume((float) 5.0);
		assertEquals(16383, volume.getVolume());
		
		volume.divideVolume((float) 4.0);
		assertEquals(16383/4, volume.getVolume());
		
		volume.divideVolume((float) 8.0);
		assertEquals((16383/4)/8, volume.getVolume());
		
		volume.setVolume(20000);
		assertEquals(16383, volume.getVolume());
		
		volume.setVolume(-1);
		assertEquals(0, volume.getVolume());
		
		volume.setVolume(16383);
		volume.divideVolume((float) -4.0);
		assertEquals(16383, volume.getVolume());
		
		volume.setVolume(16383);
		volume.multiplicaVolume((float) -4.0);
		assertEquals(16383, volume.getVolume());
		
		Volume volume2 = new Volume(-5);
		assertEquals(0, volume2.getVolume());
		
	}

}
