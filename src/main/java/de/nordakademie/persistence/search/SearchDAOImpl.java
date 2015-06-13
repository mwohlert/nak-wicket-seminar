package de.nordakademie.persistence.search;

import de.nordakademie.business.message.Product;
import de.nordakademie.business.message.SearchDAO;
import de.nordakademie.persistence.common.MongodbFactory;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchDAOImpl implements SearchDAO {

    @Autowired
    private MongodbFactory mongodb;

    public List<Product> findWord(String input, final String color, final String ps) {
        if (input != null) {

            List<Document> orDocuments = new ArrayList<>();
            List<Document> andDocuments = new ArrayList<>();
            Document orQuery = new Document();

            //Sören


            if ((color != null && !color.isEmpty() && ps == null)) {
               andDocuments.add(new Document().append("color", color));
            } else if (color == null && ps!=null ) {
                andDocuments.add(new Document("ps", new Document().append("$gt", Double.valueOf(ps))));
            } else if (color !=null && ps !=null){
                andDocuments.add(new Document("ps", new Document().append("$gt", Double.valueOf(ps))));
                andDocuments.add(new Document("color", color));
            }

            //ReturnListView
            String[] split = input.split("\\s+");
            for (String each : split) {
                orDocuments.add(new Document().append("price", wrapRegex(each)));
                try {
                    orDocuments.add(new Document().append("ps", Double.parseDouble(each)));
                }catch(NumberFormatException e){
                    System.out.println("each is not parsable");
                }
                orDocuments.add(new Document().append("kilometers", wrapRegex(each)));
                orDocuments.add(new Document().append("brand", wrapRegex(each)));
                orDocuments.add(new Document().append("model", wrapRegex(each)));
                orDocuments.add(new Document().append("color", wrapRegex(each)));
            }



            orQuery.append("$or", orDocuments);
            if(andDocuments.size() >0) {
                orQuery.append("$and", andDocuments);
            }
            System.out.println(orQuery);


            return mongodb.getObject().getCollection("product").find(orQuery).map(document -> new Product(document.getString("brand"), document.getString("model"), document.getString("color"), document.getDouble("kilometers"), document.getDouble("price"), document.getDouble("ps"))).into(new ArrayList<>());
        } else {
            if ((color == null || color.isEmpty()) && ps == null) {
                return mongodb.getObject().getCollection("product").find()
                        .map(this::transform).into(new ArrayList<>());
            } else if((color != null && !color.isEmpty() && ps == null)) {
                return mongodb.getObject().getCollection("product").find(new Document("color", color))
                        .map(this::transform).into(new ArrayList<>());
            } else if (color == null) {
                return mongodb.getObject().getCollection("product").find(new Document("ps", new Document().append("$gt", Double.valueOf(ps))))
                        .map(this::transform).into(new ArrayList<>());
            } else {
                return mongodb.getObject().getCollection("product").find(new Document("ps", new Document().append("$gt", Double.valueOf(ps)))
                        .append("color", color)).map(this::transform).into(new ArrayList<>());
            }

        }
    }

    private Document wrapRegex(String searchString) {
        return new Document("$regex", searchString);
    }

    private Document wrapRegexDouble(Double searchDouble){
        return new Document("$regex", searchDouble);
    }

    private Product transform(final Document document) {
        return new Product(document.getString("brand"), document.getString("model"), document.getString("color"), document.getDouble("kilometers"), document.getDouble("price"), document.getDouble("ps"));
    }
}