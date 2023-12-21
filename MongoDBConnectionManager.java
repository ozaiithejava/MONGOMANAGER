import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnectionManager {
    private static final String MONGO_HOST = "localhost";
    private static final int MONGO_PORT = 27017;

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnectionManager(String databaseName) {
        this.mongoClient = new MongoClient(MONGO_HOST, MONGO_PORT);
        this.database = mongoClient.getDatabase(databaseName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public void close() {
        mongoClient.close();
    }
}
