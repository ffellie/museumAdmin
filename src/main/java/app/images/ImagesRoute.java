package app.images;

import app.mainUI.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "images", layout = MainLayout.class)
@UIScope
public class ImagesRoute extends VerticalLayout {
    public ImagesRoute(){}
}
