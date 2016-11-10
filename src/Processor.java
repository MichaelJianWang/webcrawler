
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Processor {
static ArrayList<String> List = new  ArrayList<String>();
public void processPage(String URL) throws IOException{

		
		//get useful information
		Document doc = Jsoup.connect(URL).get();
//		if(doc.text().contains("research")){
			System.out.println(URL);
//		}

		//get all links and recursively call the processPage method
		Elements questions = doc.select("a[href]");
//		for (Element test: questions){
//			System.out.println(test);
//			
//		}
		for(Element link: questions){
			if(link.attr("href").contains("zuoyou.de")){
				String s = link.attr("abs:href");
				if(List.contains(s)){
					continue;
				}
				else {
					List.add(s);
					processPage(link.attr("abs:href"));
				}
		}
		}
	}
}