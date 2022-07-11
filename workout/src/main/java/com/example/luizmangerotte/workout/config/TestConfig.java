package com.example.luizmangerotte.workout.config;

import com.example.luizmangerotte.workout.entities.*;
import com.example.luizmangerotte.workout.entities.enums.CapacidadesFisicas;
import com.example.luizmangerotte.workout.entities.enums.GrupamentosMusculares;
import com.example.luizmangerotte.workout.entities.enums.Periodizacao;
import com.example.luizmangerotte.workout.entities.enums.TiposMicrociclos;
import com.example.luizmangerotte.workout.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    AvaliacaoRepository avaliacaoRepository;
    @Autowired
    ExercicioRepository exercicioRepository;
    @Autowired
    MacrocicloRepository macrocicloRepository;
    @Autowired
    MesocicloRepository mesocicloRepository;
    @Autowired
    MicrocicloRepository microcicloRepository;
    @Autowired
    SessaoTreinoRepository sessaoTreinoRepository;
    @Autowired
    ExercicioSessaoTreinoRepository exeSessaoTreinoRepository;


    @Override
    public void run(String... args) throws Exception {

        Aluno a1 = new Aluno(null, "Marcos Aguiar", LocalDate.of(2021,3, 1),true);
        Aluno a2 = new Aluno(null, "Ana Maria", LocalDate.of(2022, 4,5),false);
        Aluno a3 = new Aluno(null, "Fernanda Aguiar", LocalDate.of(2020,6, 1),true);
        Aluno a4 = new Aluno(null, "Cecilia Mangerotte", LocalDate.of(2019,3,1),false);

        alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4));

        Avaliacao av1 = new Avaliacao(null, a1, Instant.now(), 78.8, 1.72, 15.3, 66.8);
        Avaliacao av2 = new Avaliacao(null, a2, Instant.now(), 88.2, 1.70, 25.3, 55.6);
        Avaliacao av3 = new Avaliacao(null, a1, Instant.now(), 89.2, 1.72, 25.3, 55.6);
        DobrasCutaneas db = new DobrasCutaneas(null, av1, 5.6,7.8,9.9,15.3,11.5,12.3,9.8,14.5,17.5,18.6);
        DobrasCutaneas db2 = new DobrasCutaneas(null, av2, 2.6,9.8,11.9,12.3,10.5,14.3,10.0,12.5,18.5,10.6);
        DobrasCutaneas db3 = new DobrasCutaneas(null, av3, 2.6,9.8,11.9,12.3,10.5,14.3,10.0,12.5,18.5,10.6);

        av1.setDobrasCutaneas(db);
        av2.setDobrasCutaneas(db2);
        av3.setDobrasCutaneas(db3);

        avaliacaoRepository.saveAll(Arrays.asList(av1, av2));

        Exercicio ex1 = new Exercicio(null, "Supino Reto", GrupamentosMusculares.PEITO, "Kr2erpSyu3M&ab_channel=MyTrainingPRO");
        Exercicio ex2 = new Exercicio(null, "Barra Fixa", GrupamentosMusculares.COSTAS, "P02aNg8xg34&ab_channel=FábricadeMonstros");
        Exercicio ex3 = new Exercicio(null, "Agachamento Livre", GrupamentosMusculares.QUADRICEPS, "GXlJYdZImU4&ab_channel=MyTrainingPRO");

        exercicioRepository.saveAll(Arrays.asList(ex1,ex2,ex3));

        Macrociclo macro1 = new Macrociclo(null, "Hipertrofia", Periodizacao.LINEAR, LocalDate.of(2022,3,5), LocalDate.of(2023,3,5), a1);
        Macrociclo macro2 = new Macrociclo(null, "Emagrecimento",Periodizacao.LINEAR_REVERSA, LocalDate.of(2022,5,10), LocalDate.of(2023,5,10), a3);
        Macrociclo macro3 = new Macrociclo(null, "Hipertrofia", Periodizacao.ONDULATORIA, LocalDate.of(2020,4,10), LocalDate.of(2021,4,10), a2);

        macrocicloRepository.saveAll(Arrays.asList(macro1, macro2, macro3));

        Mesociclos meso1 = new Mesociclos(null, CapacidadesFisicas.FORCA_MAXIMA, LocalDate.of(2022,5,12), LocalDate.of(2022, 8, 12), macro1);
        Mesociclos meso2 = new Mesociclos(null, CapacidadesFisicas.FORCA_RESISTENCIA, LocalDate.of(2022,8,13), LocalDate.of(2022, 12, 13), macro1);
        Mesociclos meso3 = new Mesociclos(null, CapacidadesFisicas.FORCA_POTENCIA, LocalDate.of(2022,7,10), LocalDate.of(2022, 8, 17), macro3);

        mesocicloRepository.saveAll(Arrays.asList(meso1, meso2, meso3));

        Microciclo micro1 = new Microciclo(null, TiposMicrociclos.ESTABILIZADOR, LocalDate.of(2022,7,10), LocalDate.of(2022,7,17), meso3);
        Microciclo micro2 = new Microciclo(null, TiposMicrociclos.CHOQUE, LocalDate.of(2022,7,18), LocalDate.of(2022,7,25), meso3);
        Microciclo micro3 = new Microciclo(null, TiposMicrociclos.RECUPERATIVO, LocalDate.of(2022,7,26), LocalDate.of(2022,8,02), meso3);

        Microciclo micro4 = new Microciclo(null, TiposMicrociclos.RECUPERATIVO, LocalDate.of(2022,5,12), LocalDate.of(2022,5,19), meso1);
        Microciclo micro5 = new Microciclo(null, TiposMicrociclos.COMPETITIVO, LocalDate.of(2022,5,19), LocalDate.of(2022,5,26), meso1);

        microcicloRepository.saveAll(Arrays.asList(micro1, micro2, micro3, micro4, micro5));

        SessaoTreino s1 = new SessaoTreino(null, LocalDate.of(2022,7,10), "Treino A", micro1, 85.0);
        SessaoTreino s2 = new SessaoTreino(null, LocalDate.of(2022,7,11), "Treino B", micro1, 85.0);
        SessaoTreino s3 = new SessaoTreino(null, LocalDate.of(2022,7,12), "Treino C", micro1, 85.0);
        SessaoTreino s4 = new SessaoTreino(null, LocalDate.of(2022,7,14), "Treino D", micro1, 85.0);

        sessaoTreinoRepository.saveAll(Arrays.asList(s1, s2,s3, s4));

        ExercicioSessaoTreino exs1 = new ExercicioSessaoTreino(ex1, s1, "12 a 15", 60.0, "Moderada", 4);
        ExercicioSessaoTreino exs2 = new ExercicioSessaoTreino(ex2, s1, "12 a 15", 60.0, "Moderada", 4);
        ExercicioSessaoTreino exs3 = new ExercicioSessaoTreino(ex3, s1, "6 a 8", 60.0, "Moderada", 4);

        exeSessaoTreinoRepository.saveAll(Arrays.asList(exs1, exs2, exs3));
    }
}
