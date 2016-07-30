package com.lzd.textpdfd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateTextPdf {

	public static void main(String[] args) throws Exception{
		titleOtherGeneratePdf();
	}
	
	/**
	 * 在打开文档前，去添加标题等信息
	 * @throws DocumentException
	 * @author 刘泽栋 2016年7月26日 上午10:08:31
	 * @throws IOException 
	 */
	public static void titleOtherGeneratePdf() throws DocumentException, IOException{
		Document d = new Document();
		PdfWriter.getInstance(d, new FileOutputStream("/app/demo/title.pdf"));
		// 添加标题
		d.addTitle("我是标题");
		// 添加主题
		d.addSubject("我是主题");
		// 添加关键字
		d.addKeywords("我是关键字");
		// 添加作者
		d.addAuthor("我是刘东");
		// 添加创建者
		d.addCreator("我是刘东创建");
		// 添加创建时间
		d.addCreationDate();

		d.open();
		
		// 使itext支持中文
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
		
		
		// Paragraph为段落块
		d.add(new Paragraph("Hi 我", fontChinese));
		// Chunk 的为文本块， 后面的为设置字体样式
		d.add(new Chunk("This text is underlined", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.UNDEFINED)));
		// Phrase的为短语
		d.add(new Phrase("this is phrase"));
		
		
		d.close();
	}
	
	
	/**
	 * 生成一个简单的pdf
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @author 刘泽栋 2016年7月26日 上午9:55:36
	 */
	public void simpleGeneratePdf()  throws FileNotFoundException, DocumentException {
		// 建立Dcoument示例，使用的text中的
		Document document = new Document();
		
		// 创建一个书写器，与对象关联
		PdfWriter.getInstance(document, new FileOutputStream("/app/demo/HelloWorld.pdf"));
		
		// 打开文档
		document.open();
		
		// 向文档中添加内容
		document.add(new Paragraph("Hello World"));
		
		// 关闭文档
		document.close();
	}
	
}
