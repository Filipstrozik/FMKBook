package controllers;

import com.fmkbook.springbootbackend.controllers.RabatApi;
import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import com.fmkbook.springbootbackend.services.RabatService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.fmkbook.springbootbackend.SpringbootBackendApplication.class})
public class RabatApiTest {

    private RabatApi rabatApi;

    @MockBean
    private RabatService rabatService;

    @Before
    public void init(){
        rabatApi = new RabatApi(rabatService);
    }
    @Test
    public void updateRabatTest() {
        Integer idUser = 1;
        String idRabatu = "test_rabat";
        Rabat rabat = new Rabat();
        rabat.setId(idRabatu);
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setId(idUser);
        rabat.setUzytkownikiduzytkownika(uzytkownik);

        when(rabatService.updateRabat(idUser, idRabatu)).thenReturn(rabat);

        ResponseEntity<Rabat> response = rabatApi.updateRabat(idUser, idRabatu);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rabat, response.getBody());
    }
    @Test
    public void updateRabatNotFoundTest() {
        Integer idUser = 1;
        String idRabatu = "test_rabat";

        when(rabatService.updateRabat(idUser, idRabatu)).thenReturn(null);

        ResponseEntity<Rabat> response = rabatApi.updateRabat(idUser, idRabatu);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
//    Ten test jednostkowy korzysta z adnotacji @MockBean do utworzenia fałszywej implementacji RabatService,
//    a następnie ustawia metodę updateRabat tak, aby zwracała stworzony obiekt Rabat.
//    Następnie test wywołuje metodę updateRabat w RabatApi i sprawdza, czy zwracana jest
//    odpowiedź HTTP OK oraz czy zwracany obiekt Rabat jest taki sam jak stworzony przed testem.
//    Drugi test jest do sprawdzenie, czy przy braku obiektu zwraca odpowiedni status Http.