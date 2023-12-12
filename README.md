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