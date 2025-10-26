package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.dto.EmprestimoDTO;
import br.com.ifrn.AtividadeJPA.dto.EmprestimosAtrasadosDTO;
import br.com.ifrn.AtividadeJPA.dto.LivrosEmprestadosDTO;
import br.com.ifrn.AtividadeJPA.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<EmprestimoDTO> createEmprestimo(@RequestBody EmprestimoDTO emprestimodto){
        return ResponseEntity.ok(emprestimoService.salvar(emprestimodto));
    }

    @GetMapping("/ativos/{usuarioId}")
    public ResponseEntity<List<LivrosEmprestadosDTO>> listarEmprestimosAtivos(@PathVariable int usuarioId) {
        List<LivrosEmprestadosDTO> emprestimos = emprestimoService.listarEmprestimosAtivosPorUsuario(usuarioId);
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/emprestimos_atrasados")
    public ResponseEntity<List<EmprestimosAtrasadosDTO>> BuscarEmprestimosAtrasados(){
        return ResponseEntity.ok(emprestimoService.listarEmprestimosAtrasados());
    }



}
