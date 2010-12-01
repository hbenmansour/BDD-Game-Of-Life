Scenario: we play only one round
GivenStories: initial_board_state.story
 
When we play the first round
Then there is 2 living cells
And the board should look like :
...
XX.
...

Scenario: we play two rounds
GivenStories: initial_board_state.story

When we play the first round
And we play another round
Then no cell is alive
And the board should look like :
...
...
...

