package edu.utn.PracticaParcial;

import edu.utn.PracticaParcial.model.Player;
import edu.utn.PracticaParcial.model.Team;
import edu.utn.PracticaParcial.repository.PlayerRepository;
import edu.utn.PracticaParcial.repository.TeamRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PracticaParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaParcialApplication.class, args);
	}

	//This code will be run after the aplication starts
	//Saves time by not inputing data to h2 database manually each restart
	@Bean
	ApplicationRunner init(PlayerRepository playerRepository, TeamRepository teamRepository) {
		return args -> {
			Team team1 = new Team();
			team1.setName("Boca");
			Team team2 = new Team();
			team2.setName("River");

			teamRepository.save(team1);
			teamRepository.save(team2);

			Player player1 = Player.builder().age(20).name("Jugador1").registeredDate(LocalDate.of(2018,12,20)).team(team1).build();

			Player player2 = Player.builder().age(20).name("Jugador2").registeredDate(LocalDate.of(2018,10,20)).team(team1).build();

			Player player3 = Player.builder().age(20).name("Jugador3").registeredDate(LocalDate.of(2019,4,18)).team(team1).build();

			Player player4 = Player.builder().age(20).name("Jugador4").registeredDate(LocalDate.of(2019,1,13)).team(team1).build();

			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);
		};
	}
}
