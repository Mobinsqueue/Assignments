Problem : Company wants to know consecutive period of months with highest combined sale change

data received : 12 months of value in USD with positive values being increases and negative being decreases

results : best period's starting month, ending month and total combined sales




String[] months will store months since they are strings and not numbers

double[] salesChange will hold sale values because its numbers being stored

two arrays are parallel and have same length any index input gives the month name and it's value

variables needed for
currentTotal: running total of the periods and reset back to 0 each time a new starting position is chosen\
bestTotal: largest combined amount found so far starting from first index counting even if value is negative

remembering best period by two variables bestStart and bestEnd starting from 0 and whenever currentTotal is higher than bestTotal replacing them

program will use greater > value not greater equal >= and choose the higher one for ties

program organization:

main(): two arrays, calls the other method in order and keeps logic out of itself

findBestPeriod(double[] salesChange): use nested loops to run the periods and track the amounts and return best start and end

calculatePeriodTotal(double[] salesChange, int start, int end): Adds up the values from start through end and returns the total.

and lastly print result of start month, end month and total

Program flow:
Start-create arrays - set values for start, end, best total and current total - calculate  total and replace if greater than best total - repeat - end