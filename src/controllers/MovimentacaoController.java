package controllers;

import java.util.ArrayList;
import modelos.classes.Movimentacao;
import modelos.interfaces.IMovimentacaoCRUD;
import persistencia.MovimentacaoDAO;

public class MovimentacaoController {

    private IMovimentacaoCRUD MovimentacaoDAO;

    public MovimentacaoController() {
        MovimentacaoDAO = new MovimentacaoDAO();
    }

    // Cadastrar movimentação
    public void cadastrar(Movimentacao mov) throws Exception {
        if (mov.getIdMovimentacao() <= 0) {
            throw new Exception("ID da movimentação inválido!");
        }
        if (mov.getIdVeiculo() <= 0) {
            throw new Exception("ID do veículo inválido!");
        }
        if (mov.getIdTipoDespesa() <= 0) {
            throw new Exception("ID do tipo de despesa inválido!");
        }
        if (mov.getData().isEmpty()) {
            throw new Exception("Data não pode estar vazia!");
        }
        if (mov.getValor() <= 0) {
            throw new Exception("Valor inválido!");
        }
        MovimentacaoDAO.salvar(mov);
    }

   
    public ArrayList<Movimentacao> listar() throws Exception {
        return MovimentacaoDAO.listagemDeMovimentacoes();
    }

   
    public Movimentacao buscar(int id) throws Exception {
        return MovimentacaoDAO.buscarPorId(id);
    }

   
    public void atualizar(Movimentacao mov) throws Exception {
        MovimentacaoDAO.atualizar(mov);
    }

    
    public void remover(int id) throws Exception {
        MovimentacaoDAO.remover(id);
    }
}
