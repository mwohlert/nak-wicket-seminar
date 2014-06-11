package de.nordakademie.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import de.nordakademie.business.message.Message;
import de.nordakademie.business.message.MessageService;

@MountPath("home")
public class HomePage extends WebPage {

    @SpringBean
    private MessageService messageService;

    public HomePage() {
        add(new ListView<Message>("messages", messageService.findAll()) {

            @Override
            protected void populateItem(final ListItem<Message> item) {
                item.add(new Label("message", getString(item.getModelObject().getMessageKey())));
            }
        });
    }
}
