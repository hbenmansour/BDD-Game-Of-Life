package fr.xebia.training.jbehave.part8;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import fr.xebia.training.jbehave.part8.finished.P8FTestBoardStep;

public class P8TestBoard extends JUnitStories {

	public Configuration configuration() {
		Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        
        return new MostUsefulConfiguration()
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	.useStoryLoader(new LoadFromRelativeFile(CodeLocations.codeLocationFromPath("src/test/resources/part8")))
               	// FIXME : add created KeyWord to configuration

            // **************** 
        	// There's a bug in the most useful configuration : it does'nt propagade correctly the newly set keywords
        	// We have to set it explicitly in the regex story parser !! (bouuh...)

            .useStoryParser(new RegexStoryParser(setKeyWords()))
        	.useStoryReporterBuilder(new StoryReporterBuilder()
            			.withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
            			.withViewResources(viewResources)
            			.withDefaultFormats()
            			.withFormats(Format.CONSOLE, Format.HTML)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P8FTestBoardStep()).createCandidateSteps();
    }
    
    private Keywords setKeyWords() {
    	// FIXME : create French keyword set
		return null;
	}

	@Override
	protected List<String> storyPaths() {
		List<String> stories = new ArrayList<String>();
		stories.add("test_empty_board.story");
		return stories;
	}

    
	
	
}

