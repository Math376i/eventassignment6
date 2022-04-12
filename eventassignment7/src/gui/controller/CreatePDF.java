package gui.controller;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.IOException;

public class CreatePDF {

    {

        {
            PDDocument pdfdoc= new PDDocument();
            pdfdoc.addPage(new PDPage());

            try {
                pdfdoc.save("C:\\Users\\desktop\\Sample.pdf");
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


}
