package fr.xebia.training.jbehave.part6;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

public class P6TestBoard extends JUnitStories {

	public Configuration configuration() {
		// FIXME : create Properties for view options
		// FIXME : add a property "decorateNonHtml"
        
        return new MostUsefulConfiguration()
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	.useStoryLoader(new LoadFromRelativeFile(CodeLocations.codeLocationFromPath("src/test/resources/part6")))
        	.useStoryReporterBuilder(new StoryReporterBuilder()
            			.withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
            			// FIXME : bind view resources to the reporter builder
            			.withDefaultFormats()
            			// FIXME : add Html format to reporter builder
            			.withFormats(Format.CONSOLE, Format.STATS)); 
        
        // *********************************************************************************************
        // If properly configured, the jbehave reports site should be generated in : target/jbehave/view
        // *********************************************************************************************
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P6TestBoardStep()).createCandidateSteps();
    }

	@Override
	protected List<String> storyPaths() {
		List<String> stories = new ArrayList<String>();
		stories.add("test_board_with_one_cell.story");
		stories.add("test_board_with_many_cell.story");
		stories.add("test_board_with_many_cell_with_alias.story");
		stories.add("test_board_with_many_cell_with_many_round.story");
		stories.add("test_empty_board.story");
		return stories;
	}

    
	
	
}

