package br.encurtador.controlers;

import br.encurtador.services.EncurtadorSerivce;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.mapping.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class EncurtadorControler {

    private EncurtadorSerivce  serivce;

    public EncurtadorControler(EncurtadorSerivce serivceerivce){
        this.serivce = serivceerivce;
    }

    @PostMapping("/encurtar")
    public ResponseEntity<String>encurtarURL(@RequestBody Map request)
    {
        String urlCurta = serivce.encurtarURL("url");
        return ResponseEntity.ok(urlCurta);
    }

    public void redirecionar(@PathVariable String codigoCurto, HttpServletResponse response) throws IOException {
        serivce.obterURLOriginal(codigoCurto)
                .ifPresentOrElse(
                        urlOriginal -> {
                            try {
                                response.sendRedirect(urlOriginal);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            throw new RuntimeException("URL não encontrada.");
                        }
                );
    }
}
