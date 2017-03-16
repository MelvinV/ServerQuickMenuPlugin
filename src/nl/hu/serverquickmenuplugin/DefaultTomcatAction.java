/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.serverquickmenuplugin;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "System",
        id = "nl.hu.serverquickmenuplugin.DefaultTomcatAction"
)
@ActionRegistration(
        iconBase = "nl/hu/serverquickmenuplugin/tomcat-16px.jpg",
        displayName = "#CTL_DefaultTomcatAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/GoTo", position = 0, separatorAfter = 50)
    ,
  @ActionReference(path = "Shortcuts", name = "DOS-Z")
})
@Messages("CTL_DefaultTomcatAction=Open Default Tomcat URL")
public final class DefaultTomcatAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) 
        {
            try {
                URI uri = new URI("http://localhost:8080");
                desktop.browse(uri);
            } 
            catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }
}
