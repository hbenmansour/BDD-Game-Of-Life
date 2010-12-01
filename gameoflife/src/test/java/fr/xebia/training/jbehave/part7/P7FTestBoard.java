package fr.xebia.training.jbehave.part7;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class P7FTestBoard extends JUnitStories {

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
            			.withFormats(Format.CONSOLE, Format.HTML)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P7TestBoardStep()).createCandidateSteps();
    }

	@Override
	protected List<String> storyPaths() {
		List<String> stories = new ArrayList<String>();
		stories.add("test_board_with_one_cell.story");
		stories.add("test_board_with_many_cell.story");
		stories.add("test_board_with_many_cell_with_alias.story");
		stories.add("test_empty_board.story");
		return stories;
	}

    
	
	
}

