# MONGOMANAGER
mongo db manager in java


## Usage:
```Java:
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // MongoDB bağlantısını yöneten sınıfı oluştur
        MongoDBConnectionManager connectionManager = new MongoDBConnectionManager("your_database_name");

        // MongoDB üzerinde veri işlemlerini yöneten sınıfı oluştur
        MongoDBDataManager dataManager = new MongoDBDataManager(connectionManager);

        // Veri ekleme
        Document document = new Document("name", "John Doe")
                .append("age", 30)
                .append("city", "New York");
        dataManager.insert("your_collection_name", document);

        // Veriyi alma
        Document result = dataManager.findOne("your_collection_name", "name", "John Doe");
        System.out.println("Result: " + result);

        // Veriyi silme
        dataManager.delete("your_collection_name", "name", "John Doe");

        // MongoDB bağlantısını kapat
        connectionManager.close();
    }
}
```
