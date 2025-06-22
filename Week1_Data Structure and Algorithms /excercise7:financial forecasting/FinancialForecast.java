import java.util.*;
class FinancialForecast{
// recursive method to calculate future value
public static double findfuturevalue( int year , double initialvalue , double growthrate)
{
if (year==0)
return initialvalue;
 else 
return findfuturevalue(year-1 , initialvalue,growthrate)*(1+growthrate);
}



public static void main(String args[]){
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the initial value: ");
double initialvalue = scanner.nextDouble();

System.out.print("Enter the annual growth rate (in percentage): ");
double growthRatePercent = scanner.nextDouble();

System.out.print("Enter the number of years to forecast: ");
int years = scanner.nextInt();
double growthrate = growthRatePercent / 100.0;

double futurevalue = findfuturevalue(years,initialvalue,growthrate);
System.out.printf("Predicted value after %d years: %.2f", years, futurevalue);
scanner.close();
}
}
