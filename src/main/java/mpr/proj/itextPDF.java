package mpr.proj;
import java.io.FileOutputStream;

import mpr.proj.pedigree.Horse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;




public abstract class itextPDF {
	

	  public static void createPDF() {
	    try {
	      Document document = new Document();
	      PdfWriter.getInstance(document, new FileOutputStream("plik.pdf"));
	      document.open();
	      addMetaData(document);
	      addContent(document);
	      document.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }


	  private static void addMetaData(Document document) {
	    document.addTitle("Rodowod konia");
	    document.addSubject("Projekt");
	    document.addAuthor("Filip Lech");
	    document.addCreator("Filip Lech");
	  }
	  
	

	  private static void addContent(Document document) throws DocumentException {

	    System.out.println("Podaj ID konia: ");
	    int id = EasyIn.getInt();
	    Horse horse = DBMetody.idKon(id);
	    System.out.println("Podaj glebokosc rodowodu.");
	      int glebokosc = EasyIn.getInt();
	    Paragraph subPara = new Paragraph("Rodowod konia o imieniu "+ horse.getName());
	    document.add(subPara);
	    
	    if(glebokosc > 0){
			if(horse.getSire() != null){
				int iterator = glebokosc;
			subPara.add(new Paragraph("Ojciec konia "+horse.getName() + " ---> " + horse.getSire().getName()));
		
					rodowodoPDF(document,horse.getSire(), iterator -=1);
			}else System.out.println ("Brak ojca w bazie danych.");
			
			if(horse.getDam() != null){
				subPara.add("Matka konia "+horse.getName() + " ---> " + horse.getDam().getName());

					rodowodoPDF(document,horse.getDam(), glebokosc -=1);
			}else System.out.println ("Brak ojca w bazie danych.");
			document.add(subPara);
		}
	    
	

	  }
	  public static void rodowodoPDF(Document document,Horse horse,int glebokosc) throws DocumentException{
		  Paragraph subPara = new Paragraph();
			if(glebokosc > 0){
				if(horse.getSire() != null){
					int iterator = glebokosc;
				subPara.add(new Paragraph("Ojciec konia "+horse.getName() + " ---> " + horse.getSire().getName()));

						rodowodoPDF(document,horse.getSire(), iterator -=1);
				}else System.out.println ("Brak ojca w bazie danych.");
				
				if(horse.getDam() != null){
					subPara.add("Matka konia "+horse.getName() + " ---> " + horse.getDam().getName());
					
						rodowodoPDF(document,horse.getDam(), glebokosc -=1);
				}else System.out.println ("Brak ojca w bazie danych.");
			}document.add(subPara);
			
			
			
		}

	
}
