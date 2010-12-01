package fr.xebia.training.jbehave.part2.finished;

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

public class P2FTestBoard extends JUnitStories {

	public Configuration configuration() {
        return new MostUsefulConfiguration()
        	.usePendingStepStrategy(new FailingUponPendingStep())
        	.useStoryLoader(new LoadFromRelativeFile(CodeLocations.codeLocationFromPath("src/test/resources/part2")))
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE)); 
    }
 
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new P2FTestBoardStep()).createCandidateSteps();
    }

	@Override
	protected List<String> storyPaths() {
		List<String> stories = new ArrayList<String>();
		stories.add("test_board_with_one_cell.story");
		stories.add("test_empty_board.story");
		return stories;
	}
	
}
