/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1_imagecrawler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author pv
 */
public class crawl {
    public String Crawlimage(){
        String url = "https://this-person-does-not-exist.com/en";
        String img = "";
        try{
            
            Document document = Jsoup.connect(url).get();
            Elements docs = document.select("#avatar");
            
            for(Element e:docs){
                img = e.attr("src");
                System.out.println(img);
            }  
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return url + img;
    }
    
}
