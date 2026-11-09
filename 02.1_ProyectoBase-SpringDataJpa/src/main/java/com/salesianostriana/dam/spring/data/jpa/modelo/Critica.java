package com.salesianostriana.dam.spring.data.jpa.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column
    private String autor;

    @Column
    private String texto;

    @Column
    private Long puntuacion;

    @ManyToOne(mappedBy = "critica")
    @JoinColumn
    private Pelicula pelicula;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Critica critica = (Critica) o;
        return id != null && Objects.equals(id, critica.id);
    }

    @Override
    public final int hashCode() {
        return 0;
    }

    public void setCritica(Pelicula pelicula) {
    }
}
