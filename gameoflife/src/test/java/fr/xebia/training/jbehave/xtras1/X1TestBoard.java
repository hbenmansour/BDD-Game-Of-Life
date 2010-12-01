package fr.xebia.training.jbehave.xtras1;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyLoader = X1TestBoard.MyStoryLoader.class, 
			storyReporterBuilder = X1TestBoard.MyReportBuilder.class)
@UsingEmbedder(embedder = Embedder.class, ignoreFailureInStories = false)
@UsingSteps(instances = {X1TestBoardStep.class})
public class X1TestBoard extends InjectableEmbedder {

	
	private static final String STORY_PATH = "src/test/resources/part6";

	@Override
	@Test
	public void run() throws Throwable {
		 List<String> storyPaths = new StoryFinder().findPaths(STORY_PATH, Arrays.asList("**/*.story"), Arrays.asList(""));
		 injectedEmbedder().runStoriesAsPaths(storyPaths);
	}

	public static class MyStoryLoader extends LoadFromRelativeFile {
	       public MyStoryLoader()  {
	            super(CodeLocations.codeLocationFromPath(STORY_PATH));
	        }
	}
	
	 public static class MyReportBuilder extends StoryReporterBuilder {
	        public MyReportBuilder() {
	            this.withFormats(Format.CONSOLE).withDefaultFormats();
	        }
	    }
	 

	
}
