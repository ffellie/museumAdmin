package app.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("login")
@UIScope
public class LoginRoute extends VerticalLayout {
    public LoginRoute (LoginView view, LoginPresenter presenter) {
        super(view);
        setSizeFull();
        presenter.view(view);
        this.setAlignItems(Alignment.CENTER);
    }
}
