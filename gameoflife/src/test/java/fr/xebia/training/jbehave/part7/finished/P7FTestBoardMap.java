package fr.xebia.training.jbehave.part7.finished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStoryMaps;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class P7FTestBoardMap extends JUnitStoryMaps {

	
	
	
	public P7FTestBoardMap() {
		configuredEmbedder().useMetaFilters(metaFilters());
	
	}

	public Configuration configuration() {
		Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        
        return new MostUsefulConfiguration()
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	.useStoryLoader(new LoadFromRelativeFile(CodeLocations.codeLocationFromPath("src/test/resources/part7")))
        	.useStoryReporterBuilder(new StoryReporterBuilder()
            			.withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
            			.withViewResources(viewResources)
            			.withDefaultFormats()
            			.withFormats(Format.CONSOLE, Format.HTML, Format.STATS)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P7FTestBoardStep()).createCandidateSteps();
    }

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths("src/test/resources/part7", Arrays.asList("**/*.story"), Arrays.asList(""));
		
	}

	@Override
	protected List<String> metaFilters() {
		return Arrays.asList("+complexity simple", "+complexity complex");
	}

    
	
	
}

