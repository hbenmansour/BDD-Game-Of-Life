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
	 * Création d'une configuration la plus simple possible 
	 */
	public Configuration configuration() {
        return new MostUsefulConfiguration()
        	// PT1 : La pendingStepStrategie indique à Jbehave la stratégie à tenir lorsque 
        	//		 les steps ne sont pas trouvés (à l'état PENDING) 
        	// 		 par défaut, les steps à l'état PENDING ne font pas échouer le test
        	// 		 Ici, on indique que le test doit échouer sur un step non trouvé
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	
        	// PT2 : Le story loader indique que la story à charger est présente dans le classpath, 
        	//		 et porte par convention le nom de la classe en minuscule séparé par des _ (ici test_one_cell.story)
            .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))  
            
            // PT3 : On sort le rapport vers la console 
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P1FTestBoardStep()).createCandidateSteps();
    }
	
}
