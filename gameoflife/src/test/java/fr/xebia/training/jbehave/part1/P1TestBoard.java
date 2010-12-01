package fr.xebia.training.jbehave.part1;

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


public class P1TestBoard extends JUnitStory {
	/*
	 * Create configuration using the given bean MostUsefulConfiguration 
	 */
	public Configuration configuration() {
        return new MostUsefulConfiguration()
        	// The pending step strategy specifies how jbehave must act when the steps are not found (ie in pending state)
        	// By default, the pending steps don't make the test fail
        	// Here, we configure jbehave to fail on pending steps
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	
        	// The story loader specifies that the story to be launched is directly in the classpath
        	// and is named following the default convention (ie same name as class, all in lower case, separated with "_"
            .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))  
            
            // PT3 : We redirect the full output to the console 
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
    	
    	// FIXME : register step (P1TestBoardStep) using instance steps factory default constructor  
        return new InstanceStepsFactory(configuration()).createCandidateSteps();
    }

	
}
