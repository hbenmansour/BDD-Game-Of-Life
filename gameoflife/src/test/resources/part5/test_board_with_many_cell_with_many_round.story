!-- Add the "scenario" keyword to distinguish each scenario  
!-- Use the "GivenStories" keyword to execute a story that initialize the board  
!-- 	the same way as in test_board_with_many_cell.story (by the way, you have to create a new file ;-p )
 
When we play the first round
Then there is 2 living cells
And the board should look like :
...
XX.
...

!-- Add the "scenario" keyword to distinguish each scenario
!-- reuse the "GivenStories" keyword from the first scenario

When we play the first round
And we play another round
Then no cell is alive
And the board should look like :
...
...
...

