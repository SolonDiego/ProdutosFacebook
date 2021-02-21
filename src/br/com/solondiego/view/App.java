package br.com.solondiego.view;

import br.com.solondiego.controller.GerarPlanilha;
import br.com.solondiego.model.Urls;

/**
 *
 * @author Solon Diego
 */
public class App {

    public static void main(String[] args) {
        int[] codigos = {5724, 5566, 5653, 5233, 5515, 4420, 282, 5381, 5604, 5355, 1114, 5482, 5408, 5017, 5491, 5389, 2212, 3767};             
        GerarPlanilha gp = new GerarPlanilha(codigos);
    }
}
