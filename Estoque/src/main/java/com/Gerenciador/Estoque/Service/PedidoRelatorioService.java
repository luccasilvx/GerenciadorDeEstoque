package com.Gerenciador.Estoque.Service;

import com.Gerenciador.Estoque.Models.Pedido;
import com.Gerenciador.Estoque.Repository.PedidoRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PedidoRelatorioService {

    @Autowired
    private PedidoRepository repository;

    public byte[] gerarRelatorioPedidos() throws IOException{
        //lista todos pedidos
        List<Pedido> pedidos = repository.findAll();

        //cria stream para armazenar o pdf em memória
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        //título do documento
        document.add(new Paragraph("Relatório de Pedidos").setBold().setFontSize(16));

        //tabela com 4 colunas
        float[] columnWidths = {100,150,100,100};
        Table table = new Table(columnWidths);

        //cabeçalho da tabela
        table.addHeaderCell(new Cell().add(new Paragraph("Id")));
        table.addHeaderCell(new Cell().add(new Paragraph("Cliente")));
        table.addHeaderCell(new Cell().add(new Paragraph("Status")));
        table.addHeaderCell(new Cell().add(new Paragraph("Total")));

        //adiciona pedidos na tabela
        for (Pedido pedido: pedidos){
            table.addCell(new Cell().add(new Paragraph(String.valueOf(pedido.getNumeroPedido()))));
            table.addCell(new Cell().add(new Paragraph(pedido.getClienteNome())));
            table.addCell(new Cell().add(new Paragraph(pedido.getStatus().name())));
            table.addCell(new Cell().add(new Paragraph(pedido.getTotal().toString())));
        }

        //adicionando documento na tabela
        document.add(table);
        document.close();

        //retorna o PDF em bytes
        return outputStream.toByteArray();
    }
}

