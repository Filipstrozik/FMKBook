package controllers;

import com.fmkbook.springbootbackend.controllers.RezerwacjaApi;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.services.RezerwacjaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RezerwacjaApiTest {

    @Mock
    private RezerwacjaService rezerwacjaService;

    @InjectMocks
    private RezerwacjaApi rezerwacjaApi;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Rezerwacja> rezerwacjas = Arrays.asList(new Rezerwacja(), new Rezerwacja());
        when(rezerwacjaService.getAllRezerwacjas()).thenReturn(rezerwacjas);

        // When
        ResponseEntity<List<Rezerwacja>> response = rezerwacjaApi.findAll();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rezerwacjas, response.getBody());
        verify(rezerwacjaService, times(1)).getAllRezerwacjas();
    }

//    @Test
//    public void testFindAllByDate() {
//        // Given
//        LocalDate startDate = LocalDate.now();
//        LocalDate endDate = startDate.plusDays(1);
//        List<Rezerwacja> rezerwacjas = Arrays.asList(new Rezerwacja(), new Rezerwacja());
//        when(rezerwacjaService.getReservationsByDate(startDate, endDate)).thenReturn(rezerwacjas);
//
//        // When
//        ResponseEntity<List<Rezerwacja>> response = rezerwacjaApi.findAllByDate(startDate, endDate);
//
//        // Then
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(rezerwacjas, response.getBody());
//        verify(rezerwacjaService, times(1)).getReservationsByDate(startDate, endDate);
//    }

    @Test
    public void testFindById() {
        // Given
        Integer id = 1;
        Optional<Rezerwacja> rezerwacja = Optional.of(new Rezerwacja());
        when(rezerwacjaService.getRezerwacjaById(id)).thenReturn(rezerwacja);

        // When
        ResponseEntity<Rezerwacja> response = rezerwacjaApi.findById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rezerwacja.get(), response.getBody());
        verify(rezerwacjaService, times(1)).getRezerwacjaById(id);
    }
}
