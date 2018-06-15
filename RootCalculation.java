public class RootCalculation {
    public double squareRoot (double n)
    {
        double epsilon = 0.0001;
        if (n >= 1)               return  bisectionSearch(n,1.0, n, epsilon);
        else if( n >= 0 && n < 1) return  bisectionSearch(n,0.0,1.0-epsilon,epsilon);
        else                      throw  new IllegalStateException("Can not calculate square root of negative numbers");
    }

    public double bisectionSearch(double n, double lo,double hi,double epsilon)
    {
        double mid  = (lo + hi) / 2;
        if (Math.abs(mid*mid - n) <= epsilon)  return mid;
        if(mid*mid > n)                        return bisectionSearch(n,lo,mid,epsilon);
        else                                   return bisectionSearch(n,mid,hi,epsilon);
    }

}
