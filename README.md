# Kan bağış Sistemi
Kan ihtiyacı olan insanlarla ,kan bağışında bulunacak insaları birleştiren bir web platformudur.
Sistem geliştirilirken ,

Netbeans IDE 8.2

Wildfly 10.0.0 application server,(sistemi canlıya çıkardığımız zaman openShift kullanabilmek ve açık kaynak olduğu için)

mySQL database kullanılmıştır.

## Bağımlılıklar
<dependencies>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.9.1</version>
        </dependency>
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>eclipselink</artifactId>
            <version>2.5.2</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>org.eclipse.persistence.jpa.modelgen.processor</artifactId>
            <version>2.5.2</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.10</version>
            <scope>test</scope>
            <type>jar</type>
        </dependency>
        
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-web-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
        <groupId>org.primefaces</groupId>
        <artifactId>primefaces</artifactId>
        <version>6.2</version>
         </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.39</version>
        </dependency>
        <dependency>
            <groupId>javax.mail</groupId>
            <artifactId>mail</artifactId>
            <version>1.4.7</version>
        </dependency>

    </dependencies>
    
 ## Kurulum
 
 Gerekli dosyaları indirip netbeans IDE ortamında açmanız ve bağımlılıkların yüklenmesi için projeyi build etmeniz yeterlidir.
 
 Application server olarak wildfly 10.0.0 ve ya glassfish 4.1.1 kullanılabilir.
 
 Veritabanı Heroku sunucularında tutulmaktadır.Bu nedenle veritabanı ayarlarında değişklik yapılmasına gerek yoktur.
 
 Eğer heroku sunucularına erişilmezse sistemi yerel olarak çalıştırmak için,
 
 <properties>
 
      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/donate_system?zeroDateTimeBehavior=convertToNull"/>
      <property name="javax.persistence.jdbc.user" value="root"/>
      <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
      <property name="javax.persistence.jdbc.password" value="01233210"/>
      
    </properties> 
    
 persistence.xml dosyasında veritabanı ayarlamaları yapılmalıdır.SQL file dosyaları proje içerisine eklenmiştir.Bu şekilde 2. yöntem olarak çalıştırılabilir.
 
 ## Test
 
 Test işlemleri jUnit ve Selenium ile yapılmıştır.
 Projenin açılışında çalışmaması için yorum satırı haline getirilmiştir.