package com.lzd.textpdfd;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFReport {

    
    public static void main(String[] args) throws Exception, DocumentException {
        
        List<String> ponum=new ArrayList<String>();
        add(ponum, 26);
        List<String> line=new ArrayList<String>();
        add(line, 26);
        List<String> part=new ArrayList<String>();
        add(part, 26);
        List<String> description=new ArrayList<String>();
        add(description, 26);
        List<String> origin=new ArrayList<String>();
        add(origin, 26);
        
        //Create Document Instance
        Document document=new Document();
        
        //add Chinese font
        BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        
        //Font headfont=new Font(bfChinese,10,Font.BOLD);
        Font keyfont=new Font(bfChinese,8,Font.BOLD);
        
        //Create Writer associated with document
        PdfWriter.getInstance(document, new FileOutputStream(new File("/app/demo/POReceiveReport.pdf")));
        
        document.open();
        
        //Seperate Page controller
        int recordPerPage=10;
        int fullPageRequired=ponum.size()/recordPerPage;
        int remainPage=ponum.size()%recordPerPage>1?1:0;
        int totalPage=fullPageRequired+remainPage;
        
        for(int j=0;j<totalPage;j++){
            document.newPage();
            
            //create page number
            String pageNo=leftPad("页码: "+(j+1)+" / "+totalPage,615);
            Paragraph pageNumber=new Paragraph(pageNo, keyfont) ;
            document.add(pageNumber);
            
            //create title image
            Image jpeg=Image.getInstance("/app/demo/title.JPG");
            jpeg.setAlignment(Image.ALIGN_CENTER);
            jpeg.scaleAbsolute(530, 37);
            document.add(jpeg);
            
            //header information
            
            
            
            
            
            //record header field
            
        }
        document.close();
    }
    
    public static String leftPad(String str, int i) {
        int addSpaceNo = i-str.length();
        String space = ""; 
        for (int k=0; k<addSpaceNo; k++){
                space= " "+space;
        };
        String result =space + str ;
        return result;
     }
    
    public static void add(List<String> list,int num){
        for(int i=0;i<num;i++){
            list.add("test"+i);
        }
    }
    
    public static String printBlank(int tmp){
          String space="";
          for(int m=0;m<tmp;m++){
              space=space+" ";
          }
          return space;
    }

}