package com.launcher;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
    String root_url = "http://google.com";
    String agua_url = "http://google.com";
    String luz_url = "http://google.com";
    String gas_url = "http://google.com";

    public App() {
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            URL url = getClass().getResource("/images/icon.gif");
            TrayIcon trayIcon = new java.awt.TrayIcon(Toolkit.getDefaultToolkit().createImage(url));
            trayIcon.setToolTip("Energy");
            SystemTray tray = java.awt.SystemTray.getSystemTray();
            tray.add(trayIcon);

            trayIcon.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    launch(root_url);
                }
            });

            PopupMenu trayMenu = new java.awt.PopupMenu();

            MenuItem aguaItem = new java.awt.MenuItem("Agua");
            aguaItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    launch(agua_url);
                }
            });

            MenuItem luzItem = new java.awt.MenuItem("Luz");
            luzItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    launch(luz_url);
                }
            });

            MenuItem gasItem = new java.awt.MenuItem("Gas");
            gasItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    launch(gas_url);
                }
            });

            MenuItem exitItem = new java.awt.MenuItem("Salir");
            exitItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            trayMenu.add(aguaItem);
            trayMenu.add(luzItem);
            trayMenu.add(gasItem);
            trayMenu.add(exitItem);
            trayIcon.setPopupMenu(trayMenu);



        } catch (AWTException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void launch(String url) {
        try {
            java.net.URI uri = new java.net.URI(url);
            desktop.browse(uri);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new App();

    }
}
