package fr.xebia.training.jbehave.part3.finished;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import fr.xebia.training.tdd.gameoflife.Board;
import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.Universe;

public class P3FTestBoardStep {

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
	
	@Given("with living cells at following positions : $table")
	public void givenInitialPositionTable(ExamplesTable table) {
		List<Map<String,String>> rows = table.getRows();
		for (Map<String, String> row : rows) {
			int x = Integer.valueOf(row.get("x"));
			int y = Integer.valueOf(row.get("y"));
			initialStates.add(new Coordinate(x, y));
		}
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
	
	@Then("there is $nbOfAliveCells living cells")
	@Alias("there is $nbOfAliveCells cells alive")
	public void thenThereIsCellsAlive(int nbOfAliveCells) {
		Assert.assertEquals(nbOfAliveCells, board.liveCellsCount());
	}

		
	
	private Coordinate[] getInitialStatesAsArray() {
		Coordinate[] coordinates = new Coordinate[initialStates.size()];
		int i = 0;
		for (Coordinate aCoordinate : initialStates) {
			coordinates[i++] = aCoordinate;
		}
		return coordinates;
	}
	
	@BeforeStory
	public void beforeStory() {
	    initialStates.clear();
	}
	
}
