package app.kiosk;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class KiosksPresenter {

    public void view(KioskView view){
        view.getAddButton().addClickListener(buttonClickEvent -> {
            view.getEditDialog().open();
        });
    }

}
