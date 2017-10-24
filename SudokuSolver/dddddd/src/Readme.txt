In second part, 
1. I try to find all the possible numbers for all the blanks firstly, store is an 3D array may[i][j][k].
2. Then, if there is any blank have only one possible number, so I can fill this number in the blank.
3. After that, some other blanks' possible number will be changed, so I can go back to Step 2.
-----At this point, I can solve 9Easy.txt and 9OneSpot.txt
4. Then I try to find if there is any possible number of any blank only appear once at the same row, or same line or same small grid. So this number can also be fixed in this blank. And go back to Step 2 again.