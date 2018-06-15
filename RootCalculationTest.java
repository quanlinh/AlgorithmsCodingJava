import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RootCalculationTest {
    private RootCalculation rootCalculation;
    private double epsilon;
    private double nine;
    private double squareRootNine;
    private double five;
    private double squareRootFive;
    private double one;
    private double squareRootOne;
    double half;
    double getSquareRootHalf;
    @BeforeEach
    void setUp()
    {
          one = 1.0;
          squareRootOne = 1.0;
          epsilon = 0.0001;
          nine = 9.0;
          squareRootNine = 3.0;
          rootCalculation = new RootCalculation();
          five = 5.0;

          // using the math function to test it , not sure it is not a good ideas
          squareRootFive = Math.sqrt(5);
          System.out.println(Math.sqrt(0.1));
          half = 0.5;
          getSquareRootHalf = Math.sqrt(half);

    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void squareRootInsideRange()
    {
        assert(rootCalculation.squareRoot(nine)  <= (squareRootNine + epsilon));
        assert(rootCalculation.squareRoot(nine)  >= (squareRootNine - epsilon));
        assert(rootCalculation.squareRoot(five)  <= (squareRootFive + epsilon));
        assert(rootCalculation.squareRoot(five)  >= (squareRootFive - epsilon));
        assert(rootCalculation.squareRoot(one)  >= (squareRootOne - epsilon));
        assert(rootCalculation.squareRoot(one)  >= (squareRootOne - epsilon));
    }

    @Test
    void bisectionSearch()
    {

    }

    @Test
    void bisectionSearchFraction()
    {
//        System.out.println(Math.sqrt(0.5));
        System.out.println(rootCalculation.squareRoot(half));
        assert(rootCalculation.squareRoot(half)  <= (getSquareRootHalf + epsilon));
        assert(rootCalculation.squareRoot(half)  >= (getSquareRootHalf - epsilon));
    }


}