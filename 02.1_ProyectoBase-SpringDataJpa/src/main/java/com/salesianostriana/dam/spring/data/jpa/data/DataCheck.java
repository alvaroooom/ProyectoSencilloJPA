package com.salesianostriana.dam.spring.data.jpa.data;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@DependsOn("dataSeed")
public class DataCheck {

    private final TransactionTemplate transactionTemplate;

    public DataCheck(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);

    }

    @PostConstruct
    public void comprobarDatos() {

        transactionTemplate.executeWithoutResult(status -> {
            // Comprobación A: consultas y acceso a las asociaciones
            // Comprobación B: borrado y consulta de los nuevos totales
        });

    }

}

