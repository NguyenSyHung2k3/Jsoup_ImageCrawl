# Jsoup_ImageCrawl
## Jsoup là gì
[Jsoup](https://jsoup.org/) là một thư viện mã nguồn mở được thiết kế để trích xuất thao tác dữ liệu được lưu trữ trong tài liệu.<br>
![image](https://raw.githubusercontent.com/NguyenSyHung2k3/Jsoup_ImageCrawl/master/assets/Jsoup.png)
## Cài đặt Jsoup 
Để cài đặt Jsoup trong dự án java bạn có thể sử dụng Maven hoặc Gradle để quản lý các thư viện phụ thuộc
- Sử dụng Maven:
  Thêm dependency vào tệp `pom.xml` của bạn:
```xml
   <dependencies>
       <dependency>
           <groupId>org.jsoup</groupId>
           <artifactId>jsoup</artifactId>
           <version>1.14.3</version> <!-- Phiên bản mới nhất có thể thay đổi -->
       </dependency>
   </dependencies>
```
Sau đó, Maven sẽ tự động tải về Jsoup khi bạn chạy lệnh `mvn clean install` hoặc bất kì lệnh Maven khác.
- Sử dụng Gradle:
  Thêm depedency vào tệp `build.gradle` của bạn:
```xml
  dependencies {
    implementation 'org.jsoup:jsoup:1.14.3' // Phiên bản mới nhất có thể thay đổi
  }
```
## Tiến hành crawl ảnh về bằng Jsoup
- Thực hiện việc tìm kiếm dữ liệu của ảnh qua các thẻ HTML<br>
![image](https://github.com/NguyenSyHung2k3/Jsoup_ImageCrawl/blob/master/assets/Screenshot%202023-12-12%20193147.png)

- Lập trình bằng phần mềm netbeans

  ```xml
  public String Crawlimage(){
        String url = "https://this-person-does-not-exist.com/";
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
  ```

  Hàm Crawlimage trả về url chứa ảnh bất kì
- Lưu ảnh về dưới file `.jdg`
  ![image](https://github.com/NguyenSyHung2k3/Jsoup_ImageCrawl/blob/master/assets/Screenshot%202023-12-12%20195851.png)
- Lưu tất cả các ảnh crawl về được vào 1 folder
  ![image](https://github.com/NguyenSyHung2k3/Jsoup_ImageCrawl/blob/master/assets/Screenshot%202023-12-12%20200111.png)

## Màn hình hệ thống để lấy ảnh về
![image](https://github.com/NguyenSyHung2k3/Jsoup_ImageCrawl/blob/master/assets/Screenshot%202023-12-12%20200345.png)
  

