package px.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MyURL {
	
	private URL url ;
	
	public MyURL(String urlString) throws MalformedURLException {
		url = new URL(urlString);
	}

	public void fetchDataWithStream() throws IOException {
		try (InputStream inputStream = url.openStream();) {
			int c;
			while ((c = inputStream.read()) != -1) {
				System.out.write(c);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
}
