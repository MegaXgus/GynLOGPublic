/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relatorios;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import modelos.classes.Movimentacao;
import persistencia.MovimentacaoDAO;

public class RelatorioMovimentacao {

    public void gerar() {
        try {
            MovimentacaoDAO dao = new MovimentacaoDAO();
            ArrayList<Movimentacao> lista = dao.listagemDeMovimentacoes();

            FileWriter fw = new FileWriter("Relatorio_Movimentacoes.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("RELATORIO DE MOVIMENTACOES");
            bw.newLine();
            bw.write("-----------------------------");
            bw.newLine();
            bw.newLine();

            for (Movimentacao m : lista) {
                bw.write("ID Movimentação: " + m.getIdMovimentacao());
                bw.newLine();
                bw.write("Veículo ID: " + m.getIdVeiculo());
                bw.newLine();
                bw.write("Tipo de Despesa ID: " + m.getIdTipoDespesa());
                bw.newLine();
                bw.write("Descrição: " + m.getDescricao());
                bw.newLine();
                bw.write("Data: " + m.getData());
                bw.newLine();
                bw.write("Valor: " + m.getValor());
                bw.newLine();
                bw.write("Status: " + m.getStatus());
                bw.newLine();
                bw.write("-----------------------------");
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}

