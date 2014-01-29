package mpr.proj;
import java.io.FileOutputStream;
import java.util.Date;

import mpr.proj.pedigree.Horse;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;




public abstract class itextPDF {
	  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	      Font.BOLD);
	  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	      Font.BOLD);

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
	    Anchor anchor = new Anchor("Rodowod konia", catFont);
	    System.out.println("Podaj ID konia: ");
	    int id = EasyIn.getInt();
	    Horse horse = DBMetody.idKon(id);
	    System.out.println("Podaj glebokosc rodowodu.");
	      int glebokosc = EasyIn.getInt();
	    Paragraph subPara = new Paragraph("Rodowod konia o imieniu "+ horse.getName());
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
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		/*for (int i=1 ; i<=glebokosc ; i++){
			if (horse.getSire() != null){
				subPara.add(new Paragraph("Meski przodek o glebokosci " + i));
				subPara.add(new Paragraph(horse.getSire().getName()));
			horse = horse.getSire();
			}else break;
			
		}
		horse = DBMetody.idKon(id);
		for (int i=1 ; i<=glebokosc ; i++){
			if (horse.getDam() != null ){
				subPara.add(new Paragraph("Zenski przodek o glebokosci " + i));
				subPara.add(new Paragraph(horse.getDam().getName()));
			horse = horse.getDam();
		}
		else break;
		}*/
	   subPara.add(new Paragraph("linia2", subFont));
	    // add a listsubFon
	    // now add all this to the document
	    document.add(subPara);

	  }
	  public static void rodowodoPDF(Document document,Horse horse,int glebokosc) throws DocumentException{
		  Paragraph subPara = new Paragraph();
			if(glebokosc > 0){
				if(horse.getSire() != null){
					int iterator = glebokosc;
				subPara.add(new Paragraph("Ojciec konia "+horse.getName() + " ---> " + horse.getSire().getName()));
				document.add(subPara);
						rodowodoPDF(document,horse.getSire(), iterator -=1);
				}else System.out.println ("Brak ojca w bazie danych.");
				
				if(horse.getDam() != null){
					subPara.add("Matka konia "+horse.getName() + " ---> " + horse.getDam().getName());
					document.add(subPara);
						rodowodoPDF(document,horse.getDam(), glebokosc -=1);
				}else System.out.println ("Brak ojca w bazie danych.");
			}
			
			
			
		}

	  private static void createList(Section subCatPart) {
	    List list = new List(true, false, 10);
	    list.add(new ListItem("First point"));
	    list.add(new ListItem("Second point"));
	    list.add(new ListItem("Third point"));
	    subCatPart.add(list);
	  }

	  private static void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	      paragraph.add(new Paragraph(" "));
	    }
	  }

}
