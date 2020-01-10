package app.kiosk;

import app.components.ImageUpload;
import app.data.Image;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.spring.annotation.UIScope;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
@UIScope
public class KioskEditPresenter {
    private KioskEditView view;
    public void view (KioskEditView view){
        this.view=view;
    }
    private Image image;
    public ImageUpload getImageUpload (){
        MemoryBuffer buffer = new MemoryBuffer();
        ImageUpload imageUpload = new ImageUpload(buffer);
        image = new Image();

        try {
            image.setFile(IOUtils.toByteArray(buffer.getInputStream()));
            setPoster();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return imageUpload;
    }

    void setPoster () {
        view.getPoster().setSrc(new StreamResource("image.png", () -> new ByteArrayInputStream(image.getFile())));
    }

}
