package de.nordakademie.ui;

import de.nordakademie.business.product.Product;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.List;


public class ProductPanel extends Panel {

    public ProductPanel(final String wickedId, final IModel<List<Product>> products) {
        super(wickedId);

        add(new ListView<Product>("products", products) {

            @Override
            protected void populateItem(final ListItem<Product> item) {
                item.add(new Label("brand", item.getModelObject().getBrand()));
                item.add(new Label("model", item.getModelObject().getModel()));
                item.add(new Label("color", item.getModelObject().getColor()));
                item.add(new Label("ps", item.getModelObject().getPs()));
                item.add(new Label("kilometers", item.getModelObject().getKilometers()));
                item.add(new Label("price", item.getModelObject().getPrice()));
            }
        });
    }
}
