package app.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "image")
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue
    private long id;

    private String caption;

    @NotNull
    @Lob
    private byte[] file;
}
