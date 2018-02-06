package px.demo.entrance;

import java.io.IOException;
import java.net.MalformedURLException;

import px.url.MyURL;

public class TryUrlFetchData {

	public static void main(String[] args) {
		String urlString = "https://www.oreilly.com/";
		try {
			MyURL myURL = new MyURL(urlString);
			myURL.fetchDataWithStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
