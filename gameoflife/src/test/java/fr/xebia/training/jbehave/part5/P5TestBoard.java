package fr.xebia.training.jbehave.part5;

import java.util.ArrayList;
import java.util.List;

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

import fr.xebia.training.jbehave.part5.finished.P5FTestBoardStep;

public class P5TestBoard extends JUnitStories {

	public Configuration configuration() {
        return new MostUsefulConfiguration()
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	.useStoryLoader(new LoadFromRelativeFile(CodeLocations.codeLocationFromPath("src/test/resources/part5")))
            .useStoryReporterBuilder(new StoryReporterBuilder()
            			.withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
            			.withDefaultFormats()
            			.withFormats(Format.CONSOLE)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P5FTestBoardStep()).createCandidateSteps();
    }

	@Override
	protected List<String> storyPaths() {
		List<String> stories = new ArrayList<String>();
		stories.add("test_board_with_one_cell.story");
		stories.add("test_board_with_many_cell.story");
		stories.add("test_board_with_many_cell_with_alias.story");
		// FIXME : correct the story following the instructions given in the following story file
		stories.add("test_board_with_many_cell_with_many_round.story");
		stories.add("test_empty_board.story");
		return stories;
	}

    
	
	
}

