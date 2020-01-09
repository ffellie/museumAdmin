package app.kiosk;

import app.data.Kiosk;
import app.data.Strings;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Getter
public class KioskView extends VerticalLayout  {
    private Grid<Kiosk> kioskGrid;
    private Button addButton;
    public KioskView(){
        setupGrid();
        setupAddButton();
        style();
    }

    private void setupGrid(){
        kioskGrid = new Grid<>(Kiosk.class);
        kioskGrid.removeColumnByKey("id");
        kioskGrid.removeColumnByKey("ruText");
        kioskGrid.removeColumnByKey("kzText");
        kioskGrid.removeColumnByKey("enText");
        kioskGrid.removeColumnByKey("image");
        kioskGrid.setColumns("number", "description");
        kioskGrid.getColumnByKey("number").setHeader(Strings.KIOSK_NUMBER);
        kioskGrid.getColumnByKey("description").setHeader(Strings.DESCRIPTION);
        add(kioskGrid);
    }

    private void setupAddButton(){
        addButton = new Button(Strings.ADD_KIOSK);
        HorizontalLayout wrapper = new HorizontalLayout(addButton);
        wrapper.setAlignItems(Alignment.BASELINE);
        wrapper.setAlignItems(Alignment.END);

        wrapper.setWidth("100%");
        add(wrapper);
    }

    private void style() {
        getElement().getStyle().set("margin-left","15%");
        getElement().getStyle().set("margin-right","15%");

        getElement().getStyle().set("width","70%");
    }
}
