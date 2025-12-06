/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relatorios;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import modelos.classes.Veiculo;
import persistencia.VeiculosDAO;

public class RelatorioVeiculos {

    public void gerar() {
        try {
            VeiculosDAO dao = new VeiculosDAO();
            ArrayList<Veiculo> lista = dao.listaDeVeiculos();

            FileWriter fw = new FileWriter("Relatorio_Veiculos.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("RELATORIO DE VEICULOS");
            bw.newLine();
            bw.write("-----------------------------");
            bw.newLine();
            bw.newLine();

            for (Veiculo v : lista) {
                bw.write("ID: " + v.getIdVeiculo());
                bw.newLine();
                bw.write("Placa: " + v.getPlaca());
                bw.newLine();
                bw.write("Marca: " + v.getMarca());
                bw.newLine();
                bw.write("Modelo: " + v.getModelo());
                bw.newLine();
                bw.write("Ano: " + v.getAnoFabricacao());
                bw.newLine();
                bw.write("Status: " + v.getStatus());
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

