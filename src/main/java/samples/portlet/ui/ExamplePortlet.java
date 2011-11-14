/**
 * Copyright (C) 2009 eXo Platform SAS.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package samples.portlet.ui;

import org.exoplatform.portal.config.model.PortalProperties;
import org.exoplatform.portal.webui.util.Util;
import org.exoplatform.portal.webui.workspace.UIPortalApplication;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Created by The eXo Platform SAS
 * Author : Nguyen Duc Khoi
 *          khoi.nguyen@exoplatform.com
 * Nov 11, 2011
 */
public class ExamplePortlet extends GenericPortlet
{
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      UIPortalApplication uiPortalApplication = Util.getUIPortalApplication();
      String sessionAlive = uiPortalApplication.getSessionAlive();
      if (sessionAlive == null)
      {
         sessionAlive = "never";
      }
      else
      {
         if (sessionAlive.equals(PortalProperties.SESSION_ALWAYS))
         {
            sessionAlive = "always";
         }
         else if (sessionAlive.equals(PortalProperties.SESSION_ON_DEMAND))
         {
            sessionAlive = "ondemand";
         }
         else
         {
            sessionAlive = "never";
         }
      }
      request.setAttribute("sessionAlive", sessionAlive);
      getPortletContext().getRequestDispatcher("/jsp/view.jsp").include(request, response);
   }
}
