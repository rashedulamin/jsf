package de.hsm.localisation;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class GuiUtil {
	public static FacesMessage getFacesMessage(
            FacesContext ctx, FacesMessage.Severity severity, String msgKey, Object... args) {
		Locale loc = ctx.getViewRoot().getLocale();
		//ResourceBundle bundle = ResourceBundle.getBundle(
        //        ctx.getApplication().getMessageBundle(), loc);
		ResourceBundle bundle = ResourceBundle.getBundle("de/hsm/messages", loc);
		String msg = bundle.getString(msgKey);
		if (args != null) {
			MessageFormat format = new MessageFormat(msg);
			msg = format.format(args);
		}
		return new FacesMessage(severity, msg, null);
	}

}
