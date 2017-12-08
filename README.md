# UCLDraw
How to calculate the probability distribution of UEFA Champions League Draw (round of 16)

The group winners are as follows: 
(A) Manchester United, England
(B) Paris Saint-Germain, France
(C) Roma, Italy
(D) Barcelona, Spain
(E) Liverpool, England
(F) Manchester City, England
(G) Besitkas, Turkey
(H) Tottenham, England

Each of those teams will be drawn against a second-place finisher.

The runner-ups from the group stage are: 
(A) FC Basel, Swiss
(B) Bayern Munich, Germany
(C) Chelsea, England
(D) Juventus, Italy
(E) Sevilla, Spain
(F) Shakhtar Donetsk, Ukraine
(G) Porto, Portugal
(H) Real Madrid, Spain

There are two rules to keep in mind when watching the draw.
1) clubs cannot play against a team that was in its same group in the group stage.
2) clubs from the same country cannot meet until the quarterfinals. 

Besides, clubs from Ukraine cannot play against Russian clubs.

There are 2 java files and 2 text files in this project:
- Club.java, the implementation of a football club
- Draw16.java, the main part of our algorithm, which find all possible results with recursive backtracking, export these result into a text file, calculate and print out the probability distribution.
- draws.txt, all possible results of UCL Draw
- prob.txt, the probability distribution
