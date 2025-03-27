package com.hortifruti.utils;

import com.hortifruti.model.Pedido;
import com.hortifruti.model.ItemPedido;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public void gerarPdf(Pedido pedido) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("pedido_" + pedido.getId() + ".pdf"));
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
        document.add(new Paragraph("Pedido #" + pedido.getId(), font));
        document.add(new Paragraph("Cliente: " + pedido.getCliente()));
        document.add(new Paragraph("Telefone: " + pedido.getTelefone()));
        document.add(new Paragraph("Estado: " + pedido.getEstado()));
        document.add(new Paragraph("Data: " + pedido.getData()));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(6);
        table.addCell("Embalagem");
        table.addCell("Produto");
        table.addCell("Caixas");
        table.addCell("Mudas");
        table.addCell("Valor Unitário");
        table.addCell("Total");

        for (ItemPedido item : pedido.getItens()) {
            table.addCell(item.getEmbalagem());
            table.addCell(item.getProduto());
            table.addCell(String.valueOf(item.getQuantidade()));
            table.addCell(String.valueOf(item.getTotalMudas()));
            table.addCell("R$ " + item.getPreco());
            table.addCell("R$ " + item.getTotal());
        }

        document.add(table);
        document.add(new Paragraph("Total do Pedido: R$ " + pedido.getTotal()));
        document.close();
    }
}
