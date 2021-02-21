package br.com.solondiego.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Solon Diego
 */
public class Urls {

    private String urlapi;
    private String aut;
    private String token;
    private String urlsite;
    private String pagina;

    public Urls(String arquivo) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] keys = linha.trim().split(";");
                this.urlapi = keys[0];
                this.aut = keys[1];
                this.token = keys[2];
                this.urlsite = keys[3];
                this.pagina = keys[4];
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Urls.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Urls.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Urls.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getUrlapi() {
        return urlapi;
    }

    public void setUrlapi(String urlapi) {
        this.urlapi = urlapi;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrlsite() {
        return urlsite;
    }

    public void setUrlsite(String urlsite) {
        this.urlsite = urlsite;
    }

    public String getAut() {
        return aut;
    }

    public void setAut(String aut) {
        this.aut = aut;
    }

}
