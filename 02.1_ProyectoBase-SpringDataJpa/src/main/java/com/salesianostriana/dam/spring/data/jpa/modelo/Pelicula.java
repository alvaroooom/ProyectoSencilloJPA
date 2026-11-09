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
public class Pelicula {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column
    private String titulo;

    @Enumerated
    private String anioEstreno;

    @OneToMany
    private Critica critica;

    @ManyToOne
    private Genero genero;

    public void addCritica(Critica critica) {
        critica.setCritica(this);
        this.critica = critica;
    }

    public void removeCritica() {
        if ( critica != null ) {
            critica.setCritica( null );
            this.critica = null;
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pelicula pelicula = (Pelicula) o;
        return getId() != null && Objects.equals(getId(), pelicula.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
