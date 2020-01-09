package app.kiosk;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class KioskEditRoute extends Dialog  {
    public KioskEditRoute(){
        super();
    }
    public KioskEditRoute(int kioskID){
        this();

    }

}
