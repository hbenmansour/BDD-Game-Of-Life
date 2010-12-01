package fr.xebia.training.jbehave.part2;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.mockito.internal.configuration.ClassPathLoader;

public class P2TestBoard extends JUnitStories {

	public Configuration configuration() {
        return new MostUsefulConfiguration()
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	// FIXME : Change story loader to use LoadFromRelativeFile loader (use CodeLocations utility class)
        	.useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P2TestBoardStep()).createCandidateSteps();
    }

	@Override
	protected List<String> storyPaths() {
    	// FIXME : list all stories in src/test/resources/part2
		return new ArrayList<String>();
	}
	
}
