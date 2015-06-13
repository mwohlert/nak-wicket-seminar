package de.nordakademie.ui;

import de.nordakademie.business.message.Product;
import de.nordakademie.business.message.SearchService;
import de.nordakademie.persistence.common.MongodbFactory;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

import de.nordakademie.business.message.ProductService;

import java.util.Arrays;
import java.util.List;

@MountPath("home")
public class HomePage extends WebPage {

    @SpringBean
    private ProductService productService;

    @SpringBean
    private SearchService searchService;

    public HomePage() {

        Model<String> colorModel = new Model<>();
        Model<String> psModel = new Model<>();
        IModel<String> model = new Model<>();


        ProductPanel productPanel = new ProductPanel("productPanel", new AbstractReadOnlyModel<List<Product>>() {
            @Override
            public List<Product> getObject() {
                //return productService.findAll(colorModel.getObject(), psModel.getObject());
                return searchService.findWord(model.getObject(),colorModel.getObject(),psModel.getObject());
            }
        });
        productPanel.setOutputMarkupId(true);

        Form filterForm = new Form("filterForm");
        add(filterForm);
        filterForm.add(new DropDownChoice<>("ps", psModel, Arrays.asList("50", "75", "100", "125", "150")));
        filterForm.add(new TextField<>("color", colorModel));
        filterForm.add(new AjaxButton("submitButton") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                target.add(productPanel);
            }
        });



        Form form = new Form("searchForm");



        /*
        ProductPanel productPanel = new ProductPanel("productPanel", new AbstractReadOnlyModel<List<Product>>() {
            @Override
            public List<Product> getObject() {
                return searchService.findWord(model.getObject());
            }
        });
        productPanel.setOutputMarkupId(true);*/


        TextField searchBox = new TextField<>("searchBox", model);
        form.add(searchBox);
        searchBox.add(new OnChangeAjaxBehavior() {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                target.add(productPanel);
            }
        });
        add(form);





        add(productPanel);
    }
}