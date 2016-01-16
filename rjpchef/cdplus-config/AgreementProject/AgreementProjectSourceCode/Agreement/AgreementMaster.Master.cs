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

namespace AgreementWeb
{
    public partial class AgreementMaster : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                lblUser.Text = SessionManager.UsersEntity.FirstName + ", " + SessionManager.UsersEntity.LastName;
                if (SessionManager.UsersEntity.UserType == "E")
                    ahrManageUsers.Visible = true;
                else
                    ahrManageUsers.Visible = false;
            }
        }

        protected void lnkbtnLogout_Click(object sender, EventArgs e)
        {
            Session.Clear();
            Session.Abandon();
            Response.Redirect("loginpage.aspx");

        }

        protected void lnkCreateAgreement_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID = 0;
            Response.Redirect("AgreementType.aspx");
        }


    }
}