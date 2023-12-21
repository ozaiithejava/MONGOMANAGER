import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDBDataManager {
    private MongoDBConnectionManager connectionManager;

    public MongoDBDataManager(MongoDBConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void insert(String collectionName, Document document) {
        try {
            MongoCollection<Document> collection = connectionManager.getCollection(collectionName);
            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document findOne(String collectionName, String key, Object value) {
        try {
            MongoCollection<Document> collection = connectionManager.getCollection(collectionName);
            return collection.find(Filters.eq(key, value)).first();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(String collectionName, String key, Object value) {
        try {
            MongoCollection<Document> collection = connectionManager.getCollection(collectionName);
            collection.deleteOne(Filters.eq(key, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
