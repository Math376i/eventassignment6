
    import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
    class CreatePDF
    {

        {
            PDDocument pdfdoc= new PDDocument();
            pdfdoc.addPage(new PDPage());
//path where the PDF file will be store
            try {
                pdfdoc.save("C:\\Users\\Anubhav\\Desktop\\Java PDF\\Sample.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
//prints the message if the PDF is created successfully
            System.out.println("PDF created");
//closes the document
            try {
                pdfdoc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

