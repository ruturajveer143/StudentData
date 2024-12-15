package com.servlet;
import java.io.OutputStream;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.Entitys.StudentData;
import com.Helper.FactoryProvider;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;

public class DownloadPDFServlet extends jakarta.servlet.http.HttpServlet {

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=StudentData.pdf");

        try (OutputStream out = response.getOutputStream()) {
            
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

           
            Font headingFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.DARK_GRAY);
            Paragraph heading = new Paragraph("Student Data Report", headingFont);
            heading.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(heading);

            
            document.add(new Paragraph("\n"));

           
            PdfPTable table = new PdfPTable(5); 
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

           
            Font headerFont = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
            
            table.addCell(createCell("@ID", headerFont, BaseColor.YELLOW));
            table.addCell(createCell("Date & Time", headerFont, BaseColor.YELLOW));
            table.addCell(createCell("Name", headerFont, BaseColor.YELLOW));
            table.addCell(createCell("Age", headerFont, BaseColor.YELLOW));
            table.addCell(createCell("Location", headerFont, BaseColor.YELLOW));

          
            Session session = FactoryProvider.getFactory().openSession();
            Query<StudentData> query = session.createQuery("from StudentData", StudentData.class);
            List<StudentData> list = query.list();

            for (StudentData student : list) {
                table.addCell(String.valueOf(student.getId()));
                table.addCell(String.valueOf(student.getAddedDate()));
                table.addCell(student.getName());
                table.addCell(String.valueOf(student.getAge()));
                table.addCell(student.getLocation());
            }

            session.close();

            // Add table to the document
            document.add(table);

            // Add a line break before footer
            document.add(new Paragraph("\n"));

            // Footer section with 2 lines
            Font footerFont = new Font(Font.FontFamily.COURIER, 10, Font.ITALIC, BaseColor.LIGHT_GRAY);
            Paragraph footer = new Paragraph("This is the student record auto-generated.", footerFont);
            footer.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(footer);

            footer = new Paragraph("This project developed by @Ruturaj Veer", footerFont);
            footer.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(footer);

            document.close();
        } catch (DocumentException e) {
            throw new IOException("Error while generating PDF: " + e.getMessage(), e);
        }
    }

    // Helper method to create cells with specific font and background color
    private PdfPCell createCell(String content, Font font, BaseColor bgColor) {
        PdfPCell cell = new PdfPCell(new Paragraph(content, font));
        cell.setBackgroundColor(bgColor);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        return cell;
    }
}
