package fr.xebia.training.jbehave.part3;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import fr.xebia.training.tdd.gameoflife.Board;
import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.Universe;

public class P3TestBoardStep {

	private Universe board;
	private int size;
	private Set<Coordinate> initialStates = new HashSet<Coordinate>();
	
	
	@Given("an empty board of size $size") 
	public void givenAGame(int size) {
		this.size = size;
	}
	
	@Given("with a living cell at position $x:$y")
	public void givenACellAtPosition(int x, int y) {
		initialStates.add(new Coordinate(x, y));
	}
	
	
	// FIXME : add @Given annotation using an ExamplesTable argument
	public void givenInitialPositionTable(ExamplesTable table) {
		// FIXME : loop over example table and add all initial states 
		List<Map<String,String>> rows = table.getRows();
	}
	
	
	
	@When("we play the first round")
	public void whenPlayARound() {
		this.board = new Board(this.size,  getInitialStatesAsArray() );
		board.update();
	}
	
	@Then("no cell is alive")
	public void thenNoCellIsAlive() {
		Assert.assertEquals(0, board.liveCellsCount());
	}
	
	// FIXME : add @Then annotation
	// FIXME : add @Alias annotation to recognize the different syntax flavors
	public void thenThereIsCellsAlive(int nbOfAliveCells) {
		// FIXME : assert that living cells is equal to given parameter 
		
	}

	
	private Coordinate[] getInitialStatesAsArray() {
		Coordinate[] coordinates = new Coordinate[initialStates.size()];
		int i = 0;
		for (Coordinate aCoordinate : initialStates) {
			coordinates[i++] = aCoordinate;
		}
		return coordinates;
	}
	
	// FIXME : add @BeforeStory annotation and reinitialize state
	public void beforeStory() {
	}

	
}
