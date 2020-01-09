package app.kiosk;

import app.mainUI.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "kiosks", layout = MainLayout.class)
@ParentLayout(MainLayout.class)
@UIScope
public class KiosksRoute extends VerticalLayout implements RouterLayout {
    public KiosksRoute(KioskView view, KiosksPresenter presenter){
        super(view);
        presenter.view(view);
    }
}
