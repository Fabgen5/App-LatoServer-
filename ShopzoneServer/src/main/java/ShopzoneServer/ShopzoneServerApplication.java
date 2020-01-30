package ShopzoneServer;

import ShopzoneServer.business.impl.repositories.*;
import ShopzoneServer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.io.FileInputStream;
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
            File file = new File("Immagini-DB/Logofreeway.jpg");
            byte[] picInBytes = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
            negozio.setImmagineprofilo(picInBytes);

            negozio = negozioRepository.save(negozio);


            Negozio negozio2 = new Negozio();
            negozio2.setNome("Bershka");
            negozio2.setDescrizione("Abbigliamento uomo donna, orario continuato");
            negozio2.setCitta("Pescara");
            negozio2.setVia("Via Pettino, 8");
            File file2 = new File("Immagini-DB/Bershka.jpg");
            byte[] picInBytes2 = new byte[(int) file2.length()];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            fileInputStream2.read(picInBytes2);
            fileInputStream2.close();
            negozio2.setImmagineprofilo(picInBytes2);
            negozio2 = negozioRepository.save(negozio2);


            Negozio negozio3 = new Negozio();
            negozio3.setNome("Sottotono");
            negozio3.setDescrizione("Stardust2 dal 2010");
            negozio3.setVia("Via Santa Lucia,22");
            negozio3.setCitta("Teramo");
            File file3 = new File("Immagini-DB/sottotono.jpg");
            byte[] picInBytes3 = new byte[(int) file3.length()];
            FileInputStream fileInputStream3 = new FileInputStream(file3);
            fileInputStream3.read(picInBytes3);
            fileInputStream3.close();
            negozio3.setImmagineprofilo(picInBytes3);

            negozio3 = negozioRepository.save(negozio3);


            Utente marco = new Utente();
            marco.setUsername("marco");
            marco.setPassword(passwordEncoder.encode("marco"));
            marco.setNome("Marco");
            marco.setCognome("Autili");
            marco.setEmail("marco.mengoni@gaio.it");
            marco.setNegozio(negozio);
            marco = utenteRepository.save(marco);

            Utente fabio = new Utente();
            fabio.setUsername("fabio");
            fabio.setPassword(passwordEncoder.encode("fabio"));
            fabio.setNome("Fabio");
            fabio.setCognome("Gentile");
            fabio.setEmail("fabio.quartararo@business.it");
            fabio.setNegozio(negozio2);
            fabio = utenteRepository.save(fabio);


            Utente laura = new Utente();
            laura.setUsername("laura");
            laura.setPassword(passwordEncoder.encode("laura"));
            laura.setNome("Laura");
            laura.setCognome("Gentile");
            laura.setEmail("laura.business@business.it");
            laura.setNegozio(negozio3);
            laura = utenteRepository.save(laura);


            Utente stefano = new Utente();
            stefano.setUsername("stefano");
            stefano.setPassword(passwordEncoder.encode("stefano"));
            stefano.setNome("Stefano");
            stefano.setCognome("Tassoni");
            stefano.setEmail("stefano.tassato@professional.it");
            stefano = utenteRepository.save(stefano);


            for (int i = 0; i < 10; i++) {
                Notizia notizia = new Notizia();
                notizia.setTitolo("Pellentesque habitant morbi tristique senectus " + i);
                notizia.setDescrizione("Sconti di " + i + "% su tutta la collezione ");
                Date dataPubblicazione = new Date(System.currentTimeMillis() - (i * 86400000));
                notizia.setDataPubblicazione(dataPubblicazione);

                File fileimmagine = new File("Immagini-DB/image" + i +".jpg");
                byte[] immagineInBytes = new byte[(int) fileimmagine.length()];
                FileInputStream fileInputStreamImmagini = new FileInputStream(fileimmagine);
                fileInputStreamImmagini.read(immagineInBytes);
                fileInputStreamImmagini.close();
                notizia.setImmagine(immagineInBytes);

                double rnd = Math.random();
                if (rnd < 0.3) {

                    notizia.setNegozio(negozio);
                    notizia = notiziaRepository.save(notizia);
                    stefano.getNotiziePiaciute().add(notizia);
                } else {
                    if (rnd < 0.6) {
                        notizia.setNegozio(negozio2);
                        notizia = notiziaRepository.save(notizia);
                        fabio.getNotiziePiaciute().add(notizia);
                        stefano.getNotiziePiaciute().add(notizia);
                        laura.getNotiziePiaciute().add(notizia);

                    } else {

                        notizia.setNegozio(negozio3);
                        notizia = notiziaRepository.save(notizia);
                        laura.getNotiziePiaciute().add(notizia);
                        marco.getNotiziePiaciute().add(notizia);


                    }

                }

            }
            negozio2.getPreferiti().add(laura);
            negozio.getPreferiti().add(laura);
            negozio2.getPreferiti().add(stefano);
            negozioRepository.save(negozio2);
            negozioRepository.save(negozio);
            utenteRepository.save(laura);
            utenteRepository.save(stefano);
            utenteRepository.save(marco);
            utenteRepository.save(fabio);

        };
    }


}
