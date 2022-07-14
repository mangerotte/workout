package com.example.luizmangerotte.workout.config;

import com.example.luizmangerotte.workout.entities.*;
import com.example.luizmangerotte.workout.entities.enums.PhysicalSkills;
import com.example.luizmangerotte.workout.entities.enums.MuscleGroup;
import com.example.luizmangerotte.workout.entities.enums.Periodization;
import com.example.luizmangerotte.workout.entities.enums.TypeMicrocycle;
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
    ClientRepository clientRepository;
    @Autowired
    PhysicalExaminationRepository physicalExaminationRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    MacrocycleRepository macrocycleRepository;
    @Autowired
    MesocycleRepository mesocycleRepository;
    @Autowired
    MicrocycleRepository microcycleRepository;
    @Autowired
    TrainingSessionRepository trainingSessionRepository;
    @Autowired
    TrainingSessionExerciseRepository exeSessaoTreinoRepository;
    @Autowired
    SetRepository setRepository;


    @Override
    public void run(String... args) throws Exception {

        Client a1 = new Client(null, "Marcos Aguiar", LocalDate.of(2022,6,20),true);
        Client a2 = new Client(null, "Ana Maria", LocalDate.of(2022,1,21),false);
        Client a3 = new Client(null, "Fernanda Aguiar", LocalDate.of(2021,5,22),true);
        Client a4 = new Client(null, "Cecilia Mangerotte", LocalDate.of(2022,1,1),false);

        clientRepository.saveAll(Arrays.asList(a1, a2, a3, a4));

        PhysicalExamination av1 = new PhysicalExamination(null, a1, Instant.now(), 78.8, 1.72, 15.3, 66.8);
        PhysicalExamination av2 = new PhysicalExamination(null, a2, Instant.now(), 88.2, 1.70, 25.3, 55.6);
        PhysicalExamination av3 = new PhysicalExamination(null, a1, Instant.now(), 89.2, 1.72, 25.3, 55.6);
        SkinFold db = new SkinFold(null, av1, 5.6,7.8,9.9,15.3,11.5,12.3,9.8,14.5,17.5);
        SkinFold db2 = new SkinFold(null, av2, 2.6,9.8,11.9,12.3,10.5,14.3,10.0,12.5, 14.3);
        SkinFold db3 = new SkinFold(null, av3, 2.6,9.8,11.9,12.3,10.5,14.3,10.0,12.5, 5.5);

        av1.setSkinFold(db);
        av2.setSkinFold(db2);
        av3.setSkinFold(db3);

        physicalExaminationRepository.saveAll(Arrays.asList(av1, av2));

        Exercise ex1 = new Exercise(null, "Supino Reto", MuscleGroup.CHEST, "Kr2erpSyu3M&ab_channel=MyTrainingPRO");
        Exercise ex2 = new Exercise(null, "Barra Fixa", MuscleGroup.BACK, "P02aNg8xg34&ab_channel=FábricadeMonstros");
        Exercise ex3 = new Exercise(null, "Agachamento Livre", MuscleGroup.QUADRICEPS, "GXlJYdZImU4&ab_channel=MyTrainingPRO");

        exerciseRepository.saveAll(Arrays.asList(ex1,ex2,ex3));

        Macrocycle macro1 = new Macrocycle(null, "Hipertrofia", Periodization.LINEAR, LocalDate.of(2022,3,5), LocalDate.of(2023,3,5), a1);
        Macrocycle macro2 = new Macrocycle(null, "Emagrecimento", Periodization.REVERSE_LINEAR, LocalDate.of(2022,5,10), LocalDate.of(2023,5,10), a3);
        Macrocycle macro3 = new Macrocycle(null, "Hipertrofia", Periodization.UNDULATING, LocalDate.of(2020,4,10), LocalDate.of(2021,4,10), a2);

        macrocycleRepository.saveAll(Arrays.asList(macro1, macro2, macro3));

        Mesocycle meso1 = new Mesocycle(null, PhysicalSkills.MAXIMUM_STRENGTH, LocalDate.of(2022,5,12), LocalDate.of(2022, 8, 12), macro1);
        Mesocycle meso2 = new Mesocycle(null, PhysicalSkills.ENDURANCE_STRENGTH, LocalDate.of(2022,8,13), LocalDate.of(2022, 12, 13), macro1);
        Mesocycle meso3 = new Mesocycle(null, PhysicalSkills.CARDIOVASCULAR_ENDURANCE, LocalDate.of(2022,7,10), LocalDate.of(2022, 8, 17), macro3);

        mesocycleRepository.saveAll(Arrays.asList(meso1, meso2, meso3));

        Microcycle micro1 = new Microcycle(null, TypeMicrocycle.INTRODUCTORY, LocalDate.of(2022,7,10), LocalDate.of(2022,7,17), meso3);
        Microcycle micro2 = new Microcycle(null, TypeMicrocycle.SHOCK, LocalDate.of(2022,7,18), LocalDate.of(2022,7,25), meso3);
        Microcycle micro3 = new Microcycle(null, TypeMicrocycle.RESTORATIVE, LocalDate.of(2022,7,26), LocalDate.of(2022,8,02), meso3);

        Microcycle micro4 = new Microcycle(null, TypeMicrocycle.ACTIVATION, LocalDate.of(2022,5,12), LocalDate.of(2022,5,19), meso1);
        Microcycle micro5 = new Microcycle(null, TypeMicrocycle.STANDARD, LocalDate.of(2022,5,19), LocalDate.of(2022,5,26), meso1);

        microcycleRepository.saveAll(Arrays.asList(micro1, micro2, micro3, micro4, micro5));

        TrainingSession s1 = new TrainingSession(null, LocalDate.of(2022,7,10), "Treino A", micro1);
        TrainingSession s2 = new TrainingSession(null, LocalDate.of(2022,7,11), "Treino B", micro1);
        TrainingSession s3 = new TrainingSession(null, LocalDate.of(2022,7,12), "Treino C", micro1);
        TrainingSession s4 = new TrainingSession(null, LocalDate.of(2022,7,14), "Treino D", micro1);

        trainingSessionRepository.saveAll(Arrays.asList(s1, s2,s3, s4));

        TrainingSessionExercise exs1 = new TrainingSessionExercise(null, "12 a 15", 60.0, "Moderada", 4, ex1, s1);
        TrainingSessionExercise exs2 = new TrainingSessionExercise(null, "8 a 10", 60.0, "Moderada", 3, ex2, s1);
        TrainingSessionExercise exs3 = new TrainingSessionExercise(null, "6 a 8", 60.0, "Lenta", 3, ex3, s1);

        exeSessaoTreinoRepository.saveAll(Arrays.asList(exs1, exs2, exs3));

        SetExercise setExercise1 = new SetExercise(null, 50.0, 10, exs1);
        SetExercise setExercise2 = new SetExercise(null, 48.0, 12, exs1);
        SetExercise setExercise3 = new SetExercise(null, 47.0, 15, exs1);
        SetExercise setExercise4 = new SetExercise(null, 47.0, 15, exs1);
        SetExercise setExercise5 = new SetExercise(null, 33.0,  20, exs2);
        SetExercise setExercise6 = new SetExercise(null, 44.0, 12, exs2);
        SetExercise setExercise7 = new SetExercise(null, 50.0, 8, exs2);
        SetExercise setExercise8 = new SetExercise(null, 20.0, 8, exs3);
        SetExercise setExercise9 = new SetExercise(null, 20.0, 8, exs3);
        SetExercise setExercise10 = new SetExercise(null, 20.0, 8, exs3);

        setRepository.saveAll(Arrays.asList(setExercise1, setExercise2, setExercise3, setExercise4, setExercise5, setExercise6, setExercise7, setExercise8, setExercise9, setExercise10));


    }
}
