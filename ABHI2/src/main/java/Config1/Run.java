package Config1;

import java.io.IOException;

import org.testng.annotations.Test;

public class Run {
	@Test
	public void launch() throws IOException {
		
		SingletonClass.Initiallize();
		SingletonClass.close();


}
}
