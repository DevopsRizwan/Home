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
using Agreement.BusinessEntity;
using Agreement.BusinessLogic;
using Agreement.WebHelper;

namespace Agreement
{
    public partial class LoginPage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            txtUserName.Focus();
            if (!IsPostBack)
            {
                if (Request.QueryString["msg"] != null)
                {
                    lblMsg.Text = Request.QueryString["msg"];
                }
            }
        }

        protected void btnSignin_Click(object sender, EventArgs e)
        {
            UsersEntity entity = new UsersEntity();
            entity.UserName = txtUserName.Text;
            entity.Password = txtPassword.Text;

            UsersBI usersBI = new UsersBI();
            entity = usersBI.ReadUsers(entity);
            if (entity != null)
            {
                SessionManager.UsersID = entity.UserID;
                SessionManager.UsersEntity = entity;
                Response.Redirect("Home.aspx");
            }
            else
            {
                ClientScript.RegisterStartupScript(Page.GetType(), "_Login_", "alert('Invalid Username and Password.');", true);
            }
        }
    }
}