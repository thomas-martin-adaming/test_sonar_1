package com.inti.run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inti.entities.Adresse;
import com.inti.entities.Avis;
import com.inti.entities.Destination;
import com.inti.entities.Hotel;
import com.inti.entities.Reservation;
import com.inti.entities.Type;
import com.inti.entities.Voyageur;
import com.inti.service.interfaces.IAvisService;
import com.inti.service.interfaces.IDestinationService;
import com.inti.service.interfaces.IHotelService;
import com.inti.service.interfaces.IReservationService;
import com.inti.service.interfaces.ITypeService;
import com.inti.service.interfaces.IVoyageurService;

public class Test {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Date d1 = formater.parse("10-12-2018");
		Date d2 = formater.parse("11-12-2018");
		Date d3 = formater.parse("20-12-2018");
		Date d4 = formater.parse("31-12-2018");

		Adresse adresse1 = new Adresse("31 rue de la Folie Méricourt", "Paris");
		Adresse adresse2 = new Adresse("80, boulevard de Picpus", "Paris");

		IVoyageurService voyageurService = (IVoyageurService) context.getBean("voyageurService");
		IAvisService avisService = (IAvisService) context.getBean("avisService");
		IReservationService reservationService = (IReservationService) context.getBean("reservationService");
		IDestinationService destinationService = (IDestinationService) context.getBean("destinationService");
		IHotelService hotelService = (IHotelService) context.getBean("hotelService");
		ITypeService typeService = (ITypeService) context.getBean("typeService");

		Voyageur voyageur1 = new Voyageur("Ayari", "Oussama");
		Voyageur voyageur2 = new Voyageur("Ayari", "Fatma");
		voyageurService.save(voyageur1);
		voyageurService.save(voyageur2);

		Avis avis1 = new Avis(d3,
				"Fantastique, l'accueil, l'amabilité et la prévenance du personnel tout en discrétion", voyageur1);
		Avis avis2 = new Avis(d4, "Superbe hôtel, bien placé service hyper sympa.", voyageur2);
		avisService.save(avis1);
		avisService.save(avis2);

		Destination destination1 = new Destination(adresse1, "France");
		Destination destination2 = new Destination(adresse2, "France");
		destinationService.save(destination1);
		destinationService.save(destination2);

		Hotel h1 = new Hotel("Hôtel Fabric", 5, destination1);
		Hotel h2 = new Hotel("Hôtel du printemps", 5, destination2);
		hotelService.save(h1);
		hotelService.save(h2);

		Type type1 = new Type("Chambre familiale");
		Type type2 = new Type("Suite");
		typeService.save(type1);
		typeService.save(type2);

		Reservation reservation1 = new Reservation(d1, destination1, type2, voyageur1);
		Reservation reservation2 = new Reservation(d2, destination2, type1, voyageur2);
		reservationService.save(reservation1);
		reservationService.save(reservation2);

		List<Voyageur> voyageurs = voyageurService.findAll(Voyageur.class);
		for (Voyageur voyageur : voyageurs) {
			System.out.println(voyageur.toString());
		}
		
	}

}
