//Common interface for all doc types
public interface Document
{
void type();
} 

//concrete products 
public class WordDocument implements Document{
public void type(){
System.out.println("Opening Word Document");
} 
}
public class PdfDocument implements Document{
public void type(){
System.out.println("Opening Pdf Document ");
} 
}
public class  ExcelDocument implements Document{
public void type(){
System.out.println("Opening  ExcelDocument");
} 
}
//factory interface
public abstract class DocumentFactory{
public abstract Document createDocument();
}
//concrete factories
public class WordDocumentFactory extends DocumentFactory{
public Document createDocument(){
return new WordDocument();
}
}
public class PdfDocumentFactory extends DocumentFactory{
public Document createDocument(){
return new PdfDocument();
}
}
public class ExcelDocumentFactory extends DocumentFactory{
public Document createDocument(){
return new ExcelDocument();
}
}
//Test class
public class Client {
public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.type();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.type();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.type();
    }
}
/*OUTPUT
-------------------------
Opening Word Document
Opening Pdf Document 
Opening  ExcelDocument
*/
