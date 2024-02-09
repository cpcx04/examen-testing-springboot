package com.salesianostriana.dam.testing.examen.controller;

import com.salesianostriana.dam.testing.examen.dto.GetItemMediaFechaPoblacionDto;
import com.salesianostriana.dam.testing.examen.dto.GetMediaFechaPoblacionDto;
import com.salesianostriana.dam.testing.examen.service.ServicioMeteorologico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static javax.swing.UIManager.get;

@WebMvcTest(ControladorMeteorologico.class)
@AutoConfigureMockMvc
public class ControlladorMeteorologicoTest {

    @Autowired
    private MockMvc mvc;
    @InjectMocks
    private ServicioMeteorologico servicioMeteorologico;

    GetMediaFechaPoblacionDto getMediaFechaPoblacionDto;

    GetItemMediaFechaPoblacionDto getItemMediaFechaPoblacionDto;


    @BeforeEach
    void setUp(){
        getItemMediaFechaPoblacionDto = new GetItemMediaFechaPoblacionDto(
                "2020-12-10",
                2200
        );
        getMediaFechaPoblacionDto = new GetMediaFechaPoblacionDto(
                "Sevilla",
                Collections.singletonList(getItemMediaFechaPoblacionDto)

        );
    }
    //@Test
    //void whenMediaSemanalPorPoblacionIsValid_ThenReturnDtoAnd200(){
    //    this.mvc.perform(get("/meteo/media/semana/{ciudad}")).andExpect()
    //}



}
