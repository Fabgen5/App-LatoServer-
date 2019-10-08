package ShopzoneServer;

import ShopzoneServer.business.impl.repositories.*;
import ShopzoneServer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ShopzoneServerApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(ShopzoneServerApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(UtenteRepository utenteRepository, NotiziaRepository notiziaRepository, NegozioRepository negozioRepository) {
        return (args) -> {


            Negozio negozio = new Negozio();
            negozio.setNome("Freeway");
            negozio.setDescrizione("Freeway");
            negozio.setCategoria("Streetwear");
            negozio.setGiorniapertura("Lun-Ven");
            negozio.setPiva("Freeway");
            negozio.setOrario("9:00-18:00");
            negozio.setImmagineprofilo("Negozio0.jpg");
            negozio= negozioRepository.save(negozio);


            Negozio negozio2 = new Negozio();
            negozio2.setNome("Stardust");
            negozio2.setDescrizione("Stardust dal 1999");
            negozio2.setCategoria("Streetwear");
            negozio2.setGiorniapertura("Lun-Ven");
            negozio2.setPiva("Stardust");
            negozio2.setOrario("9:00-18:00");
            negozio2.setImmagineprofilo("Negozio2.jpg");
            negozio2= negozioRepository.save(negozio2);







            Negoziante marco = new Negoziante();
            marco.setUsername("marco");
            marco.setPassword(passwordEncoder.encode("marco"));
            marco.setNome("Marco");
            marco.setCognome("Autili");
            marco.setEmail("marco.mengoni@gaio.it");
            marco.setNegozio(negozio);
            marco = utenteRepository.save(marco);

            Negoziante fabio = new Negoziante();
            fabio.setUsername("fabio");
            fabio.setPassword(passwordEncoder.encode("fabio"));
            fabio.setNome("Fabio");
            fabio.setCognome("Gentile");
            fabio.setEmail("fabio.quartararo@business.it");
            fabio.setNegozio(negozio2);
            fabio = utenteRepository.save(fabio);

            Utente stefano = new Utente();
            stefano.setUsername("stefano");
            stefano.setPassword(passwordEncoder.encode("stefano"));
            stefano.setNome("Stefano");
            stefano.setCognome("Tassoni");
            stefano.setEmail("stefano.tassato@professional.it");
            utenteRepository.save(stefano);

            Set<Utente> piace= new HashSet<>();
            piace.add(marco);
            piace.add(fabio);
            for (int i = 0; i < 10; i++) {
                Notizia notizia = new Notizia();
                notizia.setTitolo("Annuncio " + i);
                notizia.setDescrizione("Sconti di " + i + "% su tutta la collezione ");
                Date dataPubblicazione = new Date(System.currentTimeMillis() - (i * 86400000));
                notizia.setDataPubblicazione(dataPubblicazione);
                notizia.setImmagine("image"+ i+".jpg");
                notizia.setPubblicatoDa(negozio);
                notizia.setUtentePiace(piace);
                notiziaRepository.save(notizia);
            }

        };
    }

}
