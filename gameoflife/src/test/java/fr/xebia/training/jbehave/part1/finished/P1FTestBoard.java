package fr.xebia.training.jbehave.part1.finished;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class P1FTestBoard extends JUnitStory {

	/*
	 * Cr�ation d'une configuration la plus simple possible 
	 */
	public Configuration configuration() {
        return new MostUsefulConfiguration()
        	// PT1 : La pendingStepStrategie indique � Jbehave la strat�gie � tenir lorsque 
        	//		 les steps ne sont pas trouv�s (� l'�tat PENDING) 
        	// 		 par d�faut, les steps � l'�tat PENDING ne font pas �chouer le test
        	// 		 Ici, on indique que le test doit �chouer sur un step non trouv�
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	
        	// PT2 : Le story loader indique que la story � charger est pr�sente dans le classpath, 
        	//		 et porte par convention le nom de la classe en minuscule s�par� par des _ (ici test_one_cell.story)
            .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))  
            
            // PT3 : On sort le rapport vers la console 
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P1FTestBoardStep()).createCandidateSteps();
    }
	
}
