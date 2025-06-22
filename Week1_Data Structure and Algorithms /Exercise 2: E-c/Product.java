import java.util.*;
class Product
{
int productId ;
String productName, category;

public Product ( int productId, String productName , String category)
{
this.productId=productId;
this.productName=productName;
this.category=category;
}
public int getproductId(){
return productId;
}
public String getproductName(){
return productName;
}

public String getcategory(){
return category;
}

//linear search
public static void linearsearch(Product[] products , int productid){
int flag =0;
for (Product product : products){
if(product.getproductId()==productid)
{
flag =1;
System.out.println("Product :" +product.getproductName()+"\nCategory:" +product.getcategory());
break;
}
}
if(flag==0)
System.out.println("No such Product");
}

// binary search
public static void binarysearch(Product[] products , int productid){
Arrays.sort(products,Comparator.comparingInt(Product::getproductId));
int flag=0, left=0,right=products.length-1;
while(left<=right){
int mid = (left+right)/2;
if(products[mid].getproductId()==productid)
{
flag=1;
System.out.println("Product:"+products[mid].getproductName()+"\nCategory:"+ products[mid].getcategory());
break;
}
else if(products[mid].getproductId()<productid)
left = mid+1;
else
right=mid-1;
}
if (flag==0)
System.out.println("No such Product");
}





public static void main(String args[]){
   Scanner sc = new Scanner (System.in);
   Product[] products ={
    new Product(1, "Laptop", "Electronics"),
    new Product(2, "Shampoo", "Personal Care"),
    new Product(3, "Book", "Stationery"),
    new Product(4, "Mobile", "Electronics"),
    new Product(5, "Pen", "Stationery") };





System.out.print("Enter the product ID for linear searching : ");
int searchId=sc.nextInt();
linearsearch(products , searchId);

System.out.print("Enter the product ID for binary searching : ");
searchId=sc.nextInt();
binarysearch(products , searchId);
sc.close();
}
}

