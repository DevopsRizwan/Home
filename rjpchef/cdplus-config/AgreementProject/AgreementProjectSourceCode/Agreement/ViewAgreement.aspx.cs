/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Agreement.WebHelper;

namespace Agreement
{
    public partial class ViewAgreement : BasePage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (SessionManager.AgreementType == "R")
            {
         
                ideligibillity.Visible = false;
            }
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID = 0;
            
            Response.Redirect("Home.Aspx");
        }
    }
}