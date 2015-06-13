package de.nordakademie.persistence.product;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.ProductDAO;
import de.nordakademie.persistence.common.MongodbFactory;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private MongodbFactory mongodb;

    @Override
    public List<Product> findAll(final String color, final String ps) {
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

    private Product transform(final Document document) {
        return new Product(document.getString("brand"), document.getString("model"), document.getString("color"), document.getDouble("kilometers"), document.getDouble("price"), document.getDouble("ps"));
    }
}
