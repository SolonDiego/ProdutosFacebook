package br.com.solondiego.view;

import br.com.solondiego.controller.GerarPlanilha;
import br.com.solondiego.model.Urls;

/**
 *
 * @author Solon Diego
 */
public class App {

    public static void main(String[] args) {
        int[] codigos = {1576,5465,5402};             
        GerarPlanilha gp = new GerarPlanilha(codigos);
    }
}
