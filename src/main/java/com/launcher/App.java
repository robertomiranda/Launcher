package com.launcher;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{   
    public App (){
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            URL url = getClass().getResource("/images/icon.gif");
            TrayIcon trayIcon = new java.awt.TrayIcon(Toolkit.getDefaultToolkit().createImage(url));
            trayIcon.setToolTip("Energy");
            SystemTray tray = java.awt.SystemTray.getSystemTray();
            tray.add(trayIcon);
            
            trayIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            PopupMenu trayMenu = new java.awt.PopupMenu();

            MenuItem aguaItem = new java.awt.MenuItem("Agua");
            aguaItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            MenuItem luzItem = new java.awt.MenuItem("Luz");
            luzItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            MenuItem gasItem = new java.awt.MenuItem("Gas");
            gasItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
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
            
            
            
        }catch (AWTException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main( String[] args )
    {
        new App();
        
    }
}
