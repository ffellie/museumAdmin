package app.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "kiosk")
@Data
@NoArgsConstructor
public class Kiosk {
    @Id
    @GeneratedValue
    private long id;

    private int number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;
}
