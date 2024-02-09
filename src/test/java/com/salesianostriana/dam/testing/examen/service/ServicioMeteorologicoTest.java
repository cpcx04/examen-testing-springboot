package com.salesianostriana.dam.testing.examen.service;

import com.salesianostriana.dam.testing.examen.model.DatoMeteorologico;
import com.salesianostriana.dam.testing.examen.model.DatoMeterologicoPK;
import com.salesianostriana.dam.testing.examen.repo.DatoMeteorologicoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicioMeteorologicoTest {

    @InjectMocks
    private  ServicioMeteorologico servicioMeteorologico;

    @Mock
    private DatoMeteorologicoRepository repository;


    @Test
    void mediaDiaSemanaTest(){
        DatoMeterologicoPK pk1 = new DatoMeterologicoPK("Sevilla", LocalDate.of(2020,12,20));

        DatoMeteorologico d1 = DatoMeteorologico.builder()
                .id(pk1)
                .precipitacion(200)
                .build();

        Mockito.when(repository.buscarPorPoblacion("Sevilla")).thenReturn(List.of(d1));

        Map<String,Double> mediaDiaSemana= servicioMeteorologico.mediaDiaSemana("Sevilla");

        assertNotNull(mediaDiaSemana);
        assertFalse(mediaDiaSemana.isEmpty());

    }

}
