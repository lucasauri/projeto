package com.hortifruti.controller;

import com.hortifruti.model.Pedido;
import com.hortifruti.repository.PedidoRepository;
import com.hortifruti.utils.PdfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PdfService pdfService;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
        try {
            pdfService.gerarPdf(pedido);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao gerar PDF");
        }
        return ResponseEntity.ok("Pedido criado e PDF gerado!");
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
