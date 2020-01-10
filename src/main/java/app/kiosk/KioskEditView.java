package app.kiosk;

import app.components.ImageUpload;
import app.data.Strings;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@UIScope
@Component
@Getter
public class KioskEditView extends Dialog {
    KioskEditPresenter presenter;
    @Setter
    private Image poster;
    private Label title;
    private NumberField numberField;
    private TextField descriptionField;
    private TextArea ruTextField,kzTextField, enTextField;
    private Button saveButton,cancelButton;
    private ImageUpload imageUpload;

    public KioskEditView (KioskEditPresenter presenter){
        super();
        this.presenter = presenter;
        presenter.view(this);
        initialize();

    }

    private void initialize (){
        setWidth("1200px");
        title = new Label("Добавить киоск");
        title.getStyle()
                .set("font-size", "22pt")
                .set("color", "black")
                .set("font-weight", "bold");
        numberField = new NumberField();
        descriptionField = new TextField();
        ruTextField = new TextArea();
        kzTextField = new TextArea();
        enTextField = new TextArea();
        ruTextField.setHeight("250px");
        ruTextField.setWidthFull();
        ruTextField.setLabel(Strings.KIOSK_RU_TEXT);
        enTextField.setHeight("250px");
        enTextField.setWidthFull();
        enTextField.setLabel(Strings.KIOSK_EN_TEXT);
        kzTextField.setHeight("250px");
        kzTextField.setWidthFull();
        kzTextField.setLabel(Strings.KIOSK_KZ_TEXT);
        numberField.setLabel("Номер киоска");
        numberField.setMaxLength(2);
        descriptionField.setLabel(Strings.KIOSK_DESCRITION);
        descriptionField.setWidth("400px");

        cancelButton = new Button("Отмена");
        saveButton = new Button("Сохранить");
        saveButton.getElement().getStyle()
                .set("color", "white")
                .set("background","#1976d2");
        poster = new Image();
        imageUpload = presenter.getImageUpload();
        HorizontalLayout hl1 = new HorizontalLayout(numberField, descriptionField);
        VerticalLayout textContainer = new VerticalLayout();
        VerticalLayout cont = new VerticalLayout(hl1,imageUpload,poster);
        textContainer.add( ruTextField,kzTextField, enTextField);
        HorizontalLayout hl2 = new HorizontalLayout(cont, textContainer);
        HorizontalLayout buttonsContainer = new HorizontalLayout(cancelButton, saveButton);
        add(title);
        add(hl2,buttonsContainer);
    }



}
