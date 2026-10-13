START

    CREATE list of month names (Jan through Dec)
    CREATE list of sales-change values, in the same order as the months

    SET bestPeriod = result of FIND BEST PERIOD using the sales values
    SET startIndex = first item of bestPeriod
    SET endIndex = second item of bestPeriod

    DISPLAY results using the months, sales values, startIndex, and endIndex

END 





Receives the list of sales values. Returns the start and end positions of the best consecutive period.

FUNCTION FIND BEST PERIOD (sales)

    // Start with the first month as the best period so far.
    // This also makes the all-negative case work correctly.
    SET bestTotal = sales at position 0
    SET bestStart = 0
    SET bestEnd = 0

    // Outer loop: choose each possible starting position
    FOR each startPosition from 0 to the last position in sales

        // Begin a fresh running total for this starting position
        SET currentTotal = 0

        // Inner loop: extend the period one month at a time
        FOR each endPosition from startPosition to the last position in sales

            // Add the newest month to the running total
            ADD sales at endPosition to currentTotal

            // Compare with the best total found so far.
            // Strictly greater than, so a tie does NOT replace the earlier period.
            IF currentTotal is greater than bestTotal THEN
                SET bestTotal = currentTotal
                SET bestStart = startPosition
                SET bestEnd = endPosition
            END IF

        END FOR

    END FOR

    RETURN bestStart and bestEnd



Receives the sales values and a start and end position. Returns the sum of that range.

FUNCTION CALCULATE PERIOD TOTAL (sales, start, end)

    SET total = 0

    FOR each position from start to end
        ADD sales at position to total
    END FOR

    RETURN total

END FUNCTION


Display Results / print all results

Receives the month names, sales values, and the best start and end positions.

FUNCTION DISPLAY RESULTS (months, sales, start, end)

    SET total = CALCULATE PERIOD TOTAL (sales, start, end)

    DISPLAY "Sales Analysis"
    DISPLAY a line of dashes
    DISPLAY "Start Month: " 
    DISPLAY "End Month:   " 
    DISPLAY "Total Sales Change: " total in millions "

END FUNCTION