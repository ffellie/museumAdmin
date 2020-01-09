package app.mainUI;


import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import lombok.Getter;

//@Route("")
public class MainLayout extends AppLayout implements RouterLayout {
    @Getter
    private Tab kioskTab, imageTab;
    public MainLayout (){
        setPrimarySection(AppLayout.Section.DRAWER);
        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
//        addToNavbar(new DrawerToggle(), img);
        kioskTab = new Tab("Киоски");
        imageTab = new Tab("Изображения");
        Tabs tabs = new Tabs(kioskTab, imageTab);
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.getElement().getStyle().set("margin-left", "40%");
        addToNavbar(tabs);

        tabs.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent selectedChangeEvent) {
                if(selectedChangeEvent.getSelectedTab()==kioskTab)
                    getUI().ifPresent(ui -> ui.navigate("kiosks"));
                else if(selectedChangeEvent.getSelectedTab()==imageTab)
                    getUI().ifPresent(ui -> ui.navigate("images"));
            }
        });
    }
}
