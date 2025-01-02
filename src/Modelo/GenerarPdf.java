
package Modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class GenerarPdf {
    public void generarTicketCompra(String archivoRuta, String cliente, String vuelo, double precio, String asiento, String clase) {
        try {
            // Crear el documento
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(archivoRuta));
            documento.open();
            
            // Agregar el logo
            String logoPath = "src/Img/viva-aerobus-logo-374569F0FD-seeklogo.com-2.png";
            Image logo = Image.getInstance(logoPath);
            logo.scaleToFit(100, 50); // Ajusta el tamaño del logo
            logo.setAlignment(Element.ALIGN_CENTER);
            documento.add(logo);

            BaseColor verdeBandera = new BaseColor(0, 128, 0);
            Font fontVerde = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, verdeBandera);

            // Agregar título
            Paragraph titulo = new Paragraph("Ticket de Compra - Vuelo", fontVerde);
            titulo.setAlignment(Element.ALIGN_CENTER); // Alinear el texto al centro
            documento.add(titulo); // Agregar al documento

            documento.add(new Paragraph("\n")); // Espacio entre título y tabla

            // Crear tabla para detalles del ticket
            PdfPTable tabla = new PdfPTable(2); // 2 columnas
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            // Encabezados de la tabla
            PdfPCell celdaEncabezado1 = new PdfPCell(new Phrase("Campo"));
            celdaEncabezado1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celdaEncabezado1.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell celdaEncabezado2 = new PdfPCell(new Phrase("Detalle"));
            celdaEncabezado2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celdaEncabezado2.setHorizontalAlignment(Element.ALIGN_CENTER);

            tabla.addCell(celdaEncabezado1);
            tabla.addCell(celdaEncabezado2);

            // Agregar filas con los detalles de la compra
            tabla.addCell("Cliente");
            tabla.addCell(cliente);

            tabla.addCell("Vuelo");
            tabla.addCell(vuelo);

            tabla.addCell("Precio");
            tabla.addCell("$" + precio);

            tabla.addCell("Asiento");
            tabla.addCell(asiento);

            tabla.addCell("Clase");
            tabla.addCell(clase);

            // Agregar la tabla al documento
            documento.add(tabla);

            // Agregar agradecimiento
            Paragraph agradecimiento = new Paragraph("Gracias por su compra.\n¡Buen viaje!", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK));
            agradecimiento.setAlignment(Element.ALIGN_CENTER);
            documento.add(agradecimiento);

            // Cerrar el documento
            documento.close();

            System.out.println("PDF generado correctamente en " + archivoRuta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
