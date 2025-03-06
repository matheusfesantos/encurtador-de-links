package br.encurtador.services;

import br.encurtador.entity.urlEncurtada;
import br.encurtador.repository.URLEncurtadaRepos;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EncurtadorSerivce
{
    private URLEncurtadaRepos urlEncurtadaRepos;

    public EncurtadorSerivce(URLEncurtadaRepos urlEncurtadaRepos){
        this.urlEncurtadaRepos=urlEncurtadaRepos;
    }

    public String encurtarURL(String urlOriginal){
        String urlCurta = UUID.randomUUID().toString().substring(0,8);
        urlEncurtada urlEncurtada = new urlEncurtada(urlOriginal,urlCurta);
        urlEncurtadaRepos.save(urlEncurtada);
        return urlCurta;
    }

    public Optional<String> obterURLOriginal(String urlCurta){
        return urlEncurtadaRepos.findByCodigoCurto(urlCurta).map(urlEncurtada::getUrlOriginal);
    }
}
