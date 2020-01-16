package ShopzoneServer;

import ShopzoneServer.business.impl.repositories.*;
import ShopzoneServer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.StandardEmitterMBean;
import java.util.*;

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
            negozio.setCitta("Teramo");
            negozio.setVia("Via Madonna degli Angeli, 8");
            negozio.setImmagineprofilo("Negozio0.jpg");
            List<Notizia> notizie= new LinkedList<Notizia>() ;
            negozio.setNotizie(notizie);
            negozioRepository.save(negozio);


            Negozio negozio2 = new Negozio();
            negozio2.setNome("Bershka");
            negozio2.setDescrizione("Abbigliamento uomo donna, orario continuato");
            negozio2.setCitta("Pescara");
            negozio2.setVia("Via Pettino, 8");
            negozio.setNotizie(notizie);
            negozio2.setImmagineprofilo("Negozio2.jpg");
            negozioRepository.save(negozio2);


            Negozio negozio3 = new Negozio();
            negozio3.setNome("Stardust");
            negozio3.setDescrizione("Stardust2 dal 2010");
            negozio3.setVia("Via Santa Lucia,22");
            negozio3.setCitta("Teramo");
            negozio.setNotizie(notizie);
            negozio3.setImmagineprofilo("negozio3.jpg");
            negozioRepository.save(negozio3);


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


            Negoziante laura = new Negoziante();
            laura.setUsername("laura");
            laura.setPassword(passwordEncoder.encode("laura"));
            laura.setNome("Laura");
            laura.setCognome("Gentile");
            laura.setEmail("laura.business@business.it");
            laura.setNegozio(negozio3);
            utenteRepository.save(laura);


            Utente stefano = new Utente();
            stefano.setUsername("stefano");
            stefano.setPassword(passwordEncoder.encode("stefano"));
            stefano.setNome("Stefano");
            stefano.setCognome("Tassoni");
            stefano.setEmail("stefano.tassato@professional.it");
            utenteRepository.save(stefano);


            for (int i = 0; i < 10; i++) {
                Notizia notizia = new Notizia();
                notizia.setTitolo("Pellentesque habitant morbi tristique senectus " + i);
                notizia.setDescrizione("Sconti di " + i + "% su tutta la collezione ");
                Date dataPubblicazione = new Date(System.currentTimeMillis() - (i * 86400000));
                notizia.setDataPubblicazione(dataPubblicazione);
                notizia.setImmagine("image" + i + ".jpg");

                double rnd = Math.random();
                if (rnd < 0.3) {

                    negozio.addNotizia(notizia);

                } else {
                    if (rnd < 0.6) {
                        negozio2.addNotizia(notizia);
                    } else {
                        negozio3.addNotizia(notizia);
                    }

                }

                notiziaRepository.save(notizia);

            }

            negozio.addPreferenzaUtente(stefano);
            negozio.addPreferenzaUtente(laura);
            negozio2.addPreferenzaUtente(stefano);
            utenteRepository.save(stefano);
            utenteRepository.save(laura);

            System.out.println(stefano.getNegoziPreferiti());
            System.out.println(negozio.getPreferiti());
            negozioRepository.save(negozio2);


            negozio.removePreferenzaUtente(stefano);



            System.out.println(negozio.getPreferiti());
            System.out.println(stefano.getNegoziPreferiti());

        };
    }


}
