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
using Agreement.BusinessLogic;
using System.Configuration;
using Agreement.WebHelper;

namespace Agreement
{
    public partial class Submit : BasePage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (SessionManager.AgreementType == "R")
            {
                LinkButton lnkEligibility = (LinkButton)Navigator1.FindControl("lnkEligibility");
                lnkEligibility.Visible = false;
            }
            //SessionManager.AgreementTypeID = 18;
        }

        protected void btnPrevious_Click(object sender, EventArgs e)
        {
            Response.Redirect("Approvers.aspx");
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            // int agreementID = SessionManager.AgreementTypeID
            SubmitBI submit = new SubmitBI();
            int submitionStatus = submit.Update(SessionManager.AgreementTypeID);
            if (submitionStatus == 1)
            {
                ClientScript.RegisterStartupScript(Page.GetType(), "__Submit__", "alert('Details Submitted.');", true);
                Response.Redirect("GoToHome.aspx");
            }
            else
            {
                ClientScript.RegisterStartupScript(Page.GetType(), "__Submit__", "alert('Some fields have to fill before submition of Agreement.');", true);
            }

        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            //chkAgreed.Checked = false;
            SessionManager.AgreementTypeID=0;
            Response.Redirect("Home.aspx");
        }
    }
}