﻿/*
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
    public partial class GoToHome : BasePage
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGoHome_Click(object sender, EventArgs e)
        {
          //  SessionManager.AgreementTypeID=0;
            Response.Redirect("Home.aspx");
        }

        
    }
}