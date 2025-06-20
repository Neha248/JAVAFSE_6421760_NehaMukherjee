public class Logger{
private static Logger logger;
// private constructor of logger class
private Logger()
{
System.out.println("Logger Intialised");
}


public static Logger getLogger()
{
  //lazy initialisation of singleton pattern
if (logger==null)
logger= new Logger();
return logger;
}



public static void test()
{
 Logger logger1 = Logger.getLogger();
// comparing hashcode to check that the object instance is created only once
System.out.println(logger1.hashCode());
 Logger logger2 = Logger.getLogger();
System.out.println(logger2.hashCode());
if(logger1==logger2)
System.out.println("Singleton Design Pattern");
else
System.out.println("Singleton Design Pattern failed");
}
public static void main(String args[]){
test();
}
}


//OUTPUT
//----------------------------------
//Logger Intialised
//617901222
//617901222
//Singleton Design Pattern
  
