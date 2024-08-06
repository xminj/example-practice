package com.xminj.util;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;

import java.io.FileOutputStream;
import java.io.IOException;

public class ItextpdfUtil {
    private ItextpdfUtil() {
    }

    /**
     * html转pdf
     *
     * @param html     html代码
     * @param fontPath 字体路径
     * @param pdfPath  pdf路径
     */
    public static void convertToPdf(String html, String fontPath, String pdfPath) {
        try (FileOutputStream out = new FileOutputStream(pdfPath)) {
            // 创建 PDF Writer
            PdfWriter writer = new PdfWriter(out);

            // 创建 PDF Document
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.A4);

            // 设置字体
            ConverterProperties properties = new ConverterProperties();
            FontProvider fontProvider = new FontProvider();


            // 加载中文字体
            PdfFont microsoft = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, false);
            fontProvider.addFont(microsoft.getFontProgram(), PdfEncodings.IDENTITY_H);
            properties.setFontProvider(fontProvider);

            HtmlConverter.convertToPdf(html, pdfDocument, properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
