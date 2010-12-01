package fr.xebia.training.jbehave.part8.finished;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import fr.xebia.training.tdd.gameoflife.Board;
import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.Universe;


public class P8FTestBoardStep {

	private Universe board;
	
	@Given("une grille vide de taille $size") 
	public void givenAGame(int size) {
		Coordinate[] initialState = new Coordinate[]{
                new Coordinate(0, 0)
        };
		board = new Board(size,  initialState );
	}
	
	@When("on joue le premier tour")
	public void whenPlayARound() {
		board.update();
	}
	
	@Then("aucune cellule n'est vivante")
	public void thenNoCellIsAlive() {
		Assert.assertEquals(0, board.liveCellsCount());
	}
	
	
}
